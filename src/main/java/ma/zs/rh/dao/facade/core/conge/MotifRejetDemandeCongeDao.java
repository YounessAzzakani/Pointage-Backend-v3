package ma.zs.rh.dao.facade.core.conge;

import org.springframework.data.jpa.repository.Query;
import ma.zs.rh.zbiblio.repository.AbstractRepository;
import ma.zs.rh.bean.core.conge.MotifRejetDemandeConge;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MotifRejetDemandeCongeDao extends AbstractRepository<MotifRejetDemandeConge,Long>  {
    MotifRejetDemandeConge findByRef(String ref);
    int deleteByRef(String ref);


    @Query("SELECT NEW MotifRejetDemandeConge(item.id,item.libelle) FROM MotifRejetDemandeConge item")
    List<MotifRejetDemandeConge> findAllOptimized();

}
