package ma.zs.rh.dao.facade.core.heuresupp;

import org.springframework.data.jpa.repository.Query;
import ma.zs.rh.zbiblio.repository.AbstractRepository;
import ma.zs.rh.bean.core.heuresupp.EtatTypeHeureSupplementaire;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EtatTypeHeureSupplementaireDao extends AbstractRepository<EtatTypeHeureSupplementaire,Long>  {
    EtatTypeHeureSupplementaire findByRef(String ref);
    int deleteByRef(String ref);


    @Query("SELECT NEW EtatTypeHeureSupplementaire(item.id,item.libelle) FROM EtatTypeHeureSupplementaire item")
    List<EtatTypeHeureSupplementaire> findAllOptimized();

}
