package ma.zs.rh.zynerator.security.dao.specification.core;

import ma.zs.rh.zynerator.security.bean.ModelPermissionUser;
import ma.zs.rh.zynerator.security.dao.criteria.core.ModelPermissionUserCriteria;
import ma.zs.rh.zynerator.specification.AbstractSpecification;


public class ModelPermissionUserSpecification extends  AbstractSpecification<ModelPermissionUserCriteria, ModelPermissionUser>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBool("value", criteria.getValue());
        addPredicate("subAttribute", criteria.getSubAttribute(),criteria.getSubAttributeLike());
        addPredicateFk("actionPermission","id", criteria.getActionPermission()==null?null:criteria.getActionPermission().getId());
        addPredicateFk("actionPermission","id", criteria.getActionPermissions());
        addPredicateFk("actionPermission","reference", criteria.getActionPermission()==null?null:criteria.getActionPermission().getReference());
        addPredicateFk("modelPermission","id", criteria.getModelPermission()==null?null:criteria.getModelPermission().getId());
        addPredicateFk("modelPermission","id", criteria.getModelPermissions());
        addPredicateFk("modelPermission","reference", criteria.getModelPermission()==null?null:criteria.getModelPermission().getReference());
        addPredicateFk("user","id", criteria.getUser()==null?null:criteria.getUser().getId());
        addPredicateFk("user","id", criteria.getUsers());
        addPredicateFk("user","email", criteria.getUser()==null?null:criteria.getUser().getEmail());
    }

    public ModelPermissionUserSpecification(ModelPermissionUserCriteria criteria) {
        super(criteria);
    }

    public ModelPermissionUserSpecification(ModelPermissionUserCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
