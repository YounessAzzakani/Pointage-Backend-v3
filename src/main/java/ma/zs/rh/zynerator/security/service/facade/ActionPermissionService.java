package ma.zs.rh.zynerator.security.service.facade;

import ma.zs.rh.zynerator.security.bean.ActionPermission;
import ma.zs.rh.zynerator.security.dao.criteria.core.ActionPermissionCriteria;
import ma.zs.rh.zynerator.service.IService;
import java.util.List;


public interface ActionPermissionService extends  IService<ActionPermission,ActionPermissionCriteria>  {

    List<ActionPermission> findAllOptimized();

}
