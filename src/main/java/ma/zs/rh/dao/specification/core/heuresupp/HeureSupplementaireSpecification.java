package  ma.zs.rh.dao.specification.core.heuresupp;

import ma.zs.rh.dao.criteria.core.heuresupp.HeureSupplementaireCriteria;
import ma.zs.rh.bean.core.heuresupp.HeureSupplementaire;
import ma.zs.rh.zbiblio.specification.AbstractSpecification;


public class HeureSupplementaireSpecification extends  AbstractSpecification<HeureSupplementaireCriteria, HeureSupplementaire>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicateInt("nbrHeure", criteria.getNbrHeure(), criteria.getNbrHeureMin(), criteria.getNbrHeureMax());
        addPredicateBigDecimal("thm", criteria.getThm(), criteria.getThmMin(), criteria.getThmMax());
        addPredicateFk("typeHeureSupplementaire","id", criteria.getTypeHeureSupplementaire()==null?null:criteria.getTypeHeureSupplementaire().getId());
        addPredicateFk("typeHeureSupplementaire","id", criteria.getTypeHeureSupplementaires());
        addPredicateFk("typeHeureSupplementaire","ref", criteria.getTypeHeureSupplementaire()==null?null:criteria.getTypeHeureSupplementaire().getRef());
        addPredicateFk("agent","id", criteria.getAgent()==null?null:criteria.getAgent().getId());
        addPredicateFk("agent","id", criteria.getAgents());
        addPredicateFk("agent","ref", criteria.getAgent()==null?null:criteria.getAgent().getRef());
        addPredicateFk("etatTypeHeureSupplementaire","id", criteria.getEtatTypeHeureSupplementaire()==null?null:criteria.getEtatTypeHeureSupplementaire().getId());
        addPredicateFk("etatTypeHeureSupplementaire","id", criteria.getEtatTypeHeureSupplementaires());
        addPredicateFk("etatTypeHeureSupplementaire","ref", criteria.getEtatTypeHeureSupplementaire()==null?null:criteria.getEtatTypeHeureSupplementaire().getRef());
        addPredicateFk("entiteAdministrative","id", criteria.getEntiteAdministrative()==null?null:criteria.getEntiteAdministrative().getId());
        addPredicateFk("entiteAdministrative","id", criteria.getEntiteAdministratives());
        addPredicateFk("entiteAdministrative","ref", criteria.getEntiteAdministrative()==null?null:criteria.getEntiteAdministrative().getRef());
    }

    public HeureSupplementaireSpecification(HeureSupplementaireCriteria criteria) {
        super(criteria);
    }

    public HeureSupplementaireSpecification(HeureSupplementaireCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
