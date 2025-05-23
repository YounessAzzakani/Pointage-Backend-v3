package ma.zs.rh.zynerator.security.dao.specification.core;

import ma.zs.rh.zynerator.security.bean.User;
import ma.zs.rh.zynerator.security.dao.criteria.core.UserCriteria;
import ma.zs.rh.zynerator.specification.AbstractSpecification;


public class UserSpecification extends  AbstractSpecification<UserCriteria, User>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBool("credentialsNonExpired", criteria.getCredentialsNonExpired());
        addPredicateBool("enabled", criteria.getEnabled());
        addPredicate("email", criteria.getEmail(),criteria.getEmailLike());
        addPredicateBool("accountNonExpired", criteria.getAccountNonExpired());
        addPredicateBool("accountNonLocked", criteria.getAccountNonLocked());
        addPredicate("username", criteria.getUsername(),criteria.getUsernameLike());
        addPredicate("fullName", criteria.getFullName(),criteria.getFullNameLike());
        addPredicate("firstName", criteria.getFirstName(),criteria.getFirstNameLike());
        addPredicate("lastName", criteria.getLastName(),criteria.getLastNameLike());
        addPredicate("phone", criteria.getPhone(),criteria.getPhoneLike());
        addPredicate("password", criteria.getPassword(),criteria.getPasswordLike());
        addPredicateBool("passwordChanged", criteria.getPasswordChanged());
    }

    public UserSpecification(UserCriteria criteria) {
        super(criteria);
    }

    public UserSpecification(UserCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
