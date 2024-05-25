package  ma.zs.rh.dao.specification.core.abssence;

import ma.zs.rh.dao.criteria.core.abssence.EtatDemandeAbsenceCriteria;
import ma.zs.rh.bean.core.abssence.EtatDemandeAbsence;
import ma.zs.rh.zynerator.specification.AbstractSpecification;


public class EtatDemandeAbsenceSpecification extends  AbstractSpecification<EtatDemandeAbsenceCriteria, EtatDemandeAbsence>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public EtatDemandeAbsenceSpecification(EtatDemandeAbsenceCriteria criteria) {
        super(criteria);
    }

    public EtatDemandeAbsenceSpecification(EtatDemandeAbsenceCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
