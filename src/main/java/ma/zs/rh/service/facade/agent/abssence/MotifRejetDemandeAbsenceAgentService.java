package ma.zs.rh.service.facade.agent.abssence;

import java.util.List;
import ma.zs.rh.bean.core.abssence.MotifRejetDemandeAbsence;
import ma.zs.rh.dao.criteria.core.abssence.MotifRejetDemandeAbsenceCriteria;
import ma.zs.rh.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface MotifRejetDemandeAbsenceAgentService {







	MotifRejetDemandeAbsence create(MotifRejetDemandeAbsence t);

    MotifRejetDemandeAbsence update(MotifRejetDemandeAbsence t);

    List<MotifRejetDemandeAbsence> update(List<MotifRejetDemandeAbsence> ts,boolean createIfNotExist);

    MotifRejetDemandeAbsence findById(Long id);

    MotifRejetDemandeAbsence findOrSave(MotifRejetDemandeAbsence t);

    MotifRejetDemandeAbsence findByReferenceEntity(MotifRejetDemandeAbsence t);

    MotifRejetDemandeAbsence findWithAssociatedLists(Long id);

    List<MotifRejetDemandeAbsence> findAllOptimized();

    List<MotifRejetDemandeAbsence> findAll();

    List<MotifRejetDemandeAbsence> findByCriteria(MotifRejetDemandeAbsenceCriteria criteria);

    List<MotifRejetDemandeAbsence> findPaginatedByCriteria(MotifRejetDemandeAbsenceCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(MotifRejetDemandeAbsenceCriteria criteria);

    List<MotifRejetDemandeAbsence> delete(List<MotifRejetDemandeAbsence> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<MotifRejetDemandeAbsence>> getToBeSavedAndToBeDeleted(List<MotifRejetDemandeAbsence> oldList, List<MotifRejetDemandeAbsence> newList);

    List<MotifRejetDemandeAbsence> importData(List<MotifRejetDemandeAbsence> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<MotifRejetDemandeAbsence> importExcel(MultipartFile file);

}
