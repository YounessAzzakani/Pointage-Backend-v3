package ma.zs.rh.service.impl.agent.commun;


import ma.zs.rh.zynerator.exception.EntityNotFoundException;
import ma.zs.rh.bean.core.commun.EntiteAdministrative;
import ma.zs.rh.dao.criteria.core.commun.EntiteAdministrativeCriteria;
import ma.zs.rh.dao.facade.core.commun.EntiteAdministrativeDao;
import ma.zs.rh.dao.specification.core.commun.EntiteAdministrativeSpecification;
import ma.zs.rh.service.facade.agent.commun.EntiteAdministrativeAgentService;
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

import java.util.List;
@Service
public class EntiteAdministrativeAgentServiceImpl implements EntiteAdministrativeAgentService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public EntiteAdministrative update(EntiteAdministrative t) {
        EntiteAdministrative loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{EntiteAdministrative.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public EntiteAdministrative findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public EntiteAdministrative findOrSave(EntiteAdministrative t) {
        if (t != null) {
            findOrSaveAssociatedObject(t);
            EntiteAdministrative result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<EntiteAdministrative> importData(List<EntiteAdministrative> items) {
        List<EntiteAdministrative> list = new ArrayList<>();
        for (EntiteAdministrative t : items) {
            EntiteAdministrative founded = findByReferenceEntity(t);
			if (founded == null) {
				findOrSaveAssociatedObject(t);
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<EntiteAdministrative> findAll() {
        return dao.findAll();
    }

    public List<EntiteAdministrative> findByCriteria(EntiteAdministrativeCriteria criteria) {
        List<EntiteAdministrative> content = null;
        if (criteria != null) {
            EntiteAdministrativeSpecification mySpecification = constructSpecification(criteria);
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


    private EntiteAdministrativeSpecification constructSpecification(EntiteAdministrativeCriteria criteria) {
        EntiteAdministrativeSpecification mySpecification =  (EntiteAdministrativeSpecification) RefelexivityUtil.constructObjectUsingOneParam(EntiteAdministrativeSpecification.class, criteria);
        return mySpecification;
    }

    public List<EntiteAdministrative> findPaginatedByCriteria(EntiteAdministrativeCriteria criteria, int page, int pageSize, String order, String sortField) {
        EntiteAdministrativeSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(EntiteAdministrativeCriteria criteria) {
        EntiteAdministrativeSpecification mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
    }

    public List<EntiteAdministrative> findByChefServiceId(Long id){
        return dao.findByChefServiceId(id);
    }
    public int deleteByChefServiceId(Long id){
        return dao.deleteByChefServiceId(id);
    }
    public long countByChefServiceRef(String ref){
        return dao.countByChefServiceRef(ref);
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
    public int delete(EntiteAdministrative t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<EntiteAdministrative> delete(List<EntiteAdministrative> list) {
		List<EntiteAdministrative> result = new ArrayList();
        if (list != null) {
            for (EntiteAdministrative t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public EntiteAdministrative create(EntiteAdministrative t) {
        EntiteAdministrative loaded = findByReferenceEntity(t);
        EntiteAdministrative saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<EntiteAdministrative> create(List<EntiteAdministrative> ts) {
        List<EntiteAdministrative> result = new ArrayList<>();
        if (ts != null) {
            for (EntiteAdministrative t : ts) {
				EntiteAdministrative created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public EntiteAdministrative findWithAssociatedLists(Long id){
        EntiteAdministrative result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<EntiteAdministrative> update(List<EntiteAdministrative> ts, boolean createIfNotExist) {
        List<EntiteAdministrative> result = new ArrayList<>();
        if (ts != null) {
            for (EntiteAdministrative t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    EntiteAdministrative loadedItem = dao.findById(t.getId()).orElse(null);
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





    public EntiteAdministrative findByReferenceEntity(EntiteAdministrative t){
        return t==null? null : dao.findByRef(t.getRef());
    }
    public void findOrSaveAssociatedObject(EntiteAdministrative t){
        if( t != null) {
            t.setChefService(agentService.findOrSave(t.getChefService()));
        }
    }



    public List<EntiteAdministrative> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<EntiteAdministrative>> getToBeSavedAndToBeDeleted(List<EntiteAdministrative> oldList, List<EntiteAdministrative> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<EntiteAdministrative> importExcel(MultipartFile file) {
        return null;
    }








    @Autowired
    private AgentAgentService agentService ;

    private @Autowired EntiteAdministrativeDao dao;


}
