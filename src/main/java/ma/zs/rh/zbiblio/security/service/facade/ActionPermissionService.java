package ma.zs.rh.zbiblio.security.service.facade;

import ma.zs.rh.zbiblio.security.bean.ActionPermission;
import ma.zs.rh.zbiblio.security.dao.criteria.core.ActionPermissionCriteria;
import ma.zs.rh.zbiblio.service.IService;
import java.util.List;


public interface ActionPermissionService extends  IService<ActionPermission,ActionPermissionCriteria>  {

    List<ActionPermission> findAllOptimized();

}
