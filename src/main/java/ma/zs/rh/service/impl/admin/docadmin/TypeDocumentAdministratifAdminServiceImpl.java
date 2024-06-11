package ma.zs.rh.service.impl.admin.docadmin;


import ma.zs.rh.zbiblio.exception.EntityNotFoundException;
import ma.zs.rh.bean.core.docadmin.TypeDocumentAdministratif;
import ma.zs.rh.dao.criteria.core.docadmin.TypeDocumentAdministratifCriteria;
import ma.zs.rh.dao.facade.core.docadmin.TypeDocumentAdministratifDao;
import ma.zs.rh.dao.specification.core.docadmin.TypeDocumentAdministratifSpecification;
import ma.zs.rh.service.facade.admin.docadmin.TypeDocumentAdministratifAdminService;
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
public class TypeDocumentAdministratifAdminServiceImpl implements TypeDocumentAdministratifAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public TypeDocumentAdministratif update(TypeDocumentAdministratif t) {
        TypeDocumentAdministratif loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{TypeDocumentAdministratif.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public TypeDocumentAdministratif findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public TypeDocumentAdministratif findOrSave(TypeDocumentAdministratif t) {
        if (t != null) {
            TypeDocumentAdministratif result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<TypeDocumentAdministratif> importData(List<TypeDocumentAdministratif> items) {
        List<TypeDocumentAdministratif> list = new ArrayList<>();
        for (TypeDocumentAdministratif t : items) {
            TypeDocumentAdministratif founded = findByReferenceEntity(t);
			if (founded == null) {
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<TypeDocumentAdministratif> findAll() {
        return dao.findAll();
    }

    public List<TypeDocumentAdministratif> findByCriteria(TypeDocumentAdministratifCriteria criteria) {
        List<TypeDocumentAdministratif> content = null;
        if (criteria != null) {
            TypeDocumentAdministratifSpecification mySpecification = constructSpecification(criteria);
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


    private TypeDocumentAdministratifSpecification constructSpecification(TypeDocumentAdministratifCriteria criteria) {
        TypeDocumentAdministratifSpecification mySpecification =  (TypeDocumentAdministratifSpecification) RefelexivityUtil.constructObjectUsingOneParam(TypeDocumentAdministratifSpecification.class, criteria);
        return mySpecification;
    }

    public List<TypeDocumentAdministratif> findPaginatedByCriteria(TypeDocumentAdministratifCriteria criteria, int page, int pageSize, String order, String sortField) {
        TypeDocumentAdministratifSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(TypeDocumentAdministratifCriteria criteria) {
        TypeDocumentAdministratifSpecification mySpecification = constructSpecification(criteria);
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
    public int delete(TypeDocumentAdministratif t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<TypeDocumentAdministratif> delete(List<TypeDocumentAdministratif> list) {
		List<TypeDocumentAdministratif> result = new ArrayList();
        if (list != null) {
            for (TypeDocumentAdministratif t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public TypeDocumentAdministratif create(TypeDocumentAdministratif t) {
        TypeDocumentAdministratif loaded = findByReferenceEntity(t);
        TypeDocumentAdministratif saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<TypeDocumentAdministratif> create(List<TypeDocumentAdministratif> ts) {
        List<TypeDocumentAdministratif> result = new ArrayList<>();
        if (ts != null) {
            for (TypeDocumentAdministratif t : ts) {
				TypeDocumentAdministratif created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public TypeDocumentAdministratif findWithAssociatedLists(Long id){
        TypeDocumentAdministratif result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<TypeDocumentAdministratif> update(List<TypeDocumentAdministratif> ts, boolean createIfNotExist) {
        List<TypeDocumentAdministratif> result = new ArrayList<>();
        if (ts != null) {
            for (TypeDocumentAdministratif t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    TypeDocumentAdministratif loadedItem = dao.findById(t.getId()).orElse(null);
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





    public TypeDocumentAdministratif findByReferenceEntity(TypeDocumentAdministratif t){
        return t==null? null : dao.findByRef(t.getRef());
    }



    public List<TypeDocumentAdministratif> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<TypeDocumentAdministratif>> getToBeSavedAndToBeDeleted(List<TypeDocumentAdministratif> oldList, List<TypeDocumentAdministratif> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<TypeDocumentAdministratif> importExcel(MultipartFile file) {
        return null;
    }









    private @Autowired TypeDocumentAdministratifDao dao;


}
