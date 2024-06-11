package  ma.zs.rh.dao.specification.core.conge;

import ma.zs.rh.dao.criteria.core.conge.MotifRejetDemandeCongeCriteria;
import ma.zs.rh.bean.core.conge.MotifRejetDemandeConge;
import ma.zs.rh.zbiblio.specification.AbstractSpecification;


public class MotifRejetDemandeCongeSpecification extends  AbstractSpecification<MotifRejetDemandeCongeCriteria, MotifRejetDemandeConge>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public MotifRejetDemandeCongeSpecification(MotifRejetDemandeCongeCriteria criteria) {
        super(criteria);
    }

    public MotifRejetDemandeCongeSpecification(MotifRejetDemandeCongeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
