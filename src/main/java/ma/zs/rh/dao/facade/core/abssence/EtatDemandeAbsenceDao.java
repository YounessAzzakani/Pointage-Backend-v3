package ma.zs.rh.dao.facade.core.abssence;

import org.springframework.data.jpa.repository.Query;
import ma.zs.rh.zbiblio.repository.AbstractRepository;
import ma.zs.rh.bean.core.abssence.EtatDemandeAbsence;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EtatDemandeAbsenceDao extends AbstractRepository<EtatDemandeAbsence,Long>  {
    EtatDemandeAbsence findByRef(String ref);
    int deleteByRef(String ref);


    @Query("SELECT NEW EtatDemandeAbsence(item.id,item.libelle) FROM EtatDemandeAbsence item")
    List<EtatDemandeAbsence> findAllOptimized();

}
