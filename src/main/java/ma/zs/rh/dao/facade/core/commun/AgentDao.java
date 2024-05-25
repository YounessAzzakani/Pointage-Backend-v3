package ma.zs.rh.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.rh.zynerator.repository.AbstractRepository;
import ma.zs.rh.bean.core.commun.Agent;
import org.springframework.stereotype.Repository;
import ma.zs.rh.bean.core.commun.Agent;
import java.util.List;


@Repository
public interface AgentDao extends AbstractRepository<Agent,Long>  {
    Agent findByRef(String ref);
    int deleteByRef(String ref);

    List<Agent> findByEntiteAdministrativeId(Long id);
    int deleteByEntiteAdministrativeId(Long id);
    long countByEntiteAdministrativeRef(String ref);
    List<Agent> findByPosteId(Long id);
    int deleteByPosteId(Long id);
    long countByPosteRef(String ref);
    List<Agent> findByPlageHoraireId(Long id);
    int deleteByPlageHoraireId(Long id);
    long countByPlageHoraireRef(String ref);
    Agent findByUsername(String username);

    @Query("SELECT NEW Agent(item.id,item.ref) FROM Agent item")
    List<Agent> findAllOptimized();

}
