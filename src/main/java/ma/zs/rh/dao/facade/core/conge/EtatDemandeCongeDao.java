package ma.zs.rh.dao.facade.core.conge;

import org.springframework.data.jpa.repository.Query;
import ma.zs.rh.zynerator.repository.AbstractRepository;
import ma.zs.rh.bean.core.conge.EtatDemandeConge;
import org.springframework.stereotype.Repository;
import ma.zs.rh.bean.core.conge.EtatDemandeConge;
import java.util.List;


@Repository
public interface EtatDemandeCongeDao extends AbstractRepository<EtatDemandeConge,Long>  {
    EtatDemandeConge findByRef(String ref);
    int deleteByRef(String ref);


    @Query("SELECT NEW EtatDemandeConge(item.id,item.libelle) FROM EtatDemandeConge item")
    List<EtatDemandeConge> findAllOptimized();

}
