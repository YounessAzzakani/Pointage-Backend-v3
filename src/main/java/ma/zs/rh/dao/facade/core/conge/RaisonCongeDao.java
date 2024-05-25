package ma.zs.rh.dao.facade.core.conge;

import org.springframework.data.jpa.repository.Query;
import ma.zs.rh.zynerator.repository.AbstractRepository;
import ma.zs.rh.bean.core.conge.RaisonConge;
import org.springframework.stereotype.Repository;
import ma.zs.rh.bean.core.conge.RaisonConge;
import java.util.List;


@Repository
public interface RaisonCongeDao extends AbstractRepository<RaisonConge,Long>  {
    RaisonConge findByRef(String ref);
    int deleteByRef(String ref);


    @Query("SELECT NEW RaisonConge(item.id,item.libelle) FROM RaisonConge item")
    List<RaisonConge> findAllOptimized();

}
