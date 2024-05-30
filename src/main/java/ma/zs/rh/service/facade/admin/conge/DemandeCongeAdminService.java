package ma.zs.rh.service.facade.admin.conge;

import java.util.List;
import ma.zs.rh.bean.core.conge.DemandeConge;
import ma.zs.rh.dao.criteria.core.conge.DemandeCongeCriteria;
import ma.zs.rh.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface DemandeCongeAdminService {



    long getTotalDemandeConge();

    List<DemandeConge> findByMotifRejetDemandeCongeId(Long id);
    int deleteByMotifRejetDemandeCongeId(Long id);
    long countByMotifRejetDemandeCongeRef(String ref);
    List<DemandeConge> findByManagerId(Long id);
    int deleteByManagerId(Long id);
    long countByManagerRef(String ref);
    List<DemandeConge> findByAgentId(Long id);
    int deleteByAgentId(Long id);
    long countByAgentRef(String ref);
    List<DemandeConge> findByRaisonCongeId(Long id);
    int deleteByRaisonCongeId(Long id);
    long countByRaisonCongeRef(String ref);
    List<DemandeConge> findByEtatDemandeCongeId(Long id);
    int deleteByEtatDemandeCongeId(Long id);
    long countByEtatDemandeCongeRef(String ref);
    List<DemandeConge> findByEntiteAdministrativeId(Long id);
    int deleteByEntiteAdministrativeId(Long id);
    long countByEntiteAdministrativeRef(String ref);




	DemandeConge create(DemandeConge t);

    DemandeConge update(DemandeConge t);

    List<DemandeConge> update(List<DemandeConge> ts,boolean createIfNotExist);

    DemandeConge findById(Long id);

    DemandeConge findOrSave(DemandeConge t);

    DemandeConge findByReferenceEntity(DemandeConge t);

    DemandeConge findWithAssociatedLists(Long id);

    List<DemandeConge> findAllOptimized();

    List<DemandeConge> findAll();

    List<DemandeConge> findByCriteria(DemandeCongeCriteria criteria);

    List<DemandeConge> findPaginatedByCriteria(DemandeCongeCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(DemandeCongeCriteria criteria);

    List<DemandeConge> delete(List<DemandeConge> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<DemandeConge>> getToBeSavedAndToBeDeleted(List<DemandeConge> oldList, List<DemandeConge> newList);

    List<DemandeConge> importData(List<DemandeConge> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<DemandeConge> importExcel(MultipartFile file);

}
