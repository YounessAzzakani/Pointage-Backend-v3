package ma.zs.rh.service.facade.agent.abssence;

import java.util.List;
import ma.zs.rh.bean.core.abssence.RaisonAbsence;
import ma.zs.rh.dao.criteria.core.abssence.RaisonAbsenceCriteria;
import ma.zs.rh.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface RaisonAbsenceAgentService {







	RaisonAbsence create(RaisonAbsence t);

    RaisonAbsence update(RaisonAbsence t);

    List<RaisonAbsence> update(List<RaisonAbsence> ts,boolean createIfNotExist);

    RaisonAbsence findById(Long id);

    RaisonAbsence findOrSave(RaisonAbsence t);

    RaisonAbsence findByReferenceEntity(RaisonAbsence t);

    RaisonAbsence findWithAssociatedLists(Long id);

    List<RaisonAbsence> findAllOptimized();

    List<RaisonAbsence> findAll();

    List<RaisonAbsence> findByCriteria(RaisonAbsenceCriteria criteria);

    List<RaisonAbsence> findPaginatedByCriteria(RaisonAbsenceCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(RaisonAbsenceCriteria criteria);

    List<RaisonAbsence> delete(List<RaisonAbsence> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<RaisonAbsence>> getToBeSavedAndToBeDeleted(List<RaisonAbsence> oldList, List<RaisonAbsence> newList);

    List<RaisonAbsence> importData(List<RaisonAbsence> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<RaisonAbsence> importExcel(MultipartFile file);

}
