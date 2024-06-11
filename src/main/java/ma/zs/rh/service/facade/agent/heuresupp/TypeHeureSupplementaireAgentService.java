package ma.zs.rh.service.facade.agent.heuresupp;

import java.util.List;
import ma.zs.rh.bean.core.heuresupp.TypeHeureSupplementaire;
import ma.zs.rh.dao.criteria.core.heuresupp.TypeHeureSupplementaireCriteria;


import org.springframework.web.multipart.MultipartFile;

public interface TypeHeureSupplementaireAgentService {







	TypeHeureSupplementaire create(TypeHeureSupplementaire t);

    TypeHeureSupplementaire update(TypeHeureSupplementaire t);

    List<TypeHeureSupplementaire> update(List<TypeHeureSupplementaire> ts,boolean createIfNotExist);

    TypeHeureSupplementaire findById(Long id);

    TypeHeureSupplementaire findOrSave(TypeHeureSupplementaire t);

    TypeHeureSupplementaire findByReferenceEntity(TypeHeureSupplementaire t);

    TypeHeureSupplementaire findWithAssociatedLists(Long id);

    List<TypeHeureSupplementaire> findAllOptimized();

    List<TypeHeureSupplementaire> findAll();

    List<TypeHeureSupplementaire> findByCriteria(TypeHeureSupplementaireCriteria criteria);

    List<TypeHeureSupplementaire> findPaginatedByCriteria(TypeHeureSupplementaireCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(TypeHeureSupplementaireCriteria criteria);

    List<TypeHeureSupplementaire> delete(List<TypeHeureSupplementaire> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<TypeHeureSupplementaire>> getToBeSavedAndToBeDeleted(List<TypeHeureSupplementaire> oldList, List<TypeHeureSupplementaire> newList);

    List<TypeHeureSupplementaire> importData(List<TypeHeureSupplementaire> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<TypeHeureSupplementaire> importExcel(MultipartFile file);

}
