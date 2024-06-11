package ma.zs.rh.service.impl.admin.retard;


import ma.zs.rh.zbiblio.exception.EntityNotFoundException;
import ma.zs.rh.bean.core.retard.Retard;
import ma.zs.rh.dao.criteria.core.retard.RetardCriteria;
import ma.zs.rh.dao.facade.core.retard.RetardDao;
import ma.zs.rh.dao.specification.core.retard.RetardSpecification;
import ma.zs.rh.service.facade.admin.retard.RetardAdminService;
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

import ma.zs.rh.service.facade.admin.commun.AgentAdminService ;
import ma.zs.rh.service.facade.admin.retard.EtatRetardAdminService ;
import ma.zs.rh.service.facade.admin.retard.JustificationRetardAdminService ;

@Service
public class RetardAdminServiceImpl implements RetardAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Retard update(Retard t) {
        Retard loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{Retard.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public Retard findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public Retard findOrSave(Retard t) {
        if (t != null) {
            findOrSaveAssociatedObject(t);
            Retard result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<Retard> importData(List<Retard> items) {
        List<Retard> list = new ArrayList<>();
        for (Retard t : items) {
            Retard founded = findByReferenceEntity(t);
			if (founded == null) {
				findOrSaveAssociatedObject(t);
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<Retard> findAll() {
        return dao.findAll();
    }

    public List<Retard> findByCriteria(RetardCriteria criteria) {
        List<Retard> content = null;
        if (criteria != null) {
            RetardSpecification mySpecification = constructSpecification(criteria);
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


    private RetardSpecification constructSpecification(RetardCriteria criteria) {
        RetardSpecification mySpecification =  (RetardSpecification) RefelexivityUtil.constructObjectUsingOneParam(RetardSpecification.class, criteria);
        return mySpecification;
    }

    public List<Retard> findPaginatedByCriteria(RetardCriteria criteria, int page, int pageSize, String order, String sortField) {
        RetardSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(RetardCriteria criteria) {
        RetardSpecification mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
    }

    public List<Retard> findByAgentId(Long id){
        return dao.findByAgentId(id);
    }
    public int deleteByAgentId(Long id){
        return dao.deleteByAgentId(id);
    }
    public long countByAgentRef(String ref){
        return dao.countByAgentRef(ref);
    }
    public List<Retard> findByEtatRetardId(Long id){
        return dao.findByEtatRetardId(id);
    }
    public int deleteByEtatRetardId(Long id){
        return dao.deleteByEtatRetardId(id);
    }
    public long countByEtatRetardRef(String ref){
        return dao.countByEtatRetardRef(ref);
    }
    public List<Retard> findByJustificationRetardId(Long id){
        return dao.findByJustificationRetardId(id);
    }
    public int deleteByJustificationRetardId(Long id){
        return dao.deleteByJustificationRetardId(id);
    }
    public long countByJustificationRetardRef(String ref){
        return dao.countByJustificationRetardRef(ref);
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
    public int delete(Retard t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Retard> delete(List<Retard> list) {
		List<Retard> result = new ArrayList();
        if (list != null) {
            for (Retard t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Retard create(Retard t) {
        Retard loaded = findByReferenceEntity(t);
        Retard saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Retard> create(List<Retard> ts) {
        List<Retard> result = new ArrayList<>();
        if (ts != null) {
            for (Retard t : ts) {
				Retard created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public Retard findWithAssociatedLists(Long id){
        Retard result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Retard> update(List<Retard> ts, boolean createIfNotExist) {
        List<Retard> result = new ArrayList<>();
        if (ts != null) {
            for (Retard t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    Retard loadedItem = dao.findById(t.getId()).orElse(null);
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





    public Retard findByReferenceEntity(Retard t){
        return t==null? null : dao.findByRef(t.getRef());
    }
    public void findOrSaveAssociatedObject(Retard t){
        if( t != null) {
            t.setAgent(agentService.findOrSave(t.getAgent()));
            t.setEtatRetard(etatRetardService.findOrSave(t.getEtatRetard()));
            t.setJustificationRetard(justificationRetardService.findOrSave(t.getJustificationRetard()));
        }
    }



    public List<Retard> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<Retard>> getToBeSavedAndToBeDeleted(List<Retard> oldList, List<Retard> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<Retard> importExcel(MultipartFile file) {
        return null;
    }








    @Autowired
    private AgentAdminService agentService ;
    @Autowired
    private EtatRetardAdminService etatRetardService ;
    @Autowired
    private JustificationRetardAdminService justificationRetardService ;

    private @Autowired RetardDao dao;


}
