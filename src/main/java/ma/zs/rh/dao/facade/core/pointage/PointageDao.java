package ma.zs.rh.dao.facade.core.pointage;

import org.springframework.data.jpa.repository.Query;
import ma.zs.rh.zynerator.repository.AbstractRepository;
import ma.zs.rh.bean.core.pointage.Pointage;
import org.springframework.stereotype.Repository;
import ma.zs.rh.bean.core.pointage.Pointage;
import java.util.List;


@Repository
public interface PointageDao extends AbstractRepository<Pointage,Long>  {
    Pointage findByRef(String ref);
    int deleteByRef(String ref);

    List<Pointage> findByAgentId(Long id);
    int deleteByAgentId(Long id);
    long countByAgentRef(String ref);

    @Query("SELECT NEW Pointage(item.id,item.ref) FROM Pointage item")
    List<Pointage> findAllOptimized();

    // New method to find pointages by agent ID and order by datePointage
    List<Pointage> findByAgentIdOrderByDatePointageAsc(Long agentId);
}
