package ma.zs.rh.service.facade.agent.abssence;

import java.util.List;
import ma.zs.rh.bean.core.abssence.DemandeAbsence;
import ma.zs.rh.dao.criteria.core.abssence.DemandeAbsenceCriteria;


import org.springframework.web.multipart.MultipartFile;

public interface DemandeAbsenceAgentService {


    List<DemandeAbsence> findByAgentRef(String ref);


    List<DemandeAbsence> findByMotifRejetDemandeAbsenceId(Long id);
    int deleteByMotifRejetDemandeAbsenceId(Long id);
    long countByMotifRejetDemandeAbsenceRef(String ref);
    List<DemandeAbsence> findByEntiteAdministrativeId(Long id);
    int deleteByEntiteAdministrativeId(Long id);
    long countByEntiteAdministrativeRef(String ref);
    List<DemandeAbsence> findByManagerId(Long id);
    int deleteByManagerId(Long id);
    long countByManagerRef(String ref);
    List<DemandeAbsence> findByAgentId(Long id);
    int deleteByAgentId(Long id);
    long countByAgentRef(String ref);
    List<DemandeAbsence> findByRaisonAbsenceId(Long id);
    int deleteByRaisonAbsenceId(Long id);
    long countByRaisonAbsenceRef(String ref);
    List<DemandeAbsence> findByEtatDemandeAbsenceId(Long id);
    int deleteByEtatDemandeAbsenceId(Long id);
    long countByEtatDemandeAbsenceRef(String ref);




	DemandeAbsence create(DemandeAbsence t);

    DemandeAbsence update(DemandeAbsence t);

    List<DemandeAbsence> update(List<DemandeAbsence> ts,boolean createIfNotExist);

    DemandeAbsence findById(Long id);

    DemandeAbsence findOrSave(DemandeAbsence t);

    DemandeAbsence findByReferenceEntity(DemandeAbsence t);

    DemandeAbsence findWithAssociatedLists(Long id);

    List<DemandeAbsence> findAllOptimized();

    List<DemandeAbsence> findAll();

    List<DemandeAbsence> findByCriteria(DemandeAbsenceCriteria criteria);

    List<DemandeAbsence> findPaginatedByCriteria(DemandeAbsenceCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(DemandeAbsenceCriteria criteria);

    List<DemandeAbsence> delete(List<DemandeAbsence> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<DemandeAbsence>> getToBeSavedAndToBeDeleted(List<DemandeAbsence> oldList, List<DemandeAbsence> newList);

    List<DemandeAbsence> importData(List<DemandeAbsence> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<DemandeAbsence> importExcel(MultipartFile file);

}
