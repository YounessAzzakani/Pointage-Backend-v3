package ma.zs.rh.dao.facade.core.pointage;

import org.springframework.data.jpa.repository.Query;
import ma.zs.rh.zynerator.repository.AbstractRepository;
import ma.zs.rh.bean.core.pointage.PointageSens;
import org.springframework.stereotype.Repository;
import ma.zs.rh.bean.core.pointage.PointageSens;
import java.util.List;


@Repository
public interface PointageSensDao extends AbstractRepository<PointageSens,Long>  {
    PointageSens findByRef(String ref);
    int deleteByRef(String ref);


    @Query("SELECT NEW PointageSens(item.id,item.libelle) FROM PointageSens item")
    List<PointageSens> findAllOptimized();

}
