package  ma.zs.rh.dao.specification.core.conge;

import ma.zs.rh.dao.criteria.core.conge.RaisonCongeCriteria;
import ma.zs.rh.bean.core.conge.RaisonConge;
import ma.zs.rh.zynerator.specification.AbstractSpecification;


public class RaisonCongeSpecification extends  AbstractSpecification<RaisonCongeCriteria, RaisonConge>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public RaisonCongeSpecification(RaisonCongeCriteria criteria) {
        super(criteria);
    }

    public RaisonCongeSpecification(RaisonCongeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
