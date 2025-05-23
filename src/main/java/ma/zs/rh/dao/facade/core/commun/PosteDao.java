package ma.zs.rh.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.rh.zynerator.repository.AbstractRepository;
import ma.zs.rh.bean.core.commun.Poste;
import org.springframework.stereotype.Repository;
import ma.zs.rh.bean.core.commun.Poste;
import java.util.List;


@Repository
public interface PosteDao extends AbstractRepository<Poste,Long>  {
    Poste findByRef(String ref);
    int deleteByRef(String ref);


    @Query("SELECT NEW Poste(item.id,item.libelle) FROM Poste item")
    List<Poste> findAllOptimized();

}
