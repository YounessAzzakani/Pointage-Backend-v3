package ma.zs.rh.service.impl.admin.conge;


import ma.zs.rh.zynerator.exception.EntityNotFoundException;
import ma.zs.rh.bean.core.conge.RaisonConge;
import ma.zs.rh.dao.criteria.core.conge.RaisonCongeCriteria;
import ma.zs.rh.dao.facade.core.conge.RaisonCongeDao;
import ma.zs.rh.dao.specification.core.conge.RaisonCongeSpecification;
import ma.zs.rh.service.facade.admin.conge.RaisonCongeAdminService;
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
public class RaisonCongeAdminServiceImpl implements RaisonCongeAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public RaisonConge update(RaisonConge t) {
        RaisonConge loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{RaisonConge.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public RaisonConge findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public RaisonConge findOrSave(RaisonConge t) {
        if (t != null) {
            RaisonConge result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<RaisonConge> importData(List<RaisonConge> items) {
        List<RaisonConge> list = new ArrayList<>();
        for (RaisonConge t : items) {
            RaisonConge founded = findByReferenceEntity(t);
			if (founded == null) {
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<RaisonConge> findAll() {
        return dao.findAll();
    }

    public List<RaisonConge> findByCriteria(RaisonCongeCriteria criteria) {
        List<RaisonConge> content = null;
        if (criteria != null) {
            RaisonCongeSpecification mySpecification = constructSpecification(criteria);
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


    private RaisonCongeSpecification constructSpecification(RaisonCongeCriteria criteria) {
        RaisonCongeSpecification mySpecification =  (RaisonCongeSpecification) RefelexivityUtil.constructObjectUsingOneParam(RaisonCongeSpecification.class, criteria);
        return mySpecification;
    }

    public List<RaisonConge> findPaginatedByCriteria(RaisonCongeCriteria criteria, int page, int pageSize, String order, String sortField) {
        RaisonCongeSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(RaisonCongeCriteria criteria) {
        RaisonCongeSpecification mySpecification = constructSpecification(criteria);
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
    public int delete(RaisonConge t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<RaisonConge> delete(List<RaisonConge> list) {
		List<RaisonConge> result = new ArrayList();
        if (list != null) {
            for (RaisonConge t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public RaisonConge create(RaisonConge t) {
        RaisonConge loaded = findByReferenceEntity(t);
        RaisonConge saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<RaisonConge> create(List<RaisonConge> ts) {
        List<RaisonConge> result = new ArrayList<>();
        if (ts != null) {
            for (RaisonConge t : ts) {
				RaisonConge created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public RaisonConge findWithAssociatedLists(Long id){
        RaisonConge result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<RaisonConge> update(List<RaisonConge> ts, boolean createIfNotExist) {
        List<RaisonConge> result = new ArrayList<>();
        if (ts != null) {
            for (RaisonConge t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    RaisonConge loadedItem = dao.findById(t.getId()).orElse(null);
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





    public RaisonConge findByReferenceEntity(RaisonConge t){
        return t==null? null : dao.findByRef(t.getRef());
    }



    public List<RaisonConge> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<RaisonConge>> getToBeSavedAndToBeDeleted(List<RaisonConge> oldList, List<RaisonConge> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<RaisonConge> importExcel(MultipartFile file) {
        return null;
    }









    private @Autowired RaisonCongeDao dao;


}
