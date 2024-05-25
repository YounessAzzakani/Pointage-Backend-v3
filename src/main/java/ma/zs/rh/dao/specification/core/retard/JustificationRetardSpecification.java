package  ma.zs.rh.dao.specification.core.retard;

import ma.zs.rh.dao.criteria.core.retard.JustificationRetardCriteria;
import ma.zs.rh.bean.core.retard.JustificationRetard;
import ma.zs.rh.zynerator.specification.AbstractSpecification;


public class JustificationRetardSpecification extends  AbstractSpecification<JustificationRetardCriteria, JustificationRetard>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public JustificationRetardSpecification(JustificationRetardCriteria criteria) {
        super(criteria);
    }

    public JustificationRetardSpecification(JustificationRetardCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
