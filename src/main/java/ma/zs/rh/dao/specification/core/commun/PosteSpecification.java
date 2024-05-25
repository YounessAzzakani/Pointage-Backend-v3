package  ma.zs.rh.dao.specification.core.commun;

import ma.zs.rh.dao.criteria.core.commun.PosteCriteria;
import ma.zs.rh.bean.core.commun.Poste;
import ma.zs.rh.zynerator.specification.AbstractSpecification;


public class PosteSpecification extends  AbstractSpecification<PosteCriteria, Poste>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public PosteSpecification(PosteCriteria criteria) {
        super(criteria);
    }

    public PosteSpecification(PosteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
