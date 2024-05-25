package  ma.zs.rh.dao.specification.core.abssence;

import ma.zs.rh.dao.criteria.core.abssence.MotifRejetDemandeAbsenceCriteria;
import ma.zs.rh.bean.core.abssence.MotifRejetDemandeAbsence;
import ma.zs.rh.zynerator.specification.AbstractSpecification;


public class MotifRejetDemandeAbsenceSpecification extends  AbstractSpecification<MotifRejetDemandeAbsenceCriteria, MotifRejetDemandeAbsence>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public MotifRejetDemandeAbsenceSpecification(MotifRejetDemandeAbsenceCriteria criteria) {
        super(criteria);
    }

    public MotifRejetDemandeAbsenceSpecification(MotifRejetDemandeAbsenceCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
