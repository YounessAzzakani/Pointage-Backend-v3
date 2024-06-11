package  ma.zs.rh.dao.specification.core.abssence;

import ma.zs.rh.dao.criteria.core.abssence.DemandeAbsenceCriteria;
import ma.zs.rh.bean.core.abssence.DemandeAbsence;
import ma.zs.rh.zbiblio.specification.AbstractSpecification;


public class DemandeAbsenceSpecification extends  AbstractSpecification<DemandeAbsenceCriteria, DemandeAbsence>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("dateDepart", criteria.getDateDepart(), criteria.getDateDepartFrom(), criteria.getDateDepartTo());
        addPredicate("dateFin", criteria.getDateFin(), criteria.getDateFinFrom(), criteria.getDateFinTo());
        addPredicateInt("nombreJour", criteria.getNombreJour(), criteria.getNombreJourMin(), criteria.getNombreJourMax());
        addPredicateFk("motifRejetDemandeAbsence","id", criteria.getMotifRejetDemandeAbsence()==null?null:criteria.getMotifRejetDemandeAbsence().getId());
        addPredicateFk("motifRejetDemandeAbsence","id", criteria.getMotifRejetDemandeAbsences());
        addPredicateFk("motifRejetDemandeAbsence","ref", criteria.getMotifRejetDemandeAbsence()==null?null:criteria.getMotifRejetDemandeAbsence().getRef());
        addPredicateFk("entiteAdministrative","id", criteria.getEntiteAdministrative()==null?null:criteria.getEntiteAdministrative().getId());
        addPredicateFk("entiteAdministrative","id", criteria.getEntiteAdministratives());
        addPredicateFk("entiteAdministrative","ref", criteria.getEntiteAdministrative()==null?null:criteria.getEntiteAdministrative().getRef());
        addPredicateFk("manager","id", criteria.getManager()==null?null:criteria.getManager().getId());
        addPredicateFk("manager","id", criteria.getManagers());
        addPredicateFk("manager","ref", criteria.getManager()==null?null:criteria.getManager().getRef());
        addPredicateFk("agent","id", criteria.getAgent()==null?null:criteria.getAgent().getId());
        addPredicateFk("agent","id", criteria.getAgents());
        addPredicateFk("agent","ref", criteria.getAgent()==null?null:criteria.getAgent().getRef());
        addPredicateFk("raisonAbsence","id", criteria.getRaisonAbsence()==null?null:criteria.getRaisonAbsence().getId());
        addPredicateFk("raisonAbsence","id", criteria.getRaisonAbsences());
        addPredicateFk("raisonAbsence","ref", criteria.getRaisonAbsence()==null?null:criteria.getRaisonAbsence().getRef());
        addPredicateFk("etatDemandeAbsence","id", criteria.getEtatDemandeAbsence()==null?null:criteria.getEtatDemandeAbsence().getId());
        addPredicateFk("etatDemandeAbsence","id", criteria.getEtatDemandeAbsences());
        addPredicateFk("etatDemandeAbsence","ref", criteria.getEtatDemandeAbsence()==null?null:criteria.getEtatDemandeAbsence().getRef());
    }

    public DemandeAbsenceSpecification(DemandeAbsenceCriteria criteria) {
        super(criteria);
    }

    public DemandeAbsenceSpecification(DemandeAbsenceCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
