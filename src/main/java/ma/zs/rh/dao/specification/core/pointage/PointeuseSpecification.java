package  ma.zs.rh.dao.specification.core.pointage;

import ma.zs.rh.dao.criteria.core.pointage.PointeuseCriteria;
import ma.zs.rh.bean.core.pointage.Pointeuse;
import ma.zs.rh.zbiblio.specification.AbstractSpecification;


public class PointeuseSpecification extends  AbstractSpecification<PointeuseCriteria, Pointeuse>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public PointeuseSpecification(PointeuseCriteria criteria) {
        super(criteria);
    }

    public PointeuseSpecification(PointeuseCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
