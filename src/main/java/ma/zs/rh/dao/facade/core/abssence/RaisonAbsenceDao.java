package ma.zs.rh.dao.facade.core.abssence;

import org.springframework.data.jpa.repository.Query;
import ma.zs.rh.zbiblio.repository.AbstractRepository;
import ma.zs.rh.bean.core.abssence.RaisonAbsence;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RaisonAbsenceDao extends AbstractRepository<RaisonAbsence,Long>  {
    RaisonAbsence findByRef(String ref);
    int deleteByRef(String ref);


    @Query("SELECT NEW RaisonAbsence(item.id,item.libelle) FROM RaisonAbsence item")
    List<RaisonAbsence> findAllOptimized();

}
