package  ma.zs.rh.dao.specification.core.abssence;

import ma.zs.rh.dao.criteria.core.abssence.RaisonAbsenceCriteria;
import ma.zs.rh.bean.core.abssence.RaisonAbsence;
import ma.zs.rh.zbiblio.specification.AbstractSpecification;


public class RaisonAbsenceSpecification extends  AbstractSpecification<RaisonAbsenceCriteria, RaisonAbsence>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public RaisonAbsenceSpecification(RaisonAbsenceCriteria criteria) {
        super(criteria);
    }

    public RaisonAbsenceSpecification(RaisonAbsenceCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
