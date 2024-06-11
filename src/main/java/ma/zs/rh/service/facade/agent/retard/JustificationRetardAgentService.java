package ma.zs.rh.service.facade.agent.retard;

import java.util.List;
import ma.zs.rh.bean.core.retard.JustificationRetard;
import ma.zs.rh.dao.criteria.core.retard.JustificationRetardCriteria;


import org.springframework.web.multipart.MultipartFile;

public interface JustificationRetardAgentService {







	JustificationRetard create(JustificationRetard t);

    JustificationRetard update(JustificationRetard t);

    List<JustificationRetard> update(List<JustificationRetard> ts,boolean createIfNotExist);

    JustificationRetard findById(Long id);

    JustificationRetard findOrSave(JustificationRetard t);

    JustificationRetard findByReferenceEntity(JustificationRetard t);

    JustificationRetard findWithAssociatedLists(Long id);

    List<JustificationRetard> findAllOptimized();

    List<JustificationRetard> findAll();

    List<JustificationRetard> findByCriteria(JustificationRetardCriteria criteria);

    List<JustificationRetard> findPaginatedByCriteria(JustificationRetardCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(JustificationRetardCriteria criteria);

    List<JustificationRetard> delete(List<JustificationRetard> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<JustificationRetard>> getToBeSavedAndToBeDeleted(List<JustificationRetard> oldList, List<JustificationRetard> newList);

    List<JustificationRetard> importData(List<JustificationRetard> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<JustificationRetard> importExcel(MultipartFile file);

}
