package ma.zs.rh.service.facade.agent.commun;

import java.util.List;
import ma.zs.rh.bean.core.commun.PlageHoraire;
import ma.zs.rh.dao.criteria.core.commun.PlageHoraireCriteria;
import ma.zs.rh.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface PlageHoraireAgentService {







	PlageHoraire create(PlageHoraire t);

    PlageHoraire update(PlageHoraire t);

    List<PlageHoraire> update(List<PlageHoraire> ts,boolean createIfNotExist);

    PlageHoraire findById(Long id);

    PlageHoraire findOrSave(PlageHoraire t);

    PlageHoraire findByReferenceEntity(PlageHoraire t);

    PlageHoraire findWithAssociatedLists(Long id);

    List<PlageHoraire> findAllOptimized();

    List<PlageHoraire> findAll();

    List<PlageHoraire> findByCriteria(PlageHoraireCriteria criteria);

    List<PlageHoraire> findPaginatedByCriteria(PlageHoraireCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(PlageHoraireCriteria criteria);

    List<PlageHoraire> delete(List<PlageHoraire> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<PlageHoraire>> getToBeSavedAndToBeDeleted(List<PlageHoraire> oldList, List<PlageHoraire> newList);

    List<PlageHoraire> importData(List<PlageHoraire> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<PlageHoraire> importExcel(MultipartFile file);

}
