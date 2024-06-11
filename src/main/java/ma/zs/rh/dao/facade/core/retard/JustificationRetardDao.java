package ma.zs.rh.dao.facade.core.retard;

import org.springframework.data.jpa.repository.Query;
import ma.zs.rh.zbiblio.repository.AbstractRepository;
import ma.zs.rh.bean.core.retard.JustificationRetard;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JustificationRetardDao extends AbstractRepository<JustificationRetard,Long>  {
    JustificationRetard findByRef(String ref);
    int deleteByRef(String ref);


    @Query("SELECT NEW JustificationRetard(item.id,item.libelle) FROM JustificationRetard item")
    List<JustificationRetard> findAllOptimized();

}
