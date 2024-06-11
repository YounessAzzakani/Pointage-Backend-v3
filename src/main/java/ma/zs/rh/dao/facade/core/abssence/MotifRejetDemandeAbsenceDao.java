package ma.zs.rh.dao.facade.core.abssence;

import org.springframework.data.jpa.repository.Query;
import ma.zs.rh.zbiblio.repository.AbstractRepository;
import ma.zs.rh.bean.core.abssence.MotifRejetDemandeAbsence;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MotifRejetDemandeAbsenceDao extends AbstractRepository<MotifRejetDemandeAbsence,Long>  {
    MotifRejetDemandeAbsence findByRef(String ref);
    int deleteByRef(String ref);


    @Query("SELECT NEW MotifRejetDemandeAbsence(item.id,item.libelle) FROM MotifRejetDemandeAbsence item")
    List<MotifRejetDemandeAbsence> findAllOptimized();

}
