package ma.zs.rh.service.facade.admin.docadmin;

import java.util.List;
import ma.zs.rh.bean.core.docadmin.TypeDocumentAdministratif;
import ma.zs.rh.dao.criteria.core.docadmin.TypeDocumentAdministratifCriteria;


import org.springframework.web.multipart.MultipartFile;

public interface TypeDocumentAdministratifAdminService {







	TypeDocumentAdministratif create(TypeDocumentAdministratif t);

    TypeDocumentAdministratif update(TypeDocumentAdministratif t);

    List<TypeDocumentAdministratif> update(List<TypeDocumentAdministratif> ts,boolean createIfNotExist);

    TypeDocumentAdministratif findById(Long id);

    TypeDocumentAdministratif findOrSave(TypeDocumentAdministratif t);

    TypeDocumentAdministratif findByReferenceEntity(TypeDocumentAdministratif t);

    TypeDocumentAdministratif findWithAssociatedLists(Long id);

    List<TypeDocumentAdministratif> findAllOptimized();

    List<TypeDocumentAdministratif> findAll();

    List<TypeDocumentAdministratif> findByCriteria(TypeDocumentAdministratifCriteria criteria);

    List<TypeDocumentAdministratif> findPaginatedByCriteria(TypeDocumentAdministratifCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(TypeDocumentAdministratifCriteria criteria);

    List<TypeDocumentAdministratif> delete(List<TypeDocumentAdministratif> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<TypeDocumentAdministratif>> getToBeSavedAndToBeDeleted(List<TypeDocumentAdministratif> oldList, List<TypeDocumentAdministratif> newList);

    List<TypeDocumentAdministratif> importData(List<TypeDocumentAdministratif> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<TypeDocumentAdministratif> importExcel(MultipartFile file);

}
