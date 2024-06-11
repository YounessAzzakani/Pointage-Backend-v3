package ma.zs.rh.service.facade.admin.conge;

import java.util.List;
import ma.zs.rh.bean.core.conge.RaisonConge;
import ma.zs.rh.dao.criteria.core.conge.RaisonCongeCriteria;


import org.springframework.web.multipart.MultipartFile;

public interface RaisonCongeAdminService {







	RaisonConge create(RaisonConge t);

    RaisonConge update(RaisonConge t);

    List<RaisonConge> update(List<RaisonConge> ts,boolean createIfNotExist);

    RaisonConge findById(Long id);

    RaisonConge findOrSave(RaisonConge t);

    RaisonConge findByReferenceEntity(RaisonConge t);

    RaisonConge findWithAssociatedLists(Long id);

    List<RaisonConge> findAllOptimized();

    List<RaisonConge> findAll();

    List<RaisonConge> findByCriteria(RaisonCongeCriteria criteria);

    List<RaisonConge> findPaginatedByCriteria(RaisonCongeCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(RaisonCongeCriteria criteria);

    List<RaisonConge> delete(List<RaisonConge> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<RaisonConge>> getToBeSavedAndToBeDeleted(List<RaisonConge> oldList, List<RaisonConge> newList);

    List<RaisonConge> importData(List<RaisonConge> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<RaisonConge> importExcel(MultipartFile file);

}
