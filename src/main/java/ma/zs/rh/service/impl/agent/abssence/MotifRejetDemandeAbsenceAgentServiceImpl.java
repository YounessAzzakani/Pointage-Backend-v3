package ma.zs.rh.service.impl.agent.abssence;


import ma.zs.rh.zbiblio.exception.EntityNotFoundException;
import ma.zs.rh.bean.core.abssence.MotifRejetDemandeAbsence;
import ma.zs.rh.dao.criteria.core.abssence.MotifRejetDemandeAbsenceCriteria;
import ma.zs.rh.dao.facade.core.abssence.MotifRejetDemandeAbsenceDao;
import ma.zs.rh.dao.specification.core.abssence.MotifRejetDemandeAbsenceSpecification;
import ma.zs.rh.service.facade.agent.abssence.MotifRejetDemandeAbsenceAgentService;
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
public class MotifRejetDemandeAbsenceAgentServiceImpl implements MotifRejetDemandeAbsenceAgentService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public MotifRejetDemandeAbsence update(MotifRejetDemandeAbsence t) {
        MotifRejetDemandeAbsence loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{MotifRejetDemandeAbsence.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public MotifRejetDemandeAbsence findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public MotifRejetDemandeAbsence findOrSave(MotifRejetDemandeAbsence t) {
        if (t != null) {
            MotifRejetDemandeAbsence result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<MotifRejetDemandeAbsence> importData(List<MotifRejetDemandeAbsence> items) {
        List<MotifRejetDemandeAbsence> list = new ArrayList<>();
        for (MotifRejetDemandeAbsence t : items) {
            MotifRejetDemandeAbsence founded = findByReferenceEntity(t);
			if (founded == null) {
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<MotifRejetDemandeAbsence> findAll() {
        return dao.findAll();
    }

    public List<MotifRejetDemandeAbsence> findByCriteria(MotifRejetDemandeAbsenceCriteria criteria) {
        List<MotifRejetDemandeAbsence> content = null;
        if (criteria != null) {
            MotifRejetDemandeAbsenceSpecification mySpecification = constructSpecification(criteria);
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


    private MotifRejetDemandeAbsenceSpecification constructSpecification(MotifRejetDemandeAbsenceCriteria criteria) {
        MotifRejetDemandeAbsenceSpecification mySpecification =  (MotifRejetDemandeAbsenceSpecification) RefelexivityUtil.constructObjectUsingOneParam(MotifRejetDemandeAbsenceSpecification.class, criteria);
        return mySpecification;
    }

    public List<MotifRejetDemandeAbsence> findPaginatedByCriteria(MotifRejetDemandeAbsenceCriteria criteria, int page, int pageSize, String order, String sortField) {
        MotifRejetDemandeAbsenceSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(MotifRejetDemandeAbsenceCriteria criteria) {
        MotifRejetDemandeAbsenceSpecification mySpecification = constructSpecification(criteria);
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
    public int delete(MotifRejetDemandeAbsence t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<MotifRejetDemandeAbsence> delete(List<MotifRejetDemandeAbsence> list) {
		List<MotifRejetDemandeAbsence> result = new ArrayList();
        if (list != null) {
            for (MotifRejetDemandeAbsence t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public MotifRejetDemandeAbsence create(MotifRejetDemandeAbsence t) {
        MotifRejetDemandeAbsence loaded = findByReferenceEntity(t);
        MotifRejetDemandeAbsence saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<MotifRejetDemandeAbsence> create(List<MotifRejetDemandeAbsence> ts) {
        List<MotifRejetDemandeAbsence> result = new ArrayList<>();
        if (ts != null) {
            for (MotifRejetDemandeAbsence t : ts) {
				MotifRejetDemandeAbsence created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public MotifRejetDemandeAbsence findWithAssociatedLists(Long id){
        MotifRejetDemandeAbsence result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<MotifRejetDemandeAbsence> update(List<MotifRejetDemandeAbsence> ts, boolean createIfNotExist) {
        List<MotifRejetDemandeAbsence> result = new ArrayList<>();
        if (ts != null) {
            for (MotifRejetDemandeAbsence t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    MotifRejetDemandeAbsence loadedItem = dao.findById(t.getId()).orElse(null);
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





    public MotifRejetDemandeAbsence findByReferenceEntity(MotifRejetDemandeAbsence t){
        return t==null? null : dao.findByRef(t.getRef());
    }



    public List<MotifRejetDemandeAbsence> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<MotifRejetDemandeAbsence>> getToBeSavedAndToBeDeleted(List<MotifRejetDemandeAbsence> oldList, List<MotifRejetDemandeAbsence> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<MotifRejetDemandeAbsence> importExcel(MultipartFile file) {
        return null;
    }









    private @Autowired MotifRejetDemandeAbsenceDao dao;


}
