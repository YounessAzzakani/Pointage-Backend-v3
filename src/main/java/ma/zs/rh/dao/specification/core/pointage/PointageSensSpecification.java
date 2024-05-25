package  ma.zs.rh.dao.specification.core.pointage;

import ma.zs.rh.dao.criteria.core.pointage.PointageSensCriteria;
import ma.zs.rh.bean.core.pointage.PointageSens;
import ma.zs.rh.zynerator.specification.AbstractSpecification;


public class PointageSensSpecification extends  AbstractSpecification<PointageSensCriteria, PointageSens>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public PointageSensSpecification(PointageSensCriteria criteria) {
        super(criteria);
    }

    public PointageSensSpecification(PointageSensCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
