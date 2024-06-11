package ma.zs.rh.service.facade.admin.conge;

import java.util.List;
import ma.zs.rh.bean.core.conge.EtatDemandeConge;
import ma.zs.rh.dao.criteria.core.conge.EtatDemandeCongeCriteria;


import org.springframework.web.multipart.MultipartFile;

public interface EtatDemandeCongeAdminService {







	EtatDemandeConge create(EtatDemandeConge t);

    EtatDemandeConge update(EtatDemandeConge t);

    List<EtatDemandeConge> update(List<EtatDemandeConge> ts,boolean createIfNotExist);

    EtatDemandeConge findById(Long id);

    EtatDemandeConge findOrSave(EtatDemandeConge t);

    EtatDemandeConge findByReferenceEntity(EtatDemandeConge t);

    EtatDemandeConge findWithAssociatedLists(Long id);

    List<EtatDemandeConge> findAllOptimized();

    List<EtatDemandeConge> findAll();

    List<EtatDemandeConge> findByCriteria(EtatDemandeCongeCriteria criteria);

    List<EtatDemandeConge> findPaginatedByCriteria(EtatDemandeCongeCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(EtatDemandeCongeCriteria criteria);

    List<EtatDemandeConge> delete(List<EtatDemandeConge> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<EtatDemandeConge>> getToBeSavedAndToBeDeleted(List<EtatDemandeConge> oldList, List<EtatDemandeConge> newList);

    List<EtatDemandeConge> importData(List<EtatDemandeConge> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<EtatDemandeConge> importExcel(MultipartFile file);

}
