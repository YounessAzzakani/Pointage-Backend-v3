package  ma.zs.rh.dao.specification.core.conge;

import ma.zs.rh.dao.criteria.core.conge.DemandeCongeCriteria;
import ma.zs.rh.bean.core.conge.DemandeConge;
import ma.zs.rh.zbiblio.specification.AbstractSpecification;


public class DemandeCongeSpecification extends  AbstractSpecification<DemandeCongeCriteria, DemandeConge>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("dateDepart", criteria.getDateDepart(), criteria.getDateDepartFrom(), criteria.getDateDepartTo());
        addPredicate("dateFin", criteria.getDateFin(), criteria.getDateFinFrom(), criteria.getDateFinTo());
        addPredicateInt("nombreJour", criteria.getNombreJour(), criteria.getNombreJourMin(), criteria.getNombreJourMax());
        addPredicateFk("motifRejetDemandeConge","id", criteria.getMotifRejetDemandeConge()==null?null:criteria.getMotifRejetDemandeConge().getId());
        addPredicateFk("motifRejetDemandeConge","id", criteria.getMotifRejetDemandeConges());
        addPredicateFk("motifRejetDemandeConge","ref", criteria.getMotifRejetDemandeConge()==null?null:criteria.getMotifRejetDemandeConge().getRef());
        addPredicateFk("manager","id", criteria.getManager()==null?null:criteria.getManager().getId());
        addPredicateFk("manager","id", criteria.getManagers());
        addPredicateFk("manager","ref", criteria.getManager()==null?null:criteria.getManager().getRef());
        addPredicateFk("agent","id", criteria.getAgent()==null?null:criteria.getAgent().getId());
        addPredicateFk("agent","id", criteria.getAgents());
        addPredicateFk("agent","ref", criteria.getAgent()==null?null:criteria.getAgent().getRef());
        addPredicateFk("raisonConge","id", criteria.getRaisonConge()==null?null:criteria.getRaisonConge().getId());
        addPredicateFk("raisonConge","id", criteria.getRaisonConges());
        addPredicateFk("raisonConge","ref", criteria.getRaisonConge()==null?null:criteria.getRaisonConge().getRef());
        addPredicateFk("etatDemandeConge","id", criteria.getEtatDemandeConge()==null?null:criteria.getEtatDemandeConge().getId());
        addPredicateFk("etatDemandeConge","id", criteria.getEtatDemandeConges());
        addPredicateFk("etatDemandeConge","ref", criteria.getEtatDemandeConge()==null?null:criteria.getEtatDemandeConge().getRef());
        addPredicateFk("entiteAdministrative","id", criteria.getEntiteAdministrative()==null?null:criteria.getEntiteAdministrative().getId());
        addPredicateFk("entiteAdministrative","id", criteria.getEntiteAdministratives());
        addPredicateFk("entiteAdministrative","ref", criteria.getEntiteAdministrative()==null?null:criteria.getEntiteAdministrative().getRef());
    }

    public DemandeCongeSpecification(DemandeCongeCriteria criteria) {
        super(criteria);
    }

    public DemandeCongeSpecification(DemandeCongeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
