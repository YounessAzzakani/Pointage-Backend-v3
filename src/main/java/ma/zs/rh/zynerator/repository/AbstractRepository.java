package ma.zs.rh.zynerator.repository;

import ma.zs.rh.zynerator.bean.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractRepository<T extends BaseEntity, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
}
