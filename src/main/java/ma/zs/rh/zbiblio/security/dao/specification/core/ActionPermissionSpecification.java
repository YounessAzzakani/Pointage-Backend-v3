package ma.zs.rh.zbiblio.security.dao.specification.core;

import ma.zs.rh.zbiblio.security.bean.ActionPermission;
import ma.zs.rh.zbiblio.security.dao.criteria.core.ActionPermissionCriteria;
import ma.zs.rh.zbiblio.specification.AbstractSpecification;


public class ActionPermissionSpecification extends  AbstractSpecification<ActionPermissionCriteria, ActionPermission>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public ActionPermissionSpecification(ActionPermissionCriteria criteria) {
        super(criteria);
    }

    public ActionPermissionSpecification(ActionPermissionCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
