package ma.zs.rh.service.facade.admin.conge;

import java.util.List;
import ma.zs.rh.bean.core.conge.MotifRejetDemandeConge;
import ma.zs.rh.dao.criteria.core.conge.MotifRejetDemandeCongeCriteria;
import ma.zs.rh.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface MotifRejetDemandeCongeAdminService {







	MotifRejetDemandeConge create(MotifRejetDemandeConge t);

    MotifRejetDemandeConge update(MotifRejetDemandeConge t);

    List<MotifRejetDemandeConge> update(List<MotifRejetDemandeConge> ts,boolean createIfNotExist);

    MotifRejetDemandeConge findById(Long id);

    MotifRejetDemandeConge findOrSave(MotifRejetDemandeConge t);

    MotifRejetDemandeConge findByReferenceEntity(MotifRejetDemandeConge t);

    MotifRejetDemandeConge findWithAssociatedLists(Long id);

    List<MotifRejetDemandeConge> findAllOptimized();

    List<MotifRejetDemandeConge> findAll();

    List<MotifRejetDemandeConge> findByCriteria(MotifRejetDemandeCongeCriteria criteria);

    List<MotifRejetDemandeConge> findPaginatedByCriteria(MotifRejetDemandeCongeCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(MotifRejetDemandeCongeCriteria criteria);

    List<MotifRejetDemandeConge> delete(List<MotifRejetDemandeConge> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<MotifRejetDemandeConge>> getToBeSavedAndToBeDeleted(List<MotifRejetDemandeConge> oldList, List<MotifRejetDemandeConge> newList);

    List<MotifRejetDemandeConge> importData(List<MotifRejetDemandeConge> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<MotifRejetDemandeConge> importExcel(MultipartFile file);

}
