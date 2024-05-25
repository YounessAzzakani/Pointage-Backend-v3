package ma.zs.rh.dao.facade.core.conge;

import org.springframework.data.jpa.repository.Query;
import ma.zs.rh.zynerator.repository.AbstractRepository;
import ma.zs.rh.bean.core.conge.DemandeConge;
import org.springframework.stereotype.Repository;
import ma.zs.rh.bean.core.conge.DemandeConge;
import java.util.List;


@Repository
public interface DemandeCongeDao extends AbstractRepository<DemandeConge,Long>  {
    DemandeConge findByRef(String ref);
    int deleteByRef(String ref);

    List<DemandeConge> findByMotifRejetDemandeCongeId(Long id);
    int deleteByMotifRejetDemandeCongeId(Long id);
    long countByMotifRejetDemandeCongeRef(String ref);
    List<DemandeConge> findByManagerId(Long id);
    int deleteByManagerId(Long id);
    long countByManagerRef(String ref);
    List<DemandeConge> findByAgentId(Long id);
    int deleteByAgentId(Long id);
    long countByAgentRef(String ref);
    List<DemandeConge> findByRaisonCongeId(Long id);
    int deleteByRaisonCongeId(Long id);
    long countByRaisonCongeRef(String ref);
    List<DemandeConge> findByEtatDemandeCongeId(Long id);
    int deleteByEtatDemandeCongeId(Long id);
    long countByEtatDemandeCongeRef(String ref);
    List<DemandeConge> findByEntiteAdministrativeId(Long id);
    int deleteByEntiteAdministrativeId(Long id);
    long countByEntiteAdministrativeRef(String ref);

    @Query("SELECT NEW DemandeConge(item.id,item.ref) FROM DemandeConge item")
    List<DemandeConge> findAllOptimized();

}
