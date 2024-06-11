package ma.zs.rh.dao.facade.core.heuresupp;

import org.springframework.data.jpa.repository.Query;
import ma.zs.rh.zbiblio.repository.AbstractRepository;
import ma.zs.rh.bean.core.heuresupp.HeureSupplementaire;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HeureSupplementaireDao extends AbstractRepository<HeureSupplementaire,Long>  {
    HeureSupplementaire findByRef(String ref);
    int deleteByRef(String ref);

    List<HeureSupplementaire> findByTypeHeureSupplementaireId(Long id);
    int deleteByTypeHeureSupplementaireId(Long id);
    long countByTypeHeureSupplementaireRef(String ref);
    List<HeureSupplementaire> findByAgentId(Long id);
    int deleteByAgentId(Long id);
    long countByAgentRef(String ref);
    List<HeureSupplementaire> findByEtatTypeHeureSupplementaireId(Long id);
    int deleteByEtatTypeHeureSupplementaireId(Long id);
    long countByEtatTypeHeureSupplementaireRef(String ref);
    List<HeureSupplementaire> findByEntiteAdministrativeId(Long id);
    int deleteByEntiteAdministrativeId(Long id);
    long countByEntiteAdministrativeRef(String ref);

    @Query("SELECT NEW HeureSupplementaire(item.id,item.ref) FROM HeureSupplementaire item")
    List<HeureSupplementaire> findAllOptimized();

}
