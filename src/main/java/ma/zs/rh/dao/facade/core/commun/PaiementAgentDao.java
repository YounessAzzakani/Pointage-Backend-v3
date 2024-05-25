package ma.zs.rh.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.rh.zynerator.repository.AbstractRepository;
import ma.zs.rh.bean.core.commun.PaiementAgent;
import org.springframework.stereotype.Repository;
import ma.zs.rh.bean.core.commun.PaiementAgent;
import java.util.List;


@Repository
public interface PaiementAgentDao extends AbstractRepository<PaiementAgent,Long>  {
    PaiementAgent findByRef(String ref);
    int deleteByRef(String ref);

    List<PaiementAgent> findByAgentId(Long id);
    int deleteByAgentId(Long id);
    long countByAgentRef(String ref);

    @Query("SELECT NEW PaiementAgent(item.id,item.ref) FROM PaiementAgent item")
    List<PaiementAgent> findAllOptimized();

}
