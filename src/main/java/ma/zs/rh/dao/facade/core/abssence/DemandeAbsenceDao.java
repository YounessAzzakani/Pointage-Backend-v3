package ma.zs.rh.dao.facade.core.abssence;

import org.springframework.data.jpa.repository.Query;
import ma.zs.rh.zbiblio.repository.AbstractRepository;
import ma.zs.rh.bean.core.abssence.DemandeAbsence;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DemandeAbsenceDao extends AbstractRepository<DemandeAbsence,Long>  {
    DemandeAbsence findByRef(String ref);
    int deleteByRef(String ref);

    List<DemandeAbsence> findByAgentRef(String ref);


    List<DemandeAbsence> findByMotifRejetDemandeAbsenceId(Long id);
    int deleteByMotifRejetDemandeAbsenceId(Long id);
    long countByMotifRejetDemandeAbsenceRef(String ref);
    List<DemandeAbsence> findByEntiteAdministrativeId(Long id);
    int deleteByEntiteAdministrativeId(Long id);
    long countByEntiteAdministrativeRef(String ref);
    List<DemandeAbsence> findByManagerId(Long id);
    int deleteByManagerId(Long id);
    long countByManagerRef(String ref);
    List<DemandeAbsence> findByAgentId(Long id);
    int deleteByAgentId(Long id);
    long countByAgentRef(String ref);
    List<DemandeAbsence> findByRaisonAbsenceId(Long id);
    int deleteByRaisonAbsenceId(Long id);
    long countByRaisonAbsenceRef(String ref);
    List<DemandeAbsence> findByEtatDemandeAbsenceId(Long id);
    int deleteByEtatDemandeAbsenceId(Long id);
    long countByEtatDemandeAbsenceRef(String ref);

    @Query("SELECT NEW DemandeAbsence(item.id,item.ref) FROM DemandeAbsence item")
    List<DemandeAbsence> findAllOptimized();

}
