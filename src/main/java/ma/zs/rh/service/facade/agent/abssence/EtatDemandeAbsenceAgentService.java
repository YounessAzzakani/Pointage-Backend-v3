package ma.zs.rh.service.facade.agent.abssence;

import java.util.List;
import ma.zs.rh.bean.core.abssence.EtatDemandeAbsence;
import ma.zs.rh.dao.criteria.core.abssence.EtatDemandeAbsenceCriteria;
import ma.zs.rh.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface EtatDemandeAbsenceAgentService {







	EtatDemandeAbsence create(EtatDemandeAbsence t);

    EtatDemandeAbsence update(EtatDemandeAbsence t);

    List<EtatDemandeAbsence> update(List<EtatDemandeAbsence> ts,boolean createIfNotExist);

    EtatDemandeAbsence findById(Long id);

    EtatDemandeAbsence findOrSave(EtatDemandeAbsence t);

    EtatDemandeAbsence findByReferenceEntity(EtatDemandeAbsence t);

    EtatDemandeAbsence findWithAssociatedLists(Long id);

    List<EtatDemandeAbsence> findAllOptimized();

    List<EtatDemandeAbsence> findAll();

    List<EtatDemandeAbsence> findByCriteria(EtatDemandeAbsenceCriteria criteria);

    List<EtatDemandeAbsence> findPaginatedByCriteria(EtatDemandeAbsenceCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(EtatDemandeAbsenceCriteria criteria);

    List<EtatDemandeAbsence> delete(List<EtatDemandeAbsence> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<EtatDemandeAbsence>> getToBeSavedAndToBeDeleted(List<EtatDemandeAbsence> oldList, List<EtatDemandeAbsence> newList);

    List<EtatDemandeAbsence> importData(List<EtatDemandeAbsence> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<EtatDemandeAbsence> importExcel(MultipartFile file);

}
