package ma.zs.rh.service.impl.agent.commun;


import ma.zs.rh.zbiblio.exception.EntityNotFoundException;
import ma.zs.rh.bean.core.commun.PaiementAgent;
import ma.zs.rh.dao.criteria.core.commun.PaiementAgentCriteria;
import ma.zs.rh.dao.facade.core.commun.PaiementAgentDao;
import ma.zs.rh.dao.specification.core.commun.PaiementAgentSpecification;
import ma.zs.rh.service.facade.agent.commun.PaiementAgentAgentService;
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

import ma.zs.rh.service.facade.agent.commun.PosteAgentService ;

@Service
public class PaiementAgentAgentServiceImpl implements PaiementAgentAgentService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public PaiementAgent update(PaiementAgent t) {
        PaiementAgent loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{PaiementAgent.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public PaiementAgent findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public PaiementAgent findOrSave(PaiementAgent t) {
        if (t != null) {
            findOrSaveAssociatedObject(t);
            PaiementAgent result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<PaiementAgent> importData(List<PaiementAgent> items) {
        List<PaiementAgent> list = new ArrayList<>();
        for (PaiementAgent t : items) {
            PaiementAgent founded = findByReferenceEntity(t);
			if (founded == null) {
				findOrSaveAssociatedObject(t);
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<PaiementAgent> findAll() {
        return dao.findAll();
    }

    public List<PaiementAgent> findByCriteria(PaiementAgentCriteria criteria) {
        List<PaiementAgent> content = null;
        if (criteria != null) {
            PaiementAgentSpecification mySpecification = constructSpecification(criteria);
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


    private PaiementAgentSpecification constructSpecification(PaiementAgentCriteria criteria) {
        PaiementAgentSpecification mySpecification =  (PaiementAgentSpecification) RefelexivityUtil.constructObjectUsingOneParam(PaiementAgentSpecification.class, criteria);
        return mySpecification;
    }

    public List<PaiementAgent> findPaginatedByCriteria(PaiementAgentCriteria criteria, int page, int pageSize, String order, String sortField) {
        PaiementAgentSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(PaiementAgentCriteria criteria) {
        PaiementAgentSpecification mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
    }

    public List<PaiementAgent> findByAgentId(Long id){
        return dao.findByAgentId(id);
    }
    public int deleteByAgentId(Long id){
        return dao.deleteByAgentId(id);
    }
    public long countByAgentRef(String ref){
        return dao.countByAgentRef(ref);
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
    public int delete(PaiementAgent t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<PaiementAgent> delete(List<PaiementAgent> list) {
		List<PaiementAgent> result = new ArrayList();
        if (list != null) {
            for (PaiementAgent t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public PaiementAgent create(PaiementAgent t) {
        PaiementAgent loaded = findByReferenceEntity(t);
        PaiementAgent saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<PaiementAgent> create(List<PaiementAgent> ts) {
        List<PaiementAgent> result = new ArrayList<>();
        if (ts != null) {
            for (PaiementAgent t : ts) {
				PaiementAgent created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public PaiementAgent findWithAssociatedLists(Long id){
        PaiementAgent result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<PaiementAgent> update(List<PaiementAgent> ts, boolean createIfNotExist) {
        List<PaiementAgent> result = new ArrayList<>();
        if (ts != null) {
            for (PaiementAgent t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    PaiementAgent loadedItem = dao.findById(t.getId()).orElse(null);
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





    public PaiementAgent findByReferenceEntity(PaiementAgent t){
        return t==null? null : dao.findByRef(t.getRef());
    }
    public void findOrSaveAssociatedObject(PaiementAgent t){
        if( t != null) {
            t.setAgent(posteService.findOrSave(t.getAgent()));
        }
    }



    public List<PaiementAgent> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<PaiementAgent>> getToBeSavedAndToBeDeleted(List<PaiementAgent> oldList, List<PaiementAgent> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<PaiementAgent> importExcel(MultipartFile file) {
        return null;
    }








    @Autowired
    private PosteAgentService posteService ;

    private @Autowired PaiementAgentDao dao;


}
