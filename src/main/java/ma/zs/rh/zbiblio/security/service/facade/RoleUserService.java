package ma.zs.rh.zbiblio.security.service.facade;

import ma.zs.rh.zbiblio.security.bean.RoleUser;
import ma.zs.rh.zbiblio.security.dao.criteria.core.RoleUserCriteria;
import ma.zs.rh.zbiblio.service.IService;

import java.util.List;



public interface RoleUserService extends  IService<RoleUser,RoleUserCriteria>  {

    List<RoleUser> findByRoleId(Long id);
    int deleteByRoleId(Long id);
    long countByRoleAuthority(String authority);
    List<RoleUser> findByUserId(Long id);
    int deleteByUserId(Long id);
    long countByUserEmail(String email);



}
