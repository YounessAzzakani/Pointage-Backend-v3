package ma.zs.rh.service.facade.admin.pointage;

import java.util.List;
import ma.zs.rh.bean.core.pointage.Pointeuse;
import ma.zs.rh.dao.criteria.core.pointage.PointeuseCriteria;
import ma.zs.rh.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface PointeuseAdminService {







	Pointeuse create(Pointeuse t);

    Pointeuse update(Pointeuse t);

    List<Pointeuse> update(List<Pointeuse> ts,boolean createIfNotExist);

    Pointeuse findById(Long id);

    Pointeuse findOrSave(Pointeuse t);

    Pointeuse findByReferenceEntity(Pointeuse t);

    Pointeuse findWithAssociatedLists(Long id);

    List<Pointeuse> findAllOptimized();

    List<Pointeuse> findAll();

    List<Pointeuse> findByCriteria(PointeuseCriteria criteria);

    List<Pointeuse> findPaginatedByCriteria(PointeuseCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(PointeuseCriteria criteria);

    List<Pointeuse> delete(List<Pointeuse> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<Pointeuse>> getToBeSavedAndToBeDeleted(List<Pointeuse> oldList, List<Pointeuse> newList);

    List<Pointeuse> importData(List<Pointeuse> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<Pointeuse> importExcel(MultipartFile file);

}
