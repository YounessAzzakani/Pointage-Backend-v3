package  ma.zs.rh.dao.specification.core.heuresupp;

import ma.zs.rh.dao.criteria.core.heuresupp.EtatTypeHeureSupplementaireCriteria;
import ma.zs.rh.bean.core.heuresupp.EtatTypeHeureSupplementaire;
import ma.zs.rh.zbiblio.specification.AbstractSpecification;


public class EtatTypeHeureSupplementaireSpecification extends  AbstractSpecification<EtatTypeHeureSupplementaireCriteria, EtatTypeHeureSupplementaire>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public EtatTypeHeureSupplementaireSpecification(EtatTypeHeureSupplementaireCriteria criteria) {
        super(criteria);
    }

    public EtatTypeHeureSupplementaireSpecification(EtatTypeHeureSupplementaireCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
