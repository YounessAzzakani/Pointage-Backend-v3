package ma.zs.rh.service.impl.agent.heuresupp;


import ma.zs.rh.zbiblio.exception.EntityNotFoundException;
import ma.zs.rh.bean.core.heuresupp.TypeHeureSupplementaire;
import ma.zs.rh.dao.criteria.core.heuresupp.TypeHeureSupplementaireCriteria;
import ma.zs.rh.dao.facade.core.heuresupp.TypeHeureSupplementaireDao;
import ma.zs.rh.dao.specification.core.heuresupp.TypeHeureSupplementaireSpecification;
import ma.zs.rh.service.facade.agent.heuresupp.TypeHeureSupplementaireAgentService;
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
public class TypeHeureSupplementaireAgentServiceImpl implements TypeHeureSupplementaireAgentService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public TypeHeureSupplementaire update(TypeHeureSupplementaire t) {
        TypeHeureSupplementaire loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{TypeHeureSupplementaire.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public TypeHeureSupplementaire findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public TypeHeureSupplementaire findOrSave(TypeHeureSupplementaire t) {
        if (t != null) {
            TypeHeureSupplementaire result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<TypeHeureSupplementaire> importData(List<TypeHeureSupplementaire> items) {
        List<TypeHeureSupplementaire> list = new ArrayList<>();
        for (TypeHeureSupplementaire t : items) {
            TypeHeureSupplementaire founded = findByReferenceEntity(t);
			if (founded == null) {
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<TypeHeureSupplementaire> findAll() {
        return dao.findAll();
    }

    public List<TypeHeureSupplementaire> findByCriteria(TypeHeureSupplementaireCriteria criteria) {
        List<TypeHeureSupplementaire> content = null;
        if (criteria != null) {
            TypeHeureSupplementaireSpecification mySpecification = constructSpecification(criteria);
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


    private TypeHeureSupplementaireSpecification constructSpecification(TypeHeureSupplementaireCriteria criteria) {
        TypeHeureSupplementaireSpecification mySpecification =  (TypeHeureSupplementaireSpecification) RefelexivityUtil.constructObjectUsingOneParam(TypeHeureSupplementaireSpecification.class, criteria);
        return mySpecification;
    }

    public List<TypeHeureSupplementaire> findPaginatedByCriteria(TypeHeureSupplementaireCriteria criteria, int page, int pageSize, String order, String sortField) {
        TypeHeureSupplementaireSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(TypeHeureSupplementaireCriteria criteria) {
        TypeHeureSupplementaireSpecification mySpecification = constructSpecification(criteria);
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
    public int delete(TypeHeureSupplementaire t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<TypeHeureSupplementaire> delete(List<TypeHeureSupplementaire> list) {
		List<TypeHeureSupplementaire> result = new ArrayList();
        if (list != null) {
            for (TypeHeureSupplementaire t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public TypeHeureSupplementaire create(TypeHeureSupplementaire t) {
        TypeHeureSupplementaire loaded = findByReferenceEntity(t);
        TypeHeureSupplementaire saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<TypeHeureSupplementaire> create(List<TypeHeureSupplementaire> ts) {
        List<TypeHeureSupplementaire> result = new ArrayList<>();
        if (ts != null) {
            for (TypeHeureSupplementaire t : ts) {
				TypeHeureSupplementaire created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public TypeHeureSupplementaire findWithAssociatedLists(Long id){
        TypeHeureSupplementaire result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<TypeHeureSupplementaire> update(List<TypeHeureSupplementaire> ts, boolean createIfNotExist) {
        List<TypeHeureSupplementaire> result = new ArrayList<>();
        if (ts != null) {
            for (TypeHeureSupplementaire t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    TypeHeureSupplementaire loadedItem = dao.findById(t.getId()).orElse(null);
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





    public TypeHeureSupplementaire findByReferenceEntity(TypeHeureSupplementaire t){
        return t==null? null : dao.findByRef(t.getRef());
    }



    public List<TypeHeureSupplementaire> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<TypeHeureSupplementaire>> getToBeSavedAndToBeDeleted(List<TypeHeureSupplementaire> oldList, List<TypeHeureSupplementaire> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<TypeHeureSupplementaire> importExcel(MultipartFile file) {
        return null;
    }









    private @Autowired TypeHeureSupplementaireDao dao;


}
