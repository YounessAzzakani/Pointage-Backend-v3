package  ma.zs.rh.dao.specification.core.conge;

import ma.zs.rh.dao.criteria.core.conge.EtatDemandeCongeCriteria;
import ma.zs.rh.bean.core.conge.EtatDemandeConge;
import ma.zs.rh.zynerator.specification.AbstractSpecification;


public class EtatDemandeCongeSpecification extends  AbstractSpecification<EtatDemandeCongeCriteria, EtatDemandeConge>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public EtatDemandeCongeSpecification(EtatDemandeCongeCriteria criteria) {
        super(criteria);
    }

    public EtatDemandeCongeSpecification(EtatDemandeCongeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
