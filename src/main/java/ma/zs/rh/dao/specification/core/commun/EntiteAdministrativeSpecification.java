package  ma.zs.rh.dao.specification.core.commun;

import ma.zs.rh.dao.criteria.core.commun.EntiteAdministrativeCriteria;
import ma.zs.rh.bean.core.commun.EntiteAdministrative;
import ma.zs.rh.zynerator.specification.AbstractSpecification;


public class EntiteAdministrativeSpecification extends  AbstractSpecification<EntiteAdministrativeCriteria, EntiteAdministrative>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateFk("chefService","id", criteria.getChefService()==null?null:criteria.getChefService().getId());
        addPredicateFk("chefService","id", criteria.getChefServices());
        addPredicateFk("chefService","ref", criteria.getChefService()==null?null:criteria.getChefService().getRef());
    }

    public EntiteAdministrativeSpecification(EntiteAdministrativeCriteria criteria) {
        super(criteria);
    }

    public EntiteAdministrativeSpecification(EntiteAdministrativeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
