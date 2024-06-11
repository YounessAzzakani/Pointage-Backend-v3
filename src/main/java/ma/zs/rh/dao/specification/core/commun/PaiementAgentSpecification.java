package  ma.zs.rh.dao.specification.core.commun;

import ma.zs.rh.dao.criteria.core.commun.PaiementAgentCriteria;
import ma.zs.rh.bean.core.commun.PaiementAgent;
import ma.zs.rh.zbiblio.specification.AbstractSpecification;


public class PaiementAgentSpecification extends  AbstractSpecification<PaiementAgentCriteria, PaiementAgent>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicateInt("mois", criteria.getMois(), criteria.getMoisMin(), criteria.getMoisMax());
        addPredicateInt("annee", criteria.getAnnee(), criteria.getAnneeMin(), criteria.getAnneeMax());
        addPredicateBigDecimal("thm", criteria.getThm(), criteria.getThmMin(), criteria.getThmMax());
        addPredicateInt("totalHoraireTravail", criteria.getTotalHoraireTravail(), criteria.getTotalHoraireTravailMin(), criteria.getTotalHoraireTravailMax());
        addPredicateBigDecimal("montantHoraireTravail", criteria.getMontantHoraireTravail(), criteria.getMontantHoraireTravailMin(), criteria.getMontantHoraireTravailMax());
        addPredicateBigDecimal("totalHoraireAbsence", criteria.getTotalHoraireAbsence(), criteria.getTotalHoraireAbsenceMin(), criteria.getTotalHoraireAbsenceMax());
        addPredicateBigDecimal("montantHoraireAbsence", criteria.getMontantHoraireAbsence(), criteria.getMontantHoraireAbsenceMin(), criteria.getMontantHoraireAbsenceMax());
        addPredicateBigDecimal("totalHoraireSupplementaire", criteria.getTotalHoraireSupplementaire(), criteria.getTotalHoraireSupplementaireMin(), criteria.getTotalHoraireSupplementaireMax());
        addPredicateBigDecimal("montantHoraireSupplementaire", criteria.getMontantHoraireSupplementaire(), criteria.getMontantHoraireSupplementaireMin(), criteria.getMontantHoraireSupplementaireMax());
        addPredicateBigDecimal("salaireBase", criteria.getSalaireBase(), criteria.getSalaireBaseMin(), criteria.getSalaireBaseMax());
        addPredicateBigDecimal("salaire", criteria.getSalaire(), criteria.getSalaireMin(), criteria.getSalaireMax());
        addPredicateFk("agent","id", criteria.getAgent()==null?null:criteria.getAgent().getId());
        addPredicateFk("agent","id", criteria.getAgents());
        addPredicateFk("agent","ref", criteria.getAgent()==null?null:criteria.getAgent().getRef());
    }

    public PaiementAgentSpecification(PaiementAgentCriteria criteria) {
        super(criteria);
    }

    public PaiementAgentSpecification(PaiementAgentCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
