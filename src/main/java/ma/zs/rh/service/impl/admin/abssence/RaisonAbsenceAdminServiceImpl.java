package ma.zs.rh.service.impl.admin.abssence;


import ma.zs.rh.zbiblio.exception.EntityNotFoundException;
import ma.zs.rh.bean.core.abssence.RaisonAbsence;
import ma.zs.rh.dao.criteria.core.abssence.RaisonAbsenceCriteria;
import ma.zs.rh.dao.facade.core.abssence.RaisonAbsenceDao;
import ma.zs.rh.dao.specification.core.abssence.RaisonAbsenceSpecification;
import ma.zs.rh.service.facade.admin.abssence.RaisonAbsenceAdminService;
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
public class RaisonAbsenceAdminServiceImpl implements RaisonAbsenceAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public RaisonAbsence update(RaisonAbsence t) {
        RaisonAbsence loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{RaisonAbsence.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public RaisonAbsence findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public RaisonAbsence findOrSave(RaisonAbsence t) {
        if (t != null) {
            RaisonAbsence result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<RaisonAbsence> importData(List<RaisonAbsence> items) {
        List<RaisonAbsence> list = new ArrayList<>();
        for (RaisonAbsence t : items) {
            RaisonAbsence founded = findByReferenceEntity(t);
			if (founded == null) {
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<RaisonAbsence> findAll() {
        return dao.findAll();
    }

    public List<RaisonAbsence> findByCriteria(RaisonAbsenceCriteria criteria) {
        List<RaisonAbsence> content = null;
        if (criteria != null) {
            RaisonAbsenceSpecification mySpecification = constructSpecification(criteria);
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


    private RaisonAbsenceSpecification constructSpecification(RaisonAbsenceCriteria criteria) {
        RaisonAbsenceSpecification mySpecification =  (RaisonAbsenceSpecification) RefelexivityUtil.constructObjectUsingOneParam(RaisonAbsenceSpecification.class, criteria);
        return mySpecification;
    }

    public List<RaisonAbsence> findPaginatedByCriteria(RaisonAbsenceCriteria criteria, int page, int pageSize, String order, String sortField) {
        RaisonAbsenceSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(RaisonAbsenceCriteria criteria) {
        RaisonAbsenceSpecification mySpecification = constructSpecification(criteria);
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
    public int delete(RaisonAbsence t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<RaisonAbsence> delete(List<RaisonAbsence> list) {
		List<RaisonAbsence> result = new ArrayList();
        if (list != null) {
            for (RaisonAbsence t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public RaisonAbsence create(RaisonAbsence t) {
        RaisonAbsence loaded = findByReferenceEntity(t);
        RaisonAbsence saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<RaisonAbsence> create(List<RaisonAbsence> ts) {
        List<RaisonAbsence> result = new ArrayList<>();
        if (ts != null) {
            for (RaisonAbsence t : ts) {
				RaisonAbsence created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public RaisonAbsence findWithAssociatedLists(Long id){
        RaisonAbsence result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<RaisonAbsence> update(List<RaisonAbsence> ts, boolean createIfNotExist) {
        List<RaisonAbsence> result = new ArrayList<>();
        if (ts != null) {
            for (RaisonAbsence t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    RaisonAbsence loadedItem = dao.findById(t.getId()).orElse(null);
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





    public RaisonAbsence findByReferenceEntity(RaisonAbsence t){
        return t==null? null : dao.findByRef(t.getRef());
    }



    public List<RaisonAbsence> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<RaisonAbsence>> getToBeSavedAndToBeDeleted(List<RaisonAbsence> oldList, List<RaisonAbsence> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<RaisonAbsence> importExcel(MultipartFile file) {
        return null;
    }









    private @Autowired RaisonAbsenceDao dao;


}
