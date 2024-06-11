package  ma.zs.rh.dao.specification.core.heuresupp;

import ma.zs.rh.dao.criteria.core.heuresupp.TypeHeureSupplementaireCriteria;
import ma.zs.rh.bean.core.heuresupp.TypeHeureSupplementaire;
import ma.zs.rh.zbiblio.specification.AbstractSpecification;


public class TypeHeureSupplementaireSpecification extends  AbstractSpecification<TypeHeureSupplementaireCriteria, TypeHeureSupplementaire>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateBigDecimal("pourcentage", criteria.getPourcentage(), criteria.getPourcentageMin(), criteria.getPourcentageMax());
    }

    public TypeHeureSupplementaireSpecification(TypeHeureSupplementaireCriteria criteria) {
        super(criteria);
    }

    public TypeHeureSupplementaireSpecification(TypeHeureSupplementaireCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
