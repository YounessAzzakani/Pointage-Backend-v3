package  ma.zs.rh.dao.specification.core.docadmin;

import ma.zs.rh.dao.criteria.core.docadmin.TypeDocumentAdministratifCriteria;
import ma.zs.rh.bean.core.docadmin.TypeDocumentAdministratif;
import ma.zs.rh.zbiblio.specification.AbstractSpecification;


public class TypeDocumentAdministratifSpecification extends  AbstractSpecification<TypeDocumentAdministratifCriteria, TypeDocumentAdministratif>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public TypeDocumentAdministratifSpecification(TypeDocumentAdministratifCriteria criteria) {
        super(criteria);
    }

    public TypeDocumentAdministratifSpecification(TypeDocumentAdministratifCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
