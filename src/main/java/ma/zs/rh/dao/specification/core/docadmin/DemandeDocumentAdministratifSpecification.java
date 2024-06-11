package  ma.zs.rh.dao.specification.core.docadmin;

import ma.zs.rh.dao.criteria.core.docadmin.DemandeDocumentAdministratifCriteria;
import ma.zs.rh.bean.core.docadmin.DemandeDocumentAdministratif;
import ma.zs.rh.zbiblio.specification.AbstractSpecification;


public class DemandeDocumentAdministratifSpecification extends  AbstractSpecification<DemandeDocumentAdministratifCriteria, DemandeDocumentAdministratif>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateFk("typeDocumentAdministratif","id", criteria.getTypeDocumentAdministratif()==null?null:criteria.getTypeDocumentAdministratif().getId());
        addPredicateFk("typeDocumentAdministratif","id", criteria.getTypeDocumentAdministratifs());
        addPredicateFk("typeDocumentAdministratif","ref", criteria.getTypeDocumentAdministratif()==null?null:criteria.getTypeDocumentAdministratif().getRef());
        addPredicateFk("agent","id", criteria.getAgent()==null?null:criteria.getAgent().getId());
        addPredicateFk("agent","id", criteria.getAgents());
        addPredicateFk("agent","ref", criteria.getAgent()==null?null:criteria.getAgent().getRef());
        addPredicateFk("etatDemandeDocumentAdministratif","id", criteria.getEtatDemandeDocumentAdministratif()==null?null:criteria.getEtatDemandeDocumentAdministratif().getId());
        addPredicateFk("etatDemandeDocumentAdministratif","id", criteria.getEtatDemandeDocumentAdministratifs());
        addPredicateFk("etatDemandeDocumentAdministratif","ref", criteria.getEtatDemandeDocumentAdministratif()==null?null:criteria.getEtatDemandeDocumentAdministratif().getRef());
        addPredicateFk("entiteAdministrative","id", criteria.getEntiteAdministrative()==null?null:criteria.getEntiteAdministrative().getId());
        addPredicateFk("entiteAdministrative","id", criteria.getEntiteAdministratives());
        addPredicateFk("entiteAdministrative","ref", criteria.getEntiteAdministrative()==null?null:criteria.getEntiteAdministrative().getRef());
    }

    public DemandeDocumentAdministratifSpecification(DemandeDocumentAdministratifCriteria criteria) {
        super(criteria);
    }

    public DemandeDocumentAdministratifSpecification(DemandeDocumentAdministratifCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
