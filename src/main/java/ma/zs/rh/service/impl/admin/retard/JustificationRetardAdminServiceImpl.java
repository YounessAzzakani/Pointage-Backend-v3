package ma.zs.rh.service.impl.admin.retard;


import ma.zs.rh.zynerator.exception.EntityNotFoundException;
import ma.zs.rh.bean.core.retard.JustificationRetard;
import ma.zs.rh.dao.criteria.core.retard.JustificationRetardCriteria;
import ma.zs.rh.dao.facade.core.retard.JustificationRetardDao;
import ma.zs.rh.dao.specification.core.retard.JustificationRetardSpecification;
import ma.zs.rh.service.facade.admin.retard.JustificationRetardAdminService;
import ma.zs.rh.zynerator.service.AbstractServiceImpl;
import ma.zs.rh.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;

import ma.zs.rh.zynerator.util.RefelexivityUtil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
public class JustificationRetardAdminServiceImpl implements JustificationRetardAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public JustificationRetard update(JustificationRetard t) {
        JustificationRetard loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{JustificationRetard.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public JustificationRetard findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public JustificationRetard findOrSave(JustificationRetard t) {
        if (t != null) {
            JustificationRetard result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<JustificationRetard> importData(List<JustificationRetard> items) {
        List<JustificationRetard> list = new ArrayList<>();
        for (JustificationRetard t : items) {
            JustificationRetard founded = findByReferenceEntity(t);
			if (founded == null) {
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<JustificationRetard> findAll() {
        return dao.findAll();
    }

    public List<JustificationRetard> findByCriteria(JustificationRetardCriteria criteria) {
        List<JustificationRetard> content = null;
        if (criteria != null) {
            JustificationRetardSpecification mySpecification = constructSpecification(criteria);
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


    private JustificationRetardSpecification constructSpecification(JustificationRetardCriteria criteria) {
        JustificationRetardSpecification mySpecification =  (JustificationRetardSpecification) RefelexivityUtil.constructObjectUsingOneParam(JustificationRetardSpecification.class, criteria);
        return mySpecification;
    }

    public List<JustificationRetard> findPaginatedByCriteria(JustificationRetardCriteria criteria, int page, int pageSize, String order, String sortField) {
        JustificationRetardSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(JustificationRetardCriteria criteria) {
        JustificationRetardSpecification mySpecification = constructSpecification(criteria);
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
    public int delete(JustificationRetard t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<JustificationRetard> delete(List<JustificationRetard> list) {
		List<JustificationRetard> result = new ArrayList();
        if (list != null) {
            for (JustificationRetard t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public JustificationRetard create(JustificationRetard t) {
        JustificationRetard loaded = findByReferenceEntity(t);
        JustificationRetard saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<JustificationRetard> create(List<JustificationRetard> ts) {
        List<JustificationRetard> result = new ArrayList<>();
        if (ts != null) {
            for (JustificationRetard t : ts) {
				JustificationRetard created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public JustificationRetard findWithAssociatedLists(Long id){
        JustificationRetard result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<JustificationRetard> update(List<JustificationRetard> ts, boolean createIfNotExist) {
        List<JustificationRetard> result = new ArrayList<>();
        if (ts != null) {
            for (JustificationRetard t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    JustificationRetard loadedItem = dao.findById(t.getId()).orElse(null);
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





    public JustificationRetard findByReferenceEntity(JustificationRetard t){
        return t==null? null : dao.findByRef(t.getRef());
    }



    public List<JustificationRetard> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<JustificationRetard>> getToBeSavedAndToBeDeleted(List<JustificationRetard> oldList, List<JustificationRetard> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<JustificationRetard> importExcel(MultipartFile file) {
        return null;
    }









    private @Autowired JustificationRetardDao dao;


}
