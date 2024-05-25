package  ma.zs.rh.dao.specification.core.pointage;

import ma.zs.rh.dao.criteria.core.pointage.PointageCriteria;
import ma.zs.rh.bean.core.pointage.Pointage;
import ma.zs.rh.zynerator.specification.AbstractSpecification;


public class PointageSpecification extends  AbstractSpecification<PointageCriteria, Pointage>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("datePointage", criteria.getDatePointage(), criteria.getDatePointageFrom(), criteria.getDatePointageTo());
        addPredicateInt("pointageSens", criteria.getPointageSens(), criteria.getPointageSensMin(), criteria.getPointageSensMax());
        addPredicateInt("pointeuse", criteria.getPointeuse(), criteria.getPointeuseMin(), criteria.getPointeuseMax());
        addPredicateFk("agent","id", criteria.getAgent()==null?null:criteria.getAgent().getId());
        addPredicateFk("agent","id", criteria.getAgents());
        addPredicateFk("agent","ref", criteria.getAgent()==null?null:criteria.getAgent().getRef());
    }

    public PointageSpecification(PointageCriteria criteria) {
        super(criteria);
    }

    public PointageSpecification(PointageCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
