package ma.zs.rh.zynerator.service;

import ma.zs.rh.zynerator.bean.BaseEntity;
import ma.zs.rh.zynerator.criteria.BaseCriteria;
import ma.zs.rh.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends BaseEntity, CRITERIA extends BaseCriteria, REPO extends AbstractRepository<T, Long>> extends AbstractServiceImpl<T, CRITERIA, REPO> {

    public AbstractReferentielServiceImpl(REPO dao) {
        super(dao);
    }

}
