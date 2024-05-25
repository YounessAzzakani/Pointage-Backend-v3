package ma.zs.rh.zynerator.security.service.facade;

import ma.zs.rh.zynerator.security.bean.Role;
import ma.zs.rh.zynerator.security.dao.criteria.core.RoleCriteria;
import ma.zs.rh.zynerator.service.IService;



public interface RoleService extends  IService<Role,RoleCriteria>  {
    Role findByAuthority(String authority);
    int deleteByAuthority(String authority);


    



}
