package ma.zs.rh.service.facade.agent.heuresupp;

import java.util.List;
import ma.zs.rh.bean.core.heuresupp.HeureSupplementaire;
import ma.zs.rh.dao.criteria.core.heuresupp.HeureSupplementaireCriteria;


import org.springframework.web.multipart.MultipartFile;

public interface HeureSupplementaireAgentService {


    List<HeureSupplementaire> findByOwner();

    List<HeureSupplementaire> findByTypeHeureSupplementaireId(Long id);
    int deleteByTypeHeureSupplementaireId(Long id);
    long countByTypeHeureSupplementaireRef(String ref);
    List<HeureSupplementaire> findByAgentId(Long id);
    int deleteByAgentId(Long id);
    long countByAgentRef(String ref);
    List<HeureSupplementaire> findByEtatTypeHeureSupplementaireId(Long id);
    int deleteByEtatTypeHeureSupplementaireId(Long id);
    long countByEtatTypeHeureSupplementaireRef(String ref);
    List<HeureSupplementaire> findByEntiteAdministrativeId(Long id);
    int deleteByEntiteAdministrativeId(Long id);
    long countByEntiteAdministrativeRef(String ref);




	HeureSupplementaire create(HeureSupplementaire t);

    HeureSupplementaire update(HeureSupplementaire t);

    List<HeureSupplementaire> update(List<HeureSupplementaire> ts,boolean createIfNotExist);

    HeureSupplementaire findById(Long id);

    HeureSupplementaire findOrSave(HeureSupplementaire t);

    HeureSupplementaire findByReferenceEntity(HeureSupplementaire t);

    HeureSupplementaire findWithAssociatedLists(Long id);

    List<HeureSupplementaire> findAllOptimized();

    List<HeureSupplementaire> findAll();

    List<HeureSupplementaire> findByCriteria(HeureSupplementaireCriteria criteria);

    List<HeureSupplementaire> findPaginatedByCriteria(HeureSupplementaireCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(HeureSupplementaireCriteria criteria);

    List<HeureSupplementaire> delete(List<HeureSupplementaire> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<HeureSupplementaire>> getToBeSavedAndToBeDeleted(List<HeureSupplementaire> oldList, List<HeureSupplementaire> newList);

    List<HeureSupplementaire> importData(List<HeureSupplementaire> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<HeureSupplementaire> importExcel(MultipartFile file);

}
