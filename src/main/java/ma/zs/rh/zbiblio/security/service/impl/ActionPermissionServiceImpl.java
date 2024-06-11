package ma.zs.rh.zbiblio.security.service.impl;


import ma.zs.rh.zbiblio.security.bean.ActionPermission;
import ma.zs.rh.zbiblio.security.dao.criteria.core.ActionPermissionCriteria;
import ma.zs.rh.zbiblio.security.dao.facade.core.ActionPermissionDao;
import ma.zs.rh.zbiblio.security.dao.specification.core.ActionPermissionSpecification;
import ma.zs.rh.zbiblio.security.service.facade.ActionPermissionService;
import ma.zs.rh.zbiblio.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionPermissionServiceImpl extends AbstractServiceImpl<ActionPermission, ActionPermissionCriteria, ActionPermissionDao> implements ActionPermissionService {





    public ActionPermission findByReferenceEntity(ActionPermission t){
        return  dao.findByReference(t.getReference());
    }


    public List<ActionPermission> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(ActionPermission.class, ActionPermissionSpecification.class);
    }



    public ActionPermissionServiceImpl(ActionPermissionDao dao) {
        super(dao);
    }

}
