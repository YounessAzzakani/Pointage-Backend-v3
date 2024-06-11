package ma.zs.rh.dao.facade.core.retard;

import org.springframework.data.jpa.repository.Query;
import ma.zs.rh.zbiblio.repository.AbstractRepository;
import ma.zs.rh.bean.core.retard.Retard;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RetardDao extends AbstractRepository<Retard,Long>  {
    Retard findByRef(String ref);
    int deleteByRef(String ref);

    List<Retard> findByAgentId(Long id);
    int deleteByAgentId(Long id);
    long countByAgentRef(String ref);
    List<Retard> findByEtatRetardId(Long id);
    int deleteByEtatRetardId(Long id);
    long countByEtatRetardRef(String ref);
    List<Retard> findByJustificationRetardId(Long id);
    int deleteByJustificationRetardId(Long id);
    long countByJustificationRetardRef(String ref);

    @Query("SELECT NEW Retard(item.id,item.ref) FROM Retard item")
    List<Retard> findAllOptimized();

}
