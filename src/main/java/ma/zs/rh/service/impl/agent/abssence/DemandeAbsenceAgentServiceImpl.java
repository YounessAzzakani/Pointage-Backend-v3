package ma.zs.rh.service.impl.agent.abssence;


import ma.zs.rh.zynerator.exception.EntityNotFoundException;
import ma.zs.rh.bean.core.abssence.DemandeAbsence;
import ma.zs.rh.dao.criteria.core.abssence.DemandeAbsenceCriteria;
import ma.zs.rh.dao.facade.core.abssence.DemandeAbsenceDao;
import ma.zs.rh.dao.specification.core.abssence.DemandeAbsenceSpecification;
import ma.zs.rh.service.facade.agent.abssence.DemandeAbsenceAgentService;
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

import ma.zs.rh.service.facade.agent.commun.AgentAgentService ;
import ma.zs.rh.bean.core.commun.Agent ;
import ma.zs.rh.service.facade.agent.abssence.RaisonAbsenceAgentService ;
import ma.zs.rh.bean.core.abssence.RaisonAbsence ;
import ma.zs.rh.service.facade.agent.abssence.EtatDemandeAbsenceAgentService ;
import ma.zs.rh.bean.core.abssence.EtatDemandeAbsence ;
import ma.zs.rh.service.facade.agent.commun.EntiteAdministrativeAgentService ;
import ma.zs.rh.bean.core.commun.EntiteAdministrative ;
import ma.zs.rh.service.facade.agent.abssence.MotifRejetDemandeAbsenceAgentService ;
import ma.zs.rh.bean.core.abssence.MotifRejetDemandeAbsence ;

import java.util.List;
@Service
public class DemandeAbsenceAgentServiceImpl implements DemandeAbsenceAgentService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public DemandeAbsence update(DemandeAbsence t) {
        DemandeAbsence loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{DemandeAbsence.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public DemandeAbsence findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public DemandeAbsence findOrSave(DemandeAbsence t) {
        if (t != null) {
            findOrSaveAssociatedObject(t);
            DemandeAbsence result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<DemandeAbsence> importData(List<DemandeAbsence> items) {
        List<DemandeAbsence> list = new ArrayList<>();
        for (DemandeAbsence t : items) {
            DemandeAbsence founded = findByReferenceEntity(t);
			if (founded == null) {
				findOrSaveAssociatedObject(t);
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<DemandeAbsence> findAll() {
        return dao.findAll();
    }

    public List<DemandeAbsence> findByCriteria(DemandeAbsenceCriteria criteria) {
        List<DemandeAbsence> content = null;
        if (criteria != null) {
            DemandeAbsenceSpecification mySpecification = constructSpecification(criteria);
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


    private DemandeAbsenceSpecification constructSpecification(DemandeAbsenceCriteria criteria) {
        DemandeAbsenceSpecification mySpecification =  (DemandeAbsenceSpecification) RefelexivityUtil.constructObjectUsingOneParam(DemandeAbsenceSpecification.class, criteria);
        return mySpecification;
    }

    public List<DemandeAbsence> findPaginatedByCriteria(DemandeAbsenceCriteria criteria, int page, int pageSize, String order, String sortField) {
        DemandeAbsenceSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(DemandeAbsenceCriteria criteria) {
        DemandeAbsenceSpecification mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
    }

    public List<DemandeAbsence> findByMotifRejetDemandeAbsenceId(Long id){
        return dao.findByMotifRejetDemandeAbsenceId(id);
    }
    public int deleteByMotifRejetDemandeAbsenceId(Long id){
        return dao.deleteByMotifRejetDemandeAbsenceId(id);
    }
    public long countByMotifRejetDemandeAbsenceRef(String ref){
        return dao.countByMotifRejetDemandeAbsenceRef(ref);
    }
    public List<DemandeAbsence> findByEntiteAdministrativeId(Long id){
        return dao.findByEntiteAdministrativeId(id);
    }
    public int deleteByEntiteAdministrativeId(Long id){
        return dao.deleteByEntiteAdministrativeId(id);
    }
    public long countByEntiteAdministrativeRef(String ref){
        return dao.countByEntiteAdministrativeRef(ref);
    }
    public List<DemandeAbsence> findByManagerId(Long id){
        return dao.findByManagerId(id);
    }
    public int deleteByManagerId(Long id){
        return dao.deleteByManagerId(id);
    }
    public long countByManagerRef(String ref){
        return dao.countByManagerRef(ref);
    }
    public List<DemandeAbsence> findByAgentId(Long id){
        return dao.findByAgentId(id);
    }
    public int deleteByAgentId(Long id){
        return dao.deleteByAgentId(id);
    }
    public long countByAgentRef(String ref){
        return dao.countByAgentRef(ref);
    }
    public List<DemandeAbsence> findByRaisonAbsenceId(Long id){
        return dao.findByRaisonAbsenceId(id);
    }
    public int deleteByRaisonAbsenceId(Long id){
        return dao.deleteByRaisonAbsenceId(id);
    }
    public long countByRaisonAbsenceRef(String ref){
        return dao.countByRaisonAbsenceRef(ref);
    }
    public List<DemandeAbsence> findByEtatDemandeAbsenceId(Long id){
        return dao.findByEtatDemandeAbsenceId(id);
    }
    public int deleteByEtatDemandeAbsenceId(Long id){
        return dao.deleteByEtatDemandeAbsenceId(id);
    }
    public long countByEtatDemandeAbsenceRef(String ref){
        return dao.countByEtatDemandeAbsenceRef(ref);
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
    public int delete(DemandeAbsence t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<DemandeAbsence> delete(List<DemandeAbsence> list) {
		List<DemandeAbsence> result = new ArrayList();
        if (list != null) {
            for (DemandeAbsence t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public DemandeAbsence create(DemandeAbsence t) {
        DemandeAbsence loaded = findByReferenceEntity(t);
        DemandeAbsence saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<DemandeAbsence> create(List<DemandeAbsence> ts) {
        List<DemandeAbsence> result = new ArrayList<>();
        if (ts != null) {
            for (DemandeAbsence t : ts) {
				DemandeAbsence created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public DemandeAbsence findWithAssociatedLists(Long id){
        DemandeAbsence result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<DemandeAbsence> update(List<DemandeAbsence> ts, boolean createIfNotExist) {
        List<DemandeAbsence> result = new ArrayList<>();
        if (ts != null) {
            for (DemandeAbsence t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    DemandeAbsence loadedItem = dao.findById(t.getId()).orElse(null);
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





    public DemandeAbsence findByReferenceEntity(DemandeAbsence t){
        return t==null? null : dao.findByRef(t.getRef());
    }
    public void findOrSaveAssociatedObject(DemandeAbsence t){
        if( t != null) {
            t.setMotifRejetDemandeAbsence(motifRejetDemandeAbsenceService.findOrSave(t.getMotifRejetDemandeAbsence()));
            t.setEntiteAdministrative(entiteAdministrativeService.findOrSave(t.getEntiteAdministrative()));
            t.setManager(agentService.findOrSave(t.getManager()));
            t.setAgent(agentService.findOrSave(t.getAgent()));
            t.setRaisonAbsence(raisonAbsenceService.findOrSave(t.getRaisonAbsence()));
            t.setEtatDemandeAbsence(etatDemandeAbsenceService.findOrSave(t.getEtatDemandeAbsence()));
        }
    }



    public List<DemandeAbsence> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<DemandeAbsence>> getToBeSavedAndToBeDeleted(List<DemandeAbsence> oldList, List<DemandeAbsence> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<DemandeAbsence> importExcel(MultipartFile file) {
        return null;
    }








    @Autowired
    private AgentAgentService agentService ;
    @Autowired
    private RaisonAbsenceAgentService raisonAbsenceService ;
    @Autowired
    private EtatDemandeAbsenceAgentService etatDemandeAbsenceService ;
    @Autowired
    private EntiteAdministrativeAgentService entiteAdministrativeService ;
    @Autowired
    private MotifRejetDemandeAbsenceAgentService motifRejetDemandeAbsenceService ;

    private @Autowired DemandeAbsenceDao dao;


}
