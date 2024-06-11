package ma.zs.rh.zbiblio.security.service.impl;


import ma.zs.rh.zbiblio.security.bean.Role;
import ma.zs.rh.zbiblio.security.dao.criteria.core.RoleCriteria;
import ma.zs.rh.zbiblio.security.dao.facade.core.RoleDao;
import ma.zs.rh.zbiblio.security.dao.specification.core.RoleSpecification;
import ma.zs.rh.zbiblio.security.service.facade.RoleService;
import ma.zs.rh.zbiblio.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends AbstractServiceImpl<Role, RoleCriteria, RoleDao> implements RoleService {


    @Override
    public Role findByAuthority(String authority) {
        return dao.findByAuthority(authority);
    }

    @Override
    public int deleteByAuthority(String authority) {
        return deleteByAuthority(authority);
    }



    public Role findByReferenceEntity(Role t){
        return  dao.findByAuthority(t.getAuthority());
    }


    public List<Role> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Role.class, RoleSpecification.class);
    }



    public RoleServiceImpl(RoleDao dao) {
        super(dao);
    }

}
