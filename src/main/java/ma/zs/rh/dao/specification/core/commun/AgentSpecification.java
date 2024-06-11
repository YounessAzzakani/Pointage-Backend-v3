package  ma.zs.rh.dao.specification.core.commun;

import ma.zs.rh.dao.criteria.core.commun.AgentCriteria;
import ma.zs.rh.bean.core.commun.Agent;
import ma.zs.rh.zbiblio.specification.AbstractSpecification;


public class AgentSpecification extends  AbstractSpecification<AgentCriteria, Agent>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("adresse", criteria.getAdresse(),criteria.getAdresseLike());
        addPredicateBigDecimal("thm", criteria.getThm(), criteria.getThmMin(), criteria.getThmMax());
        addPredicateBigDecimal("salaire", criteria.getSalaire(), criteria.getSalaireMin(), criteria.getSalaireMax());
        addPredicateBool("credentialsNonExpired", criteria.getCredentialsNonExpired());
        addPredicateBool("enabled", criteria.getEnabled());
        addPredicateBool("accountNonExpired", criteria.getAccountNonExpired());
        addPredicateBool("accountNonLocked", criteria.getAccountNonLocked());
        addPredicateBool("passwordChanged", criteria.getPasswordChanged());
        addPredicate("username", criteria.getUsername(),criteria.getUsernameLike());
        addPredicate("password", criteria.getPassword(),criteria.getPasswordLike());
        addPredicateFk("entiteAdministrative","id", criteria.getEntiteAdministrative()==null?null:criteria.getEntiteAdministrative().getId());
        addPredicateFk("entiteAdministrative","id", criteria.getEntiteAdministratives());
        addPredicateFk("entiteAdministrative","ref", criteria.getEntiteAdministrative()==null?null:criteria.getEntiteAdministrative().getRef());
        addPredicateFk("poste","id", criteria.getPoste()==null?null:criteria.getPoste().getId());
        addPredicateFk("poste","id", criteria.getPostes());
        addPredicateFk("poste","ref", criteria.getPoste()==null?null:criteria.getPoste().getRef());
        addPredicateFk("plageHoraire","id", criteria.getPlageHoraire()==null?null:criteria.getPlageHoraire().getId());
        addPredicateFk("plageHoraire","id", criteria.getPlageHoraires());
        addPredicateFk("plageHoraire","ref", criteria.getPlageHoraire()==null?null:criteria.getPlageHoraire().getRef());
    }

    public AgentSpecification(AgentCriteria criteria) {
        super(criteria);
    }

    public AgentSpecification(AgentCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
