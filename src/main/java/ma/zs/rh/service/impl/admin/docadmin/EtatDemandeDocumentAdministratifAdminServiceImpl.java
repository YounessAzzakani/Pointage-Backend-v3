package ma.zs.rh.service.impl.admin.docadmin;


import ma.zs.rh.zbiblio.exception.EntityNotFoundException;
import ma.zs.rh.bean.core.docadmin.EtatDemandeDocumentAdministratif;
import ma.zs.rh.dao.criteria.core.docadmin.EtatDemandeDocumentAdministratifCriteria;
import ma.zs.rh.dao.facade.core.docadmin.EtatDemandeDocumentAdministratifDao;
import ma.zs.rh.dao.specification.core.docadmin.EtatDemandeDocumentAdministratifSpecification;
import ma.zs.rh.service.facade.admin.docadmin.EtatDemandeDocumentAdministratifAdminService;
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
public class EtatDemandeDocumentAdministratifAdminServiceImpl implements EtatDemandeDocumentAdministratifAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public EtatDemandeDocumentAdministratif update(EtatDemandeDocumentAdministratif t) {
        EtatDemandeDocumentAdministratif loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{EtatDemandeDocumentAdministratif.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public EtatDemandeDocumentAdministratif findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public EtatDemandeDocumentAdministratif findOrSave(EtatDemandeDocumentAdministratif t) {
        if (t != null) {
            EtatDemandeDocumentAdministratif result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<EtatDemandeDocumentAdministratif> importData(List<EtatDemandeDocumentAdministratif> items) {
        List<EtatDemandeDocumentAdministratif> list = new ArrayList<>();
        for (EtatDemandeDocumentAdministratif t : items) {
            EtatDemandeDocumentAdministratif founded = findByReferenceEntity(t);
			if (founded == null) {
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<EtatDemandeDocumentAdministratif> findAll() {
        return dao.findAll();
    }

    public List<EtatDemandeDocumentAdministratif> findByCriteria(EtatDemandeDocumentAdministratifCriteria criteria) {
        List<EtatDemandeDocumentAdministratif> content = null;
        if (criteria != null) {
            EtatDemandeDocumentAdministratifSpecification mySpecification = constructSpecification(criteria);
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


    private EtatDemandeDocumentAdministratifSpecification constructSpecification(EtatDemandeDocumentAdministratifCriteria criteria) {
        EtatDemandeDocumentAdministratifSpecification mySpecification =  (EtatDemandeDocumentAdministratifSpecification) RefelexivityUtil.constructObjectUsingOneParam(EtatDemandeDocumentAdministratifSpecification.class, criteria);
        return mySpecification;
    }

    public List<EtatDemandeDocumentAdministratif> findPaginatedByCriteria(EtatDemandeDocumentAdministratifCriteria criteria, int page, int pageSize, String order, String sortField) {
        EtatDemandeDocumentAdministratifSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(EtatDemandeDocumentAdministratifCriteria criteria) {
        EtatDemandeDocumentAdministratifSpecification mySpecification = constructSpecification(criteria);
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
    public int delete(EtatDemandeDocumentAdministratif t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<EtatDemandeDocumentAdministratif> delete(List<EtatDemandeDocumentAdministratif> list) {
		List<EtatDemandeDocumentAdministratif> result = new ArrayList();
        if (list != null) {
            for (EtatDemandeDocumentAdministratif t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public EtatDemandeDocumentAdministratif create(EtatDemandeDocumentAdministratif t) {
        EtatDemandeDocumentAdministratif loaded = findByReferenceEntity(t);
        EtatDemandeDocumentAdministratif saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<EtatDemandeDocumentAdministratif> create(List<EtatDemandeDocumentAdministratif> ts) {
        List<EtatDemandeDocumentAdministratif> result = new ArrayList<>();
        if (ts != null) {
            for (EtatDemandeDocumentAdministratif t : ts) {
				EtatDemandeDocumentAdministratif created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public EtatDemandeDocumentAdministratif findWithAssociatedLists(Long id){
        EtatDemandeDocumentAdministratif result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<EtatDemandeDocumentAdministratif> update(List<EtatDemandeDocumentAdministratif> ts, boolean createIfNotExist) {
        List<EtatDemandeDocumentAdministratif> result = new ArrayList<>();
        if (ts != null) {
            for (EtatDemandeDocumentAdministratif t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    EtatDemandeDocumentAdministratif loadedItem = dao.findById(t.getId()).orElse(null);
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





    public EtatDemandeDocumentAdministratif findByReferenceEntity(EtatDemandeDocumentAdministratif t){
        return t==null? null : dao.findByRef(t.getRef());
    }



    public List<EtatDemandeDocumentAdministratif> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<EtatDemandeDocumentAdministratif>> getToBeSavedAndToBeDeleted(List<EtatDemandeDocumentAdministratif> oldList, List<EtatDemandeDocumentAdministratif> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<EtatDemandeDocumentAdministratif> importExcel(MultipartFile file) {
        return null;
    }









    private @Autowired EtatDemandeDocumentAdministratifDao dao;


}
