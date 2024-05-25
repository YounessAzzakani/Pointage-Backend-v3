package ma.zs.rh.service.impl.admin.abssence;


import ma.zs.rh.zynerator.exception.EntityNotFoundException;
import ma.zs.rh.bean.core.abssence.EtatDemandeAbsence;
import ma.zs.rh.dao.criteria.core.abssence.EtatDemandeAbsenceCriteria;
import ma.zs.rh.dao.facade.core.abssence.EtatDemandeAbsenceDao;
import ma.zs.rh.dao.specification.core.abssence.EtatDemandeAbsenceSpecification;
import ma.zs.rh.service.facade.admin.abssence.EtatDemandeAbsenceAdminService;
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
public class EtatDemandeAbsenceAdminServiceImpl implements EtatDemandeAbsenceAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public EtatDemandeAbsence update(EtatDemandeAbsence t) {
        EtatDemandeAbsence loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{EtatDemandeAbsence.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public EtatDemandeAbsence findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public EtatDemandeAbsence findOrSave(EtatDemandeAbsence t) {
        if (t != null) {
            EtatDemandeAbsence result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<EtatDemandeAbsence> importData(List<EtatDemandeAbsence> items) {
        List<EtatDemandeAbsence> list = new ArrayList<>();
        for (EtatDemandeAbsence t : items) {
            EtatDemandeAbsence founded = findByReferenceEntity(t);
			if (founded == null) {
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<EtatDemandeAbsence> findAll() {
        return dao.findAll();
    }

    public List<EtatDemandeAbsence> findByCriteria(EtatDemandeAbsenceCriteria criteria) {
        List<EtatDemandeAbsence> content = null;
        if (criteria != null) {
            EtatDemandeAbsenceSpecification mySpecification = constructSpecification(criteria);
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


    private EtatDemandeAbsenceSpecification constructSpecification(EtatDemandeAbsenceCriteria criteria) {
        EtatDemandeAbsenceSpecification mySpecification =  (EtatDemandeAbsenceSpecification) RefelexivityUtil.constructObjectUsingOneParam(EtatDemandeAbsenceSpecification.class, criteria);
        return mySpecification;
    }

    public List<EtatDemandeAbsence> findPaginatedByCriteria(EtatDemandeAbsenceCriteria criteria, int page, int pageSize, String order, String sortField) {
        EtatDemandeAbsenceSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(EtatDemandeAbsenceCriteria criteria) {
        EtatDemandeAbsenceSpecification mySpecification = constructSpecification(criteria);
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
    public int delete(EtatDemandeAbsence t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<EtatDemandeAbsence> delete(List<EtatDemandeAbsence> list) {
		List<EtatDemandeAbsence> result = new ArrayList();
        if (list != null) {
            for (EtatDemandeAbsence t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public EtatDemandeAbsence create(EtatDemandeAbsence t) {
        EtatDemandeAbsence loaded = findByReferenceEntity(t);
        EtatDemandeAbsence saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<EtatDemandeAbsence> create(List<EtatDemandeAbsence> ts) {
        List<EtatDemandeAbsence> result = new ArrayList<>();
        if (ts != null) {
            for (EtatDemandeAbsence t : ts) {
				EtatDemandeAbsence created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public EtatDemandeAbsence findWithAssociatedLists(Long id){
        EtatDemandeAbsence result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<EtatDemandeAbsence> update(List<EtatDemandeAbsence> ts, boolean createIfNotExist) {
        List<EtatDemandeAbsence> result = new ArrayList<>();
        if (ts != null) {
            for (EtatDemandeAbsence t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    EtatDemandeAbsence loadedItem = dao.findById(t.getId()).orElse(null);
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





    public EtatDemandeAbsence findByReferenceEntity(EtatDemandeAbsence t){
        return t==null? null : dao.findByRef(t.getRef());
    }



    public List<EtatDemandeAbsence> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<EtatDemandeAbsence>> getToBeSavedAndToBeDeleted(List<EtatDemandeAbsence> oldList, List<EtatDemandeAbsence> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<EtatDemandeAbsence> importExcel(MultipartFile file) {
        return null;
    }









    private @Autowired EtatDemandeAbsenceDao dao;


}
