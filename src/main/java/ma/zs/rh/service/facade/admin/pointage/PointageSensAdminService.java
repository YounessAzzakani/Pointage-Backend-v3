package ma.zs.rh.service.facade.admin.pointage;

import java.util.List;
import ma.zs.rh.bean.core.pointage.PointageSens;
import ma.zs.rh.dao.criteria.core.pointage.PointageSensCriteria;
import ma.zs.rh.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface PointageSensAdminService {







	PointageSens create(PointageSens t);

    PointageSens update(PointageSens t);

    List<PointageSens> update(List<PointageSens> ts,boolean createIfNotExist);

    PointageSens findById(Long id);

    PointageSens findOrSave(PointageSens t);

    PointageSens findByReferenceEntity(PointageSens t);

    PointageSens findWithAssociatedLists(Long id);

    List<PointageSens> findAllOptimized();

    List<PointageSens> findAll();

    List<PointageSens> findByCriteria(PointageSensCriteria criteria);

    List<PointageSens> findPaginatedByCriteria(PointageSensCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(PointageSensCriteria criteria);

    List<PointageSens> delete(List<PointageSens> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<PointageSens>> getToBeSavedAndToBeDeleted(List<PointageSens> oldList, List<PointageSens> newList);

    List<PointageSens> importData(List<PointageSens> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<PointageSens> importExcel(MultipartFile file);

}
