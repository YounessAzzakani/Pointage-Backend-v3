package ma.zs.rh.service.impl.admin.heuresupp;


import ma.zs.rh.zynerator.exception.EntityNotFoundException;
import ma.zs.rh.bean.core.heuresupp.EtatTypeHeureSupplementaire;
import ma.zs.rh.dao.criteria.core.heuresupp.EtatTypeHeureSupplementaireCriteria;
import ma.zs.rh.dao.facade.core.heuresupp.EtatTypeHeureSupplementaireDao;
import ma.zs.rh.dao.specification.core.heuresupp.EtatTypeHeureSupplementaireSpecification;
import ma.zs.rh.service.facade.admin.heuresupp.EtatTypeHeureSupplementaireAdminService;
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


import java.util.List;
@Service
public class EtatTypeHeureSupplementaireAdminServiceImpl implements EtatTypeHeureSupplementaireAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public EtatTypeHeureSupplementaire update(EtatTypeHeureSupplementaire t) {
        EtatTypeHeureSupplementaire loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{EtatTypeHeureSupplementaire.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public EtatTypeHeureSupplementaire findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public EtatTypeHeureSupplementaire findOrSave(EtatTypeHeureSupplementaire t) {
        if (t != null) {
            EtatTypeHeureSupplementaire result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<EtatTypeHeureSupplementaire> importData(List<EtatTypeHeureSupplementaire> items) {
        List<EtatTypeHeureSupplementaire> list = new ArrayList<>();
        for (EtatTypeHeureSupplementaire t : items) {
            EtatTypeHeureSupplementaire founded = findByReferenceEntity(t);
			if (founded == null) {
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<EtatTypeHeureSupplementaire> findAll() {
        return dao.findAll();
    }

    public List<EtatTypeHeureSupplementaire> findByCriteria(EtatTypeHeureSupplementaireCriteria criteria) {
        List<EtatTypeHeureSupplementaire> content = null;
        if (criteria != null) {
            EtatTypeHeureSupplementaireSpecification mySpecification = constructSpecification(criteria);
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


    private EtatTypeHeureSupplementaireSpecification constructSpecification(EtatTypeHeureSupplementaireCriteria criteria) {
        EtatTypeHeureSupplementaireSpecification mySpecification =  (EtatTypeHeureSupplementaireSpecification) RefelexivityUtil.constructObjectUsingOneParam(EtatTypeHeureSupplementaireSpecification.class, criteria);
        return mySpecification;
    }

    public List<EtatTypeHeureSupplementaire> findPaginatedByCriteria(EtatTypeHeureSupplementaireCriteria criteria, int page, int pageSize, String order, String sortField) {
        EtatTypeHeureSupplementaireSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(EtatTypeHeureSupplementaireCriteria criteria) {
        EtatTypeHeureSupplementaireSpecification mySpecification = constructSpecification(criteria);
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
    public int delete(EtatTypeHeureSupplementaire t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<EtatTypeHeureSupplementaire> delete(List<EtatTypeHeureSupplementaire> list) {
		List<EtatTypeHeureSupplementaire> result = new ArrayList();
        if (list != null) {
            for (EtatTypeHeureSupplementaire t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public EtatTypeHeureSupplementaire create(EtatTypeHeureSupplementaire t) {
        EtatTypeHeureSupplementaire loaded = findByReferenceEntity(t);
        EtatTypeHeureSupplementaire saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<EtatTypeHeureSupplementaire> create(List<EtatTypeHeureSupplementaire> ts) {
        List<EtatTypeHeureSupplementaire> result = new ArrayList<>();
        if (ts != null) {
            for (EtatTypeHeureSupplementaire t : ts) {
				EtatTypeHeureSupplementaire created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public EtatTypeHeureSupplementaire findWithAssociatedLists(Long id){
        EtatTypeHeureSupplementaire result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<EtatTypeHeureSupplementaire> update(List<EtatTypeHeureSupplementaire> ts, boolean createIfNotExist) {
        List<EtatTypeHeureSupplementaire> result = new ArrayList<>();
        if (ts != null) {
            for (EtatTypeHeureSupplementaire t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    EtatTypeHeureSupplementaire loadedItem = dao.findById(t.getId()).orElse(null);
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





    public EtatTypeHeureSupplementaire findByReferenceEntity(EtatTypeHeureSupplementaire t){
        return t==null? null : dao.findByRef(t.getRef());
    }



    public List<EtatTypeHeureSupplementaire> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<EtatTypeHeureSupplementaire>> getToBeSavedAndToBeDeleted(List<EtatTypeHeureSupplementaire> oldList, List<EtatTypeHeureSupplementaire> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<EtatTypeHeureSupplementaire> importExcel(MultipartFile file) {
        return null;
    }









    private @Autowired EtatTypeHeureSupplementaireDao dao;


}
