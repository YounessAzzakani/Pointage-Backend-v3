package ma.zs.rh.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.rh.zbiblio.repository.AbstractRepository;
import ma.zs.rh.bean.core.commun.EntiteAdministrative;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EntiteAdministrativeDao extends AbstractRepository<EntiteAdministrative,Long>  {
    EntiteAdministrative findByRef(String ref);
    int deleteByRef(String ref);

    List<EntiteAdministrative> findByChefServiceId(Long id);
    int deleteByChefServiceId(Long id);
    long countByChefServiceRef(String ref);

    @Query("SELECT NEW EntiteAdministrative(item.id,item.libelle) FROM EntiteAdministrative item")
    List<EntiteAdministrative> findAllOptimized();

}
