package ma.zs.rh.service.impl.agent.docadmin;


import ma.zs.rh.zynerator.exception.EntityNotFoundException;
import ma.zs.rh.bean.core.docadmin.DemandeDocumentAdministratif;
import ma.zs.rh.dao.criteria.core.docadmin.DemandeDocumentAdministratifCriteria;
import ma.zs.rh.dao.facade.core.docadmin.DemandeDocumentAdministratifDao;
import ma.zs.rh.dao.specification.core.docadmin.DemandeDocumentAdministratifSpecification;
import ma.zs.rh.service.facade.agent.docadmin.DemandeDocumentAdministratifAgentService;
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
import ma.zs.rh.service.facade.agent.docadmin.EtatDemandeDocumentAdministratifAgentService ;
import ma.zs.rh.bean.core.docadmin.EtatDemandeDocumentAdministratif ;
import ma.zs.rh.service.facade.agent.commun.EntiteAdministrativeAgentService ;
import ma.zs.rh.bean.core.commun.EntiteAdministrative ;
import ma.zs.rh.service.facade.agent.docadmin.TypeDocumentAdministratifAgentService ;
import ma.zs.rh.bean.core.docadmin.TypeDocumentAdministratif ;

import java.util.List;
@Service
public class DemandeDocumentAdministratifAgentServiceImpl implements DemandeDocumentAdministratifAgentService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public DemandeDocumentAdministratif update(DemandeDocumentAdministratif t) {
        DemandeDocumentAdministratif loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{DemandeDocumentAdministratif.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public DemandeDocumentAdministratif findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public DemandeDocumentAdministratif findOrSave(DemandeDocumentAdministratif t) {
        if (t != null) {
            findOrSaveAssociatedObject(t);
            DemandeDocumentAdministratif result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<DemandeDocumentAdministratif> importData(List<DemandeDocumentAdministratif> items) {
        List<DemandeDocumentAdministratif> list = new ArrayList<>();
        for (DemandeDocumentAdministratif t : items) {
            DemandeDocumentAdministratif founded = findByReferenceEntity(t);
			if (founded == null) {
				findOrSaveAssociatedObject(t);
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<DemandeDocumentAdministratif> findAll() {
        return dao.findAll();
    }

    public List<DemandeDocumentAdministratif> findByCriteria(DemandeDocumentAdministratifCriteria criteria) {
        List<DemandeDocumentAdministratif> content = null;
        if (criteria != null) {
            DemandeDocumentAdministratifSpecification mySpecification = constructSpecification(criteria);
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


    private DemandeDocumentAdministratifSpecification constructSpecification(DemandeDocumentAdministratifCriteria criteria) {
        DemandeDocumentAdministratifSpecification mySpecification =  (DemandeDocumentAdministratifSpecification) RefelexivityUtil.constructObjectUsingOneParam(DemandeDocumentAdministratifSpecification.class, criteria);
        return mySpecification;
    }

    public List<DemandeDocumentAdministratif> findPaginatedByCriteria(DemandeDocumentAdministratifCriteria criteria, int page, int pageSize, String order, String sortField) {
        DemandeDocumentAdministratifSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(DemandeDocumentAdministratifCriteria criteria) {
        DemandeDocumentAdministratifSpecification mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
    }

    public List<DemandeDocumentAdministratif> findByTypeDocumentAdministratifId(Long id){
        return dao.findByTypeDocumentAdministratifId(id);
    }
    public int deleteByTypeDocumentAdministratifId(Long id){
        return dao.deleteByTypeDocumentAdministratifId(id);
    }
    public long countByTypeDocumentAdministratifRef(String ref){
        return dao.countByTypeDocumentAdministratifRef(ref);
    }
    public List<DemandeDocumentAdministratif> findByAgentId(Long id){
        return dao.findByAgentId(id);
    }
    public int deleteByAgentId(Long id){
        return dao.deleteByAgentId(id);
    }
    public long countByAgentRef(String ref){
        return dao.countByAgentRef(ref);
    }
    public List<DemandeDocumentAdministratif> findByEtatDemandeDocumentAdministratifId(Long id){
        return dao.findByEtatDemandeDocumentAdministratifId(id);
    }
    public int deleteByEtatDemandeDocumentAdministratifId(Long id){
        return dao.deleteByEtatDemandeDocumentAdministratifId(id);
    }
    public long countByEtatDemandeDocumentAdministratifRef(String ref){
        return dao.countByEtatDemandeDocumentAdministratifRef(ref);
    }
    public List<DemandeDocumentAdministratif> findByEntiteAdministrativeId(Long id){
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
    public int delete(DemandeDocumentAdministratif t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<DemandeDocumentAdministratif> delete(List<DemandeDocumentAdministratif> list) {
		List<DemandeDocumentAdministratif> result = new ArrayList();
        if (list != null) {
            for (DemandeDocumentAdministratif t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public DemandeDocumentAdministratif create(DemandeDocumentAdministratif t) {
        DemandeDocumentAdministratif loaded = findByReferenceEntity(t);
        DemandeDocumentAdministratif saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<DemandeDocumentAdministratif> create(List<DemandeDocumentAdministratif> ts) {
        List<DemandeDocumentAdministratif> result = new ArrayList<>();
        if (ts != null) {
            for (DemandeDocumentAdministratif t : ts) {
				DemandeDocumentAdministratif created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public DemandeDocumentAdministratif findWithAssociatedLists(Long id){
        DemandeDocumentAdministratif result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<DemandeDocumentAdministratif> update(List<DemandeDocumentAdministratif> ts, boolean createIfNotExist) {
        List<DemandeDocumentAdministratif> result = new ArrayList<>();
        if (ts != null) {
            for (DemandeDocumentAdministratif t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    DemandeDocumentAdministratif loadedItem = dao.findById(t.getId()).orElse(null);
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





    public DemandeDocumentAdministratif findByReferenceEntity(DemandeDocumentAdministratif t){
        return t==null? null : dao.findByRef(t.getRef());
    }
    public void findOrSaveAssociatedObject(DemandeDocumentAdministratif t){
        if( t != null) {
            t.setTypeDocumentAdministratif(typeDocumentAdministratifService.findOrSave(t.getTypeDocumentAdministratif()));
            t.setAgent(agentService.findOrSave(t.getAgent()));
            t.setEtatDemandeDocumentAdministratif(etatDemandeDocumentAdministratifService.findOrSave(t.getEtatDemandeDocumentAdministratif()));
            t.setEntiteAdministrative(entiteAdministrativeService.findOrSave(t.getEntiteAdministrative()));
        }
    }



    public List<DemandeDocumentAdministratif> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<DemandeDocumentAdministratif>> getToBeSavedAndToBeDeleted(List<DemandeDocumentAdministratif> oldList, List<DemandeDocumentAdministratif> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<DemandeDocumentAdministratif> importExcel(MultipartFile file) {
        return null;
    }








    @Autowired
    private AgentAgentService agentService ;
    @Autowired
    private EtatDemandeDocumentAdministratifAgentService etatDemandeDocumentAdministratifService ;
    @Autowired
    private EntiteAdministrativeAgentService entiteAdministrativeService ;
    @Autowired
    private TypeDocumentAdministratifAgentService typeDocumentAdministratifService ;

    private @Autowired DemandeDocumentAdministratifDao dao;


}
