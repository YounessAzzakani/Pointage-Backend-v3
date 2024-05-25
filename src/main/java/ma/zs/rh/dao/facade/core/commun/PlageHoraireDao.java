package ma.zs.rh.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.rh.zynerator.repository.AbstractRepository;
import ma.zs.rh.bean.core.commun.PlageHoraire;
import org.springframework.stereotype.Repository;
import ma.zs.rh.bean.core.commun.PlageHoraire;
import java.util.List;


@Repository
public interface PlageHoraireDao extends AbstractRepository<PlageHoraire,Long>  {
    PlageHoraire findByRef(String ref);
    int deleteByRef(String ref);


    @Query("SELECT NEW PlageHoraire(item.id,item.ref) FROM PlageHoraire item")
    List<PlageHoraire> findAllOptimized();

}
