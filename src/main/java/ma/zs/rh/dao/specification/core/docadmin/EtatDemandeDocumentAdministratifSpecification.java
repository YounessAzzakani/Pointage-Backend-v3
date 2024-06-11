package  ma.zs.rh.dao.specification.core.docadmin;

import ma.zs.rh.dao.criteria.core.docadmin.EtatDemandeDocumentAdministratifCriteria;
import ma.zs.rh.bean.core.docadmin.EtatDemandeDocumentAdministratif;
import ma.zs.rh.zbiblio.specification.AbstractSpecification;


public class EtatDemandeDocumentAdministratifSpecification extends  AbstractSpecification<EtatDemandeDocumentAdministratifCriteria, EtatDemandeDocumentAdministratif>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public EtatDemandeDocumentAdministratifSpecification(EtatDemandeDocumentAdministratifCriteria criteria) {
        super(criteria);
    }

    public EtatDemandeDocumentAdministratifSpecification(EtatDemandeDocumentAdministratifCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
