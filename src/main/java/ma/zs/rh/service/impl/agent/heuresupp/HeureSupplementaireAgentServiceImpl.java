package ma.zs.rh.service.impl.agent.heuresupp;


import ma.zs.rh.zynerator.exception.EntityNotFoundException;
import ma.zs.rh.bean.core.heuresupp.HeureSupplementaire;
import ma.zs.rh.dao.criteria.core.heuresupp.HeureSupplementaireCriteria;
import ma.zs.rh.dao.facade.core.heuresupp.HeureSupplementaireDao;
import ma.zs.rh.dao.specification.core.heuresupp.HeureSupplementaireSpecification;
import ma.zs.rh.service.facade.agent.heuresupp.HeureSupplementaireAgentService;
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
import ma.zs.rh.service.facade.agent.commun.EntiteAdministrativeAgentService ;
import ma.zs.rh.bean.core.commun.EntiteAdministrative ;
import ma.zs.rh.service.facade.agent.heuresupp.EtatTypeHeureSupplementaireAgentService ;
import ma.zs.rh.bean.core.heuresupp.EtatTypeHeureSupplementaire ;
import ma.zs.rh.service.facade.agent.heuresupp.TypeHeureSupplementaireAgentService ;
import ma.zs.rh.bean.core.heuresupp.TypeHeureSupplementaire ;

import java.util.List;
@Service
public class HeureSupplementaireAgentServiceImpl implements HeureSupplementaireAgentService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public HeureSupplementaire update(HeureSupplementaire t) {
        HeureSupplementaire loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{HeureSupplementaire.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public HeureSupplementaire findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public HeureSupplementaire findOrSave(HeureSupplementaire t) {
        if (t != null) {
            findOrSaveAssociatedObject(t);
            HeureSupplementaire result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<HeureSupplementaire> importData(List<HeureSupplementaire> items) {
        List<HeureSupplementaire> list = new ArrayList<>();
        for (HeureSupplementaire t : items) {
            HeureSupplementaire founded = findByReferenceEntity(t);
			if (founded == null) {
				findOrSaveAssociatedObject(t);
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<HeureSupplementaire> findAll() {
        return dao.findAll();
    }

    public List<HeureSupplementaire> findByCriteria(HeureSupplementaireCriteria criteria) {
        List<HeureSupplementaire> content = null;
        if (criteria != null) {
            HeureSupplementaireSpecification mySpecification = constructSpecification(criteria);
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


    private HeureSupplementaireSpecification constructSpecification(HeureSupplementaireCriteria criteria) {
        HeureSupplementaireSpecification mySpecification =  (HeureSupplementaireSpecification) RefelexivityUtil.constructObjectUsingOneParam(HeureSupplementaireSpecification.class, criteria);
        return mySpecification;
    }

    public List<HeureSupplementaire> findPaginatedByCriteria(HeureSupplementaireCriteria criteria, int page, int pageSize, String order, String sortField) {
        HeureSupplementaireSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(HeureSupplementaireCriteria criteria) {
        HeureSupplementaireSpecification mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
    }

    public List<HeureSupplementaire> findByTypeHeureSupplementaireId(Long id){
        return dao.findByTypeHeureSupplementaireId(id);
    }
    public int deleteByTypeHeureSupplementaireId(Long id){
        return dao.deleteByTypeHeureSupplementaireId(id);
    }
    public long countByTypeHeureSupplementaireRef(String ref){
        return dao.countByTypeHeureSupplementaireRef(ref);
    }
    public List<HeureSupplementaire> findByAgentId(Long id){
        return dao.findByAgentId(id);
    }
    public int deleteByAgentId(Long id){
        return dao.deleteByAgentId(id);
    }
    public long countByAgentRef(String ref){
        return dao.countByAgentRef(ref);
    }
    public List<HeureSupplementaire> findByEtatTypeHeureSupplementaireId(Long id){
        return dao.findByEtatTypeHeureSupplementaireId(id);
    }
    public int deleteByEtatTypeHeureSupplementaireId(Long id){
        return dao.deleteByEtatTypeHeureSupplementaireId(id);
    }
    public long countByEtatTypeHeureSupplementaireRef(String ref){
        return dao.countByEtatTypeHeureSupplementaireRef(ref);
    }
    public List<HeureSupplementaire> findByEntiteAdministrativeId(Long id){
        return dao.findByEntiteAdministrativeId(id);
    }
    public int deleteByEntiteAdministrativeId(Long id){
        return dao.deleteByEntiteAdministrativeId(id);
    }
    public long countByEntiteAdministrativeRef(String ref){
        return dao.countByEntiteAdministrativeRef(ref);
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
    public int delete(HeureSupplementaire t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<HeureSupplementaire> delete(List<HeureSupplementaire> list) {
		List<HeureSupplementaire> result = new ArrayList();
        if (list != null) {
            for (HeureSupplementaire t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public HeureSupplementaire create(HeureSupplementaire t) {
        HeureSupplementaire loaded = findByReferenceEntity(t);
        HeureSupplementaire saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<HeureSupplementaire> create(List<HeureSupplementaire> ts) {
        List<HeureSupplementaire> result = new ArrayList<>();
        if (ts != null) {
            for (HeureSupplementaire t : ts) {
				HeureSupplementaire created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public HeureSupplementaire findWithAssociatedLists(Long id){
        HeureSupplementaire result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<HeureSupplementaire> update(List<HeureSupplementaire> ts, boolean createIfNotExist) {
        List<HeureSupplementaire> result = new ArrayList<>();
        if (ts != null) {
            for (HeureSupplementaire t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    HeureSupplementaire loadedItem = dao.findById(t.getId()).orElse(null);
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





    public HeureSupplementaire findByReferenceEntity(HeureSupplementaire t){
        return t==null? null : dao.findByRef(t.getRef());
    }
    public void findOrSaveAssociatedObject(HeureSupplementaire t){
        if( t != null) {
            t.setTypeHeureSupplementaire(typeHeureSupplementaireService.findOrSave(t.getTypeHeureSupplementaire()));
            t.setAgent(agentService.findOrSave(t.getAgent()));
            t.setEtatTypeHeureSupplementaire(etatTypeHeureSupplementaireService.findOrSave(t.getEtatTypeHeureSupplementaire()));
            t.setEntiteAdministrative(entiteAdministrativeService.findOrSave(t.getEntiteAdministrative()));
        }
    }



    public List<HeureSupplementaire> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<HeureSupplementaire>> getToBeSavedAndToBeDeleted(List<HeureSupplementaire> oldList, List<HeureSupplementaire> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<HeureSupplementaire> importExcel(MultipartFile file) {
        return null;
    }








    @Autowired
    private AgentAgentService agentService ;
    @Autowired
    private EntiteAdministrativeAgentService entiteAdministrativeService ;
    @Autowired
    private EtatTypeHeureSupplementaireAgentService etatTypeHeureSupplementaireService ;
    @Autowired
    private TypeHeureSupplementaireAgentService typeHeureSupplementaireService ;

    private @Autowired HeureSupplementaireDao dao;


}
