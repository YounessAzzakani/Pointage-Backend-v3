package ma.zs.rh.service.impl.agent.pointage;


import ma.zs.rh.zbiblio.exception.EntityNotFoundException;
import ma.zs.rh.bean.core.pointage.Pointeuse;
import ma.zs.rh.dao.criteria.core.pointage.PointeuseCriteria;
import ma.zs.rh.dao.facade.core.pointage.PointeuseDao;
import ma.zs.rh.dao.specification.core.pointage.PointeuseSpecification;
import ma.zs.rh.service.facade.agent.pointage.PointeuseAgentService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;

import ma.zs.rh.zbiblio.util.RefelexivityUtil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PointeuseAgentServiceImpl implements PointeuseAgentService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Pointeuse update(Pointeuse t) {
        Pointeuse loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{Pointeuse.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public Pointeuse findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public Pointeuse findOrSave(Pointeuse t) {
        if (t != null) {
            Pointeuse result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<Pointeuse> importData(List<Pointeuse> items) {
        List<Pointeuse> list = new ArrayList<>();
        for (Pointeuse t : items) {
            Pointeuse founded = findByReferenceEntity(t);
			if (founded == null) {
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<Pointeuse> findAll() {
        return dao.findAll();
    }

    public List<Pointeuse> findByCriteria(PointeuseCriteria criteria) {
        List<Pointeuse> content = null;
        if (criteria != null) {
            PointeuseSpecification mySpecification = constructSpecification(criteria);
            if (criteria.isPeagable()) {
                Pageable pageable = PageRequest.of(0, criteria.getMaxResults());
                content = dao.findAll(mySpecification, pageable).getContent();
            } else {
                content = dao.findAll(mySpecification);
            }
        } else {
            content = dao.findAll();
        }
        return content;

    }


    private PointeuseSpecification constructSpecification(PointeuseCriteria criteria) {
        PointeuseSpecification mySpecification =  (PointeuseSpecification) RefelexivityUtil.constructObjectUsingOneParam(PointeuseSpecification.class, criteria);
        return mySpecification;
    }

    public List<Pointeuse> findPaginatedByCriteria(PointeuseCriteria criteria, int page, int pageSize, String order, String sortField) {
        PointeuseSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(PointeuseCriteria criteria) {
        PointeuseSpecification mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
    }


	public boolean deleteById(Long id) {
        boolean condition = deleteByIdCheckCondition(id);
        if (condition) {
            dao.deleteById(id);
        }
        return condition;
    }

    public boolean deleteByIdCheckCondition(Long id) {
        return true;
    }

    public void deleteByIdIn(List<Long> ids) {
        //dao.deleteByIdIn(ids);
    }
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public int delete(Pointeuse t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Pointeuse> delete(List<Pointeuse> list) {
		List<Pointeuse> result = new ArrayList();
        if (list != null) {
            for (Pointeuse t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Pointeuse create(Pointeuse t) {
        Pointeuse loaded = findByReferenceEntity(t);
        Pointeuse saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Pointeuse> create(List<Pointeuse> ts) {
        List<Pointeuse> result = new ArrayList<>();
        if (ts != null) {
            for (Pointeuse t : ts) {
				Pointeuse created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public Pointeuse findWithAssociatedLists(Long id){
        Pointeuse result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Pointeuse> update(List<Pointeuse> ts, boolean createIfNotExist) {
        List<Pointeuse> result = new ArrayList<>();
        if (ts != null) {
            for (Pointeuse t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    Pointeuse loadedItem = dao.findById(t.getId()).orElse(null);
                    if (createIfNotExist && (t.getId() == null || loadedItem == null)) {
                        dao.save(t);
                    } else if (t.getId() != null && loadedItem != null) {
                        dao.save(t);
                    } else {
                        result.add(t);
                    }
                }
            }
        }
        return result;
    }





    public Pointeuse findByReferenceEntity(Pointeuse t){
        return t==null? null : dao.findByRef(t.getRef());
    }



    public List<Pointeuse> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<Pointeuse>> getToBeSavedAndToBeDeleted(List<Pointeuse> oldList, List<Pointeuse> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<Pointeuse> importExcel(MultipartFile file) {
        return null;
    }









    private @Autowired PointeuseDao dao;


}
