package ma.zs.rh.service.facade.admin.commun;

import java.util.List;
import ma.zs.rh.bean.core.commun.PaiementAgent;
import ma.zs.rh.dao.criteria.core.commun.PaiementAgentCriteria;
import ma.zs.rh.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface PaiementAgentAdminService {



    List<PaiementAgent> findByAgentId(Long id);
    int deleteByAgentId(Long id);
    long countByAgentRef(String ref);




	PaiementAgent create(PaiementAgent t);

    PaiementAgent update(PaiementAgent t);

    List<PaiementAgent> update(List<PaiementAgent> ts,boolean createIfNotExist);

    PaiementAgent findById(Long id);

    PaiementAgent findOrSave(PaiementAgent t);

    PaiementAgent findByReferenceEntity(PaiementAgent t);

    PaiementAgent findWithAssociatedLists(Long id);

    List<PaiementAgent> findAllOptimized();

    List<PaiementAgent> findAll();

    List<PaiementAgent> findByCriteria(PaiementAgentCriteria criteria);

    List<PaiementAgent> findPaginatedByCriteria(PaiementAgentCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(PaiementAgentCriteria criteria);

    List<PaiementAgent> delete(List<PaiementAgent> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<PaiementAgent>> getToBeSavedAndToBeDeleted(List<PaiementAgent> oldList, List<PaiementAgent> newList);

    List<PaiementAgent> importData(List<PaiementAgent> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<PaiementAgent> importExcel(MultipartFile file);

}
