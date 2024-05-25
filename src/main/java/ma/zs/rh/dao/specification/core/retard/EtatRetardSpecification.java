package  ma.zs.rh.dao.specification.core.retard;

import ma.zs.rh.dao.criteria.core.retard.EtatRetardCriteria;
import ma.zs.rh.bean.core.retard.EtatRetard;
import ma.zs.rh.zynerator.specification.AbstractSpecification;


public class EtatRetardSpecification extends  AbstractSpecification<EtatRetardCriteria, EtatRetard>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public EtatRetardSpecification(EtatRetardCriteria criteria) {
        super(criteria);
    }

    public EtatRetardSpecification(EtatRetardCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
