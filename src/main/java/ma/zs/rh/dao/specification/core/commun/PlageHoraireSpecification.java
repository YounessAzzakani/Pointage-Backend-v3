package  ma.zs.rh.dao.specification.core.commun;

import ma.zs.rh.dao.criteria.core.commun.PlageHoraireCriteria;
import ma.zs.rh.bean.core.commun.PlageHoraire;
import ma.zs.rh.zynerator.specification.AbstractSpecification;


public class PlageHoraireSpecification extends  AbstractSpecification<PlageHoraireCriteria, PlageHoraire>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("typeHoraire", criteria.getTypeHoraire(),criteria.getTypeHoraireLike());
        addPredicate("heureDebut", criteria.getHeureDebut(), criteria.getHeureDebutFrom(), criteria.getHeureDebutTo());
    }

    public PlageHoraireSpecification(PlageHoraireCriteria criteria) {
        super(criteria);
    }

    public PlageHoraireSpecification(PlageHoraireCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
