package ma.zs.rh.service.facade.admin.commun;

import java.util.List;
import ma.zs.rh.bean.core.commun.EntiteAdministrative;
import ma.zs.rh.dao.criteria.core.commun.EntiteAdministrativeCriteria;


import org.springframework.web.multipart.MultipartFile;

public interface EntiteAdministrativeAdminService {



    List<EntiteAdministrative> findByChefServiceId(Long id);
    int deleteByChefServiceId(Long id);
    long countByChefServiceRef(String ref);


    long getTotalEntites();

	EntiteAdministrative create(EntiteAdministrative t);

    EntiteAdministrative update(EntiteAdministrative t);

    List<EntiteAdministrative> update(List<EntiteAdministrative> ts,boolean createIfNotExist);

    EntiteAdministrative findById(Long id);

    EntiteAdministrative findOrSave(EntiteAdministrative t);

    EntiteAdministrative findByReferenceEntity(EntiteAdministrative t);

    EntiteAdministrative findWithAssociatedLists(Long id);

    List<EntiteAdministrative> findAllOptimized();

    List<EntiteAdministrative> findAll();

    List<EntiteAdministrative> findByCriteria(EntiteAdministrativeCriteria criteria);

    List<EntiteAdministrative> findPaginatedByCriteria(EntiteAdministrativeCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(EntiteAdministrativeCriteria criteria);

    List<EntiteAdministrative> delete(List<EntiteAdministrative> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<EntiteAdministrative>> getToBeSavedAndToBeDeleted(List<EntiteAdministrative> oldList, List<EntiteAdministrative> newList);

    List<EntiteAdministrative> importData(List<EntiteAdministrative> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<EntiteAdministrative> importExcel(MultipartFile file);

}
