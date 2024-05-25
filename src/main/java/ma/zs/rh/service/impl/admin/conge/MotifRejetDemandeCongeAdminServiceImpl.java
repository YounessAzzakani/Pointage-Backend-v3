package ma.zs.rh.service.impl.admin.conge;


import ma.zs.rh.zynerator.exception.EntityNotFoundException;
import ma.zs.rh.bean.core.conge.MotifRejetDemandeConge;
import ma.zs.rh.dao.criteria.core.conge.MotifRejetDemandeCongeCriteria;
import ma.zs.rh.dao.facade.core.conge.MotifRejetDemandeCongeDao;
import ma.zs.rh.dao.specification.core.conge.MotifRejetDemandeCongeSpecification;
import ma.zs.rh.service.facade.admin.conge.MotifRejetDemandeCongeAdminService;
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
public class MotifRejetDemandeCongeAdminServiceImpl implements MotifRejetDemandeCongeAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public MotifRejetDemandeConge update(MotifRejetDemandeConge t) {
        MotifRejetDemandeConge loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{MotifRejetDemandeConge.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public MotifRejetDemandeConge findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public MotifRejetDemandeConge findOrSave(MotifRejetDemandeConge t) {
        if (t != null) {
            MotifRejetDemandeConge result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<MotifRejetDemandeConge> importData(List<MotifRejetDemandeConge> items) {
        List<MotifRejetDemandeConge> list = new ArrayList<>();
        for (MotifRejetDemandeConge t : items) {
            MotifRejetDemandeConge founded = findByReferenceEntity(t);
			if (founded == null) {
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<MotifRejetDemandeConge> findAll() {
        return dao.findAll();
    }

    public List<MotifRejetDemandeConge> findByCriteria(MotifRejetDemandeCongeCriteria criteria) {
        List<MotifRejetDemandeConge> content = null;
        if (criteria != null) {
            MotifRejetDemandeCongeSpecification mySpecification = constructSpecification(criteria);
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


    private MotifRejetDemandeCongeSpecification constructSpecification(MotifRejetDemandeCongeCriteria criteria) {
        MotifRejetDemandeCongeSpecification mySpecification =  (MotifRejetDemandeCongeSpecification) RefelexivityUtil.constructObjectUsingOneParam(MotifRejetDemandeCongeSpecification.class, criteria);
        return mySpecification;
    }

    public List<MotifRejetDemandeConge> findPaginatedByCriteria(MotifRejetDemandeCongeCriteria criteria, int page, int pageSize, String order, String sortField) {
        MotifRejetDemandeCongeSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(MotifRejetDemandeCongeCriteria criteria) {
        MotifRejetDemandeCongeSpecification mySpecification = constructSpecification(criteria);
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
    public int delete(MotifRejetDemandeConge t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<MotifRejetDemandeConge> delete(List<MotifRejetDemandeConge> list) {
		List<MotifRejetDemandeConge> result = new ArrayList();
        if (list != null) {
            for (MotifRejetDemandeConge t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public MotifRejetDemandeConge create(MotifRejetDemandeConge t) {
        MotifRejetDemandeConge loaded = findByReferenceEntity(t);
        MotifRejetDemandeConge saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<MotifRejetDemandeConge> create(List<MotifRejetDemandeConge> ts) {
        List<MotifRejetDemandeConge> result = new ArrayList<>();
        if (ts != null) {
            for (MotifRejetDemandeConge t : ts) {
				MotifRejetDemandeConge created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public MotifRejetDemandeConge findWithAssociatedLists(Long id){
        MotifRejetDemandeConge result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<MotifRejetDemandeConge> update(List<MotifRejetDemandeConge> ts, boolean createIfNotExist) {
        List<MotifRejetDemandeConge> result = new ArrayList<>();
        if (ts != null) {
            for (MotifRejetDemandeConge t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    MotifRejetDemandeConge loadedItem = dao.findById(t.getId()).orElse(null);
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





    public MotifRejetDemandeConge findByReferenceEntity(MotifRejetDemandeConge t){
        return t==null? null : dao.findByRef(t.getRef());
    }



    public List<MotifRejetDemandeConge> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<MotifRejetDemandeConge>> getToBeSavedAndToBeDeleted(List<MotifRejetDemandeConge> oldList, List<MotifRejetDemandeConge> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<MotifRejetDemandeConge> importExcel(MultipartFile file) {
        return null;
    }









    private @Autowired MotifRejetDemandeCongeDao dao;


}
