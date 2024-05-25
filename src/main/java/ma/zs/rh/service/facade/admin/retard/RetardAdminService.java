package ma.zs.rh.service.facade.admin.retard;

import java.util.List;
import ma.zs.rh.bean.core.retard.Retard;
import ma.zs.rh.dao.criteria.core.retard.RetardCriteria;
import ma.zs.rh.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface RetardAdminService {



    List<Retard> findByAgentId(Long id);
    int deleteByAgentId(Long id);
    long countByAgentRef(String ref);
    List<Retard> findByEtatRetardId(Long id);
    int deleteByEtatRetardId(Long id);
    long countByEtatRetardRef(String ref);
    List<Retard> findByJustificationRetardId(Long id);
    int deleteByJustificationRetardId(Long id);
    long countByJustificationRetardRef(String ref);




	Retard create(Retard t);

    Retard update(Retard t);

    List<Retard> update(List<Retard> ts,boolean createIfNotExist);

    Retard findById(Long id);

    Retard findOrSave(Retard t);

    Retard findByReferenceEntity(Retard t);

    Retard findWithAssociatedLists(Long id);

    List<Retard> findAllOptimized();

    List<Retard> findAll();

    List<Retard> findByCriteria(RetardCriteria criteria);

    List<Retard> findPaginatedByCriteria(RetardCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(RetardCriteria criteria);

    List<Retard> delete(List<Retard> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<Retard>> getToBeSavedAndToBeDeleted(List<Retard> oldList, List<Retard> newList);

    List<Retard> importData(List<Retard> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<Retard> importExcel(MultipartFile file);

}
