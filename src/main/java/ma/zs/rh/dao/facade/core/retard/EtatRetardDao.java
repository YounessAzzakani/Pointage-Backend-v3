package ma.zs.rh.dao.facade.core.retard;

import org.springframework.data.jpa.repository.Query;
import ma.zs.rh.zbiblio.repository.AbstractRepository;
import ma.zs.rh.bean.core.retard.EtatRetard;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EtatRetardDao extends AbstractRepository<EtatRetard,Long>  {
    EtatRetard findByRef(String ref);
    int deleteByRef(String ref);


    @Query("SELECT NEW EtatRetard(item.id,item.libelle) FROM EtatRetard item")
    List<EtatRetard> findAllOptimized();

}
