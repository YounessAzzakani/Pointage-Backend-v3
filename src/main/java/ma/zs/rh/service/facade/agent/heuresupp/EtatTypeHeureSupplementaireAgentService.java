package ma.zs.rh.service.facade.agent.heuresupp;

import java.util.List;
import ma.zs.rh.bean.core.heuresupp.EtatTypeHeureSupplementaire;
import ma.zs.rh.dao.criteria.core.heuresupp.EtatTypeHeureSupplementaireCriteria;
import ma.zs.rh.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface EtatTypeHeureSupplementaireAgentService {







	EtatTypeHeureSupplementaire create(EtatTypeHeureSupplementaire t);

    EtatTypeHeureSupplementaire update(EtatTypeHeureSupplementaire t);

    List<EtatTypeHeureSupplementaire> update(List<EtatTypeHeureSupplementaire> ts,boolean createIfNotExist);

    EtatTypeHeureSupplementaire findById(Long id);

    EtatTypeHeureSupplementaire findOrSave(EtatTypeHeureSupplementaire t);

    EtatTypeHeureSupplementaire findByReferenceEntity(EtatTypeHeureSupplementaire t);

    EtatTypeHeureSupplementaire findWithAssociatedLists(Long id);

    List<EtatTypeHeureSupplementaire> findAllOptimized();

    List<EtatTypeHeureSupplementaire> findAll();

    List<EtatTypeHeureSupplementaire> findByCriteria(EtatTypeHeureSupplementaireCriteria criteria);

    List<EtatTypeHeureSupplementaire> findPaginatedByCriteria(EtatTypeHeureSupplementaireCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(EtatTypeHeureSupplementaireCriteria criteria);

    List<EtatTypeHeureSupplementaire> delete(List<EtatTypeHeureSupplementaire> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<EtatTypeHeureSupplementaire>> getToBeSavedAndToBeDeleted(List<EtatTypeHeureSupplementaire> oldList, List<EtatTypeHeureSupplementaire> newList);

    List<EtatTypeHeureSupplementaire> importData(List<EtatTypeHeureSupplementaire> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<EtatTypeHeureSupplementaire> importExcel(MultipartFile file);

}
