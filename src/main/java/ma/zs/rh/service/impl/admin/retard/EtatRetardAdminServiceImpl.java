package ma.zs.rh.service.impl.admin.retard;


import ma.zs.rh.zynerator.exception.EntityNotFoundException;
import ma.zs.rh.bean.core.retard.EtatRetard;
import ma.zs.rh.dao.criteria.core.retard.EtatRetardCriteria;
import ma.zs.rh.dao.facade.core.retard.EtatRetardDao;
import ma.zs.rh.dao.specification.core.retard.EtatRetardSpecification;
import ma.zs.rh.service.facade.admin.retard.EtatRetardAdminService;
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
public class EtatRetardAdminServiceImpl implements EtatRetardAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public EtatRetard update(EtatRetard t) {
        EtatRetard loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{EtatRetard.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public EtatRetard findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public EtatRetard findOrSave(EtatRetard t) {
        if (t != null) {
            EtatRetard result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<EtatRetard> importData(List<EtatRetard> items) {
        List<EtatRetard> list = new ArrayList<>();
        for (EtatRetard t : items) {
            EtatRetard founded = findByReferenceEntity(t);
			if (founded == null) {
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<EtatRetard> findAll() {
        return dao.findAll();
    }

    public List<EtatRetard> findByCriteria(EtatRetardCriteria criteria) {
        List<EtatRetard> content = null;
        if (criteria != null) {
            EtatRetardSpecification mySpecification = constructSpecification(criteria);
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


    private EtatRetardSpecification constructSpecification(EtatRetardCriteria criteria) {
        EtatRetardSpecification mySpecification =  (EtatRetardSpecification) RefelexivityUtil.constructObjectUsingOneParam(EtatRetardSpecification.class, criteria);
        return mySpecification;
    }

    public List<EtatRetard> findPaginatedByCriteria(EtatRetardCriteria criteria, int page, int pageSize, String order, String sortField) {
        EtatRetardSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(EtatRetardCriteria criteria) {
        EtatRetardSpecification mySpecification = constructSpecification(criteria);
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
    public int delete(EtatRetard t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<EtatRetard> delete(List<EtatRetard> list) {
		List<EtatRetard> result = new ArrayList();
        if (list != null) {
            for (EtatRetard t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public EtatRetard create(EtatRetard t) {
        EtatRetard loaded = findByReferenceEntity(t);
        EtatRetard saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<EtatRetard> create(List<EtatRetard> ts) {
        List<EtatRetard> result = new ArrayList<>();
        if (ts != null) {
            for (EtatRetard t : ts) {
				EtatRetard created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public EtatRetard findWithAssociatedLists(Long id){
        EtatRetard result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<EtatRetard> update(List<EtatRetard> ts, boolean createIfNotExist) {
        List<EtatRetard> result = new ArrayList<>();
        if (ts != null) {
            for (EtatRetard t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    EtatRetard loadedItem = dao.findById(t.getId()).orElse(null);
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





    public EtatRetard findByReferenceEntity(EtatRetard t){
        return t==null? null : dao.findByRef(t.getRef());
    }



    public List<EtatRetard> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<EtatRetard>> getToBeSavedAndToBeDeleted(List<EtatRetard> oldList, List<EtatRetard> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<EtatRetard> importExcel(MultipartFile file) {
        return null;
    }









    private @Autowired EtatRetardDao dao;


}
