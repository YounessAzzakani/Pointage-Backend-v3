package ma.zs.rh.service.facade.agent.docadmin;

import java.util.List;
import ma.zs.rh.bean.core.docadmin.DemandeDocumentAdministratif;
import ma.zs.rh.dao.criteria.core.docadmin.DemandeDocumentAdministratifCriteria;
import ma.zs.rh.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface DemandeDocumentAdministratifAgentService {



    List<DemandeDocumentAdministratif> findByTypeDocumentAdministratifId(Long id);
    int deleteByTypeDocumentAdministratifId(Long id);
    long countByTypeDocumentAdministratifRef(String ref);
    List<DemandeDocumentAdministratif> findByAgentId(Long id);
    int deleteByAgentId(Long id);
    long countByAgentRef(String ref);
    List<DemandeDocumentAdministratif> findByEtatDemandeDocumentAdministratifId(Long id);
    int deleteByEtatDemandeDocumentAdministratifId(Long id);
    long countByEtatDemandeDocumentAdministratifRef(String ref);
    List<DemandeDocumentAdministratif> findByEntiteAdministrativeId(Long id);
    int deleteByEntiteAdministrativeId(Long id);
    long countByEntiteAdministrativeRef(String ref);




	DemandeDocumentAdministratif create(DemandeDocumentAdministratif t);

    DemandeDocumentAdministratif update(DemandeDocumentAdministratif t);

    List<DemandeDocumentAdministratif> update(List<DemandeDocumentAdministratif> ts,boolean createIfNotExist);

    DemandeDocumentAdministratif findById(Long id);

    DemandeDocumentAdministratif findOrSave(DemandeDocumentAdministratif t);

    DemandeDocumentAdministratif findByReferenceEntity(DemandeDocumentAdministratif t);

    DemandeDocumentAdministratif findWithAssociatedLists(Long id);

    List<DemandeDocumentAdministratif> findAllOptimized();

    List<DemandeDocumentAdministratif> findAll();

    List<DemandeDocumentAdministratif> findByCriteria(DemandeDocumentAdministratifCriteria criteria);

    List<DemandeDocumentAdministratif> findPaginatedByCriteria(DemandeDocumentAdministratifCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(DemandeDocumentAdministratifCriteria criteria);

    List<DemandeDocumentAdministratif> delete(List<DemandeDocumentAdministratif> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<DemandeDocumentAdministratif>> getToBeSavedAndToBeDeleted(List<DemandeDocumentAdministratif> oldList, List<DemandeDocumentAdministratif> newList);

    List<DemandeDocumentAdministratif> importData(List<DemandeDocumentAdministratif> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<DemandeDocumentAdministratif> importExcel(MultipartFile file);

}
