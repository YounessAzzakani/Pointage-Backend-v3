package ma.zs.rh.dao.facade.core.docadmin;

import org.springframework.data.jpa.repository.Query;
import ma.zs.rh.zynerator.repository.AbstractRepository;
import ma.zs.rh.bean.core.docadmin.DemandeDocumentAdministratif;
import org.springframework.stereotype.Repository;
import ma.zs.rh.bean.core.docadmin.DemandeDocumentAdministratif;
import java.util.List;


@Repository
public interface DemandeDocumentAdministratifDao extends AbstractRepository<DemandeDocumentAdministratif,Long>  {
    DemandeDocumentAdministratif findByRef(String ref);
    int deleteByRef(String ref);

    List<DemandeDocumentAdministratif> findByTypeDocumentAdministratifId(Long id);
    int deleteByTypeDocumentAdministratifId(Long id);
    long countByTypeDocumentAdministratifRef(String ref);
    List<DemandeDocumentAdministratif> findByAgentId(Long id);
    int deleteByAgentId(Long id);
    long countByAgentRef(String ref);
    List<DemandeDocumentAdministratif> findByEtatDemandeDocumentAdministratifId(Long id);
    int deleteByEtatDemandeDocumentAdministratifId(Long id);
    long countByEtatDemandeDocumentAdministratifRef(String ref);
    List<DemandeDocumentAdministratif> findByEntiteAdministrativeId(Long id);
    int deleteByEntiteAdministrativeId(Long id);
    long countByEntiteAdministrativeRef(String ref);

    @Query("SELECT NEW DemandeDocumentAdministratif(item.id,item.libelle) FROM DemandeDocumentAdministratif item")
    List<DemandeDocumentAdministratif> findAllOptimized();

}
