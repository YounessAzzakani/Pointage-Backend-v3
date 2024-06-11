package ma.zs.rh.service.impl.admin.pointage;


import ma.zs.rh.zbiblio.exception.EntityNotFoundException;
import ma.zs.rh.bean.core.pointage.PointageSens;
import ma.zs.rh.dao.criteria.core.pointage.PointageSensCriteria;
import ma.zs.rh.dao.facade.core.pointage.PointageSensDao;
import ma.zs.rh.dao.specification.core.pointage.PointageSensSpecification;
import ma.zs.rh.service.facade.admin.pointage.PointageSensAdminService;
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
public class PointageSensAdminServiceImpl implements PointageSensAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public PointageSens update(PointageSens t) {
        PointageSens loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{PointageSens.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public PointageSens findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public PointageSens findOrSave(PointageSens t) {
        if (t != null) {
            PointageSens result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<PointageSens> importData(List<PointageSens> items) {
        List<PointageSens> list = new ArrayList<>();
        for (PointageSens t : items) {
            PointageSens founded = findByReferenceEntity(t);
			if (founded == null) {
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<PointageSens> findAll() {
        return dao.findAll();
    }

    public List<PointageSens> findByCriteria(PointageSensCriteria criteria) {
        List<PointageSens> content = null;
        if (criteria != null) {
            PointageSensSpecification mySpecification = constructSpecification(criteria);
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


    private PointageSensSpecification constructSpecification(PointageSensCriteria criteria) {
        PointageSensSpecification mySpecification =  (PointageSensSpecification) RefelexivityUtil.constructObjectUsingOneParam(PointageSensSpecification.class, criteria);
        return mySpecification;
    }

    public List<PointageSens> findPaginatedByCriteria(PointageSensCriteria criteria, int page, int pageSize, String order, String sortField) {
        PointageSensSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(PointageSensCriteria criteria) {
        PointageSensSpecification mySpecification = constructSpecification(criteria);
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
    public int delete(PointageSens t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<PointageSens> delete(List<PointageSens> list) {
		List<PointageSens> result = new ArrayList();
        if (list != null) {
            for (PointageSens t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public PointageSens create(PointageSens t) {
        PointageSens loaded = findByReferenceEntity(t);
        PointageSens saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<PointageSens> create(List<PointageSens> ts) {
        List<PointageSens> result = new ArrayList<>();
        if (ts != null) {
            for (PointageSens t : ts) {
				PointageSens created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public PointageSens findWithAssociatedLists(Long id){
        PointageSens result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<PointageSens> update(List<PointageSens> ts, boolean createIfNotExist) {
        List<PointageSens> result = new ArrayList<>();
        if (ts != null) {
            for (PointageSens t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    PointageSens loadedItem = dao.findById(t.getId()).orElse(null);
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





    public PointageSens findByReferenceEntity(PointageSens t){
        return t==null? null : dao.findByRef(t.getRef());
    }



    public List<PointageSens> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<PointageSens>> getToBeSavedAndToBeDeleted(List<PointageSens> oldList, List<PointageSens> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<PointageSens> importExcel(MultipartFile file) {
        return null;
    }









    private @Autowired PointageSensDao dao;


}
