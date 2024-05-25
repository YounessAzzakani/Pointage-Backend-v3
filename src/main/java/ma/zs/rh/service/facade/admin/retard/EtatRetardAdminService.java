package ma.zs.rh.service.facade.admin.retard;

import java.util.List;
import ma.zs.rh.bean.core.retard.EtatRetard;
import ma.zs.rh.dao.criteria.core.retard.EtatRetardCriteria;
import ma.zs.rh.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface EtatRetardAdminService {







	EtatRetard create(EtatRetard t);

    EtatRetard update(EtatRetard t);

    List<EtatRetard> update(List<EtatRetard> ts,boolean createIfNotExist);

    EtatRetard findById(Long id);

    EtatRetard findOrSave(EtatRetard t);

    EtatRetard findByReferenceEntity(EtatRetard t);

    EtatRetard findWithAssociatedLists(Long id);

    List<EtatRetard> findAllOptimized();

    List<EtatRetard> findAll();

    List<EtatRetard> findByCriteria(EtatRetardCriteria criteria);

    List<EtatRetard> findPaginatedByCriteria(EtatRetardCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(EtatRetardCriteria criteria);

    List<EtatRetard> delete(List<EtatRetard> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<EtatRetard>> getToBeSavedAndToBeDeleted(List<EtatRetard> oldList, List<EtatRetard> newList);

    List<EtatRetard> importData(List<EtatRetard> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<EtatRetard> importExcel(MultipartFile file);

}
