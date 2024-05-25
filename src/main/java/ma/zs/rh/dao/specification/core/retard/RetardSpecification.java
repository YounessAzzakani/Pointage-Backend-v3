package  ma.zs.rh.dao.specification.core.retard;

import ma.zs.rh.dao.criteria.core.retard.RetardCriteria;
import ma.zs.rh.bean.core.retard.Retard;
import ma.zs.rh.zynerator.specification.AbstractSpecification;


public class RetardSpecification extends  AbstractSpecification<RetardCriteria, Retard>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("dateRetard", criteria.getDateRetard(), criteria.getDateRetardFrom(), criteria.getDateRetardTo());
        addPredicateBigDecimal("nombreHeure", criteria.getNombreHeure(), criteria.getNombreHeureMin(), criteria.getNombreHeureMax());
        addPredicateFk("agent","id", criteria.getAgent()==null?null:criteria.getAgent().getId());
        addPredicateFk("agent","id", criteria.getAgents());
        addPredicateFk("agent","ref", criteria.getAgent()==null?null:criteria.getAgent().getRef());
        addPredicateFk("etatRetard","id", criteria.getEtatRetard()==null?null:criteria.getEtatRetard().getId());
        addPredicateFk("etatRetard","id", criteria.getEtatRetards());
        addPredicateFk("etatRetard","ref", criteria.getEtatRetard()==null?null:criteria.getEtatRetard().getRef());
        addPredicateFk("justificationRetard","id", criteria.getJustificationRetard()==null?null:criteria.getJustificationRetard().getId());
        addPredicateFk("justificationRetard","id", criteria.getJustificationRetards());
        addPredicateFk("justificationRetard","ref", criteria.getJustificationRetard()==null?null:criteria.getJustificationRetard().getRef());
    }

    public RetardSpecification(RetardCriteria criteria) {
        super(criteria);
    }

    public RetardSpecification(RetardCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
