package ma.zs.rh.zbiblio.security.service.facade;

import ma.zs.rh.zbiblio.security.bean.Role;
import ma.zs.rh.zbiblio.security.dao.criteria.core.RoleCriteria;
import ma.zs.rh.zbiblio.service.IService;



public interface RoleService extends  IService<Role,RoleCriteria>  {
    Role findByAuthority(String authority);
    int deleteByAuthority(String authority);


    



}
