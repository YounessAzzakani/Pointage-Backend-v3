package ma.zs.rh.dao.facade.core.docadmin;

import org.springframework.data.jpa.repository.Query;
import ma.zs.rh.zynerator.repository.AbstractRepository;
import ma.zs.rh.bean.core.docadmin.EtatDemandeDocumentAdministratif;
import org.springframework.stereotype.Repository;
import ma.zs.rh.bean.core.docadmin.EtatDemandeDocumentAdministratif;
import java.util.List;


@Repository
public interface EtatDemandeDocumentAdministratifDao extends AbstractRepository<EtatDemandeDocumentAdministratif,Long>  {
    EtatDemandeDocumentAdministratif findByRef(String ref);
    int deleteByRef(String ref);


    @Query("SELECT NEW EtatDemandeDocumentAdministratif(item.id,item.libelle) FROM EtatDemandeDocumentAdministratif item")
    List<EtatDemandeDocumentAdministratif> findAllOptimized();

}
