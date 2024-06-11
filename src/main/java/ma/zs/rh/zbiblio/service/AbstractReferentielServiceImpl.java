package ma.zs.rh.zbiblio.service;

import ma.zs.rh.zbiblio.bean.BaseEntity;
import ma.zs.rh.zbiblio.criteria.BaseCriteria;
import ma.zs.rh.zbiblio.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends BaseEntity, CRITERIA extends BaseCriteria, REPO extends AbstractRepository<T, Long>> extends AbstractServiceImpl<T, CRITERIA, REPO> {

    public AbstractReferentielServiceImpl(REPO dao) {
        super(dao);
    }

}
