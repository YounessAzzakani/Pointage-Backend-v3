package ma.zs.rh.dao.facade.core.heuresupp;

import org.springframework.data.jpa.repository.Query;
import ma.zs.rh.zynerator.repository.AbstractRepository;
import ma.zs.rh.bean.core.heuresupp.TypeHeureSupplementaire;
import org.springframework.stereotype.Repository;
import ma.zs.rh.bean.core.heuresupp.TypeHeureSupplementaire;
import java.util.List;


@Repository
public interface TypeHeureSupplementaireDao extends AbstractRepository<TypeHeureSupplementaire,Long>  {
    TypeHeureSupplementaire findByRef(String ref);
    int deleteByRef(String ref);


    @Query("SELECT NEW TypeHeureSupplementaire(item.id,item.libelle) FROM TypeHeureSupplementaire item")
    List<TypeHeureSupplementaire> findAllOptimized();

}
