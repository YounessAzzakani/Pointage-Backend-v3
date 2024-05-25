package ma.zs.rh.dao.facade.core.pointage;

import org.springframework.data.jpa.repository.Query;
import ma.zs.rh.zynerator.repository.AbstractRepository;
import ma.zs.rh.bean.core.pointage.Pointeuse;
import org.springframework.stereotype.Repository;
import ma.zs.rh.bean.core.pointage.Pointeuse;
import java.util.List;


@Repository
public interface PointeuseDao extends AbstractRepository<Pointeuse,Long>  {
    Pointeuse findByRef(String ref);
    int deleteByRef(String ref);


    @Query("SELECT NEW Pointeuse(item.id,item.libelle) FROM Pointeuse item")
    List<Pointeuse> findAllOptimized();

}
