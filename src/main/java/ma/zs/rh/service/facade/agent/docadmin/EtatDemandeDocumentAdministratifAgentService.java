package ma.zs.rh.service.facade.agent.docadmin;

import java.util.List;
import ma.zs.rh.bean.core.docadmin.EtatDemandeDocumentAdministratif;
import ma.zs.rh.dao.criteria.core.docadmin.EtatDemandeDocumentAdministratifCriteria;


import org.springframework.web.multipart.MultipartFile;

public interface EtatDemandeDocumentAdministratifAgentService {







	EtatDemandeDocumentAdministratif create(EtatDemandeDocumentAdministratif t);

    EtatDemandeDocumentAdministratif update(EtatDemandeDocumentAdministratif t);

    List<EtatDemandeDocumentAdministratif> update(List<EtatDemandeDocumentAdministratif> ts,boolean createIfNotExist);

    EtatDemandeDocumentAdministratif findById(Long id);

    EtatDemandeDocumentAdministratif findOrSave(EtatDemandeDocumentAdministratif t);

    EtatDemandeDocumentAdministratif findByReferenceEntity(EtatDemandeDocumentAdministratif t);

    EtatDemandeDocumentAdministratif findWithAssociatedLists(Long id);

    List<EtatDemandeDocumentAdministratif> findAllOptimized();

    List<EtatDemandeDocumentAdministratif> findAll();

    List<EtatDemandeDocumentAdministratif> findByCriteria(EtatDemandeDocumentAdministratifCriteria criteria);

    List<EtatDemandeDocumentAdministratif> findPaginatedByCriteria(EtatDemandeDocumentAdministratifCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(EtatDemandeDocumentAdministratifCriteria criteria);

    List<EtatDemandeDocumentAdministratif> delete(List<EtatDemandeDocumentAdministratif> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<EtatDemandeDocumentAdministratif>> getToBeSavedAndToBeDeleted(List<EtatDemandeDocumentAdministratif> oldList, List<EtatDemandeDocumentAdministratif> newList);

    List<EtatDemandeDocumentAdministratif> importData(List<EtatDemandeDocumentAdministratif> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<EtatDemandeDocumentAdministratif> importExcel(MultipartFile file);

}
