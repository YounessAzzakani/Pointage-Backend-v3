package ma.zs.rh.zbiblio.security.service.facade;

import ma.zs.rh.zbiblio.security.bean.ModelPermission;
import ma.zs.rh.zbiblio.security.dao.criteria.core.ModelPermissionCriteria;
import ma.zs.rh.zbiblio.service.IService;
import java.util.List;



public interface ModelPermissionService extends  IService<ModelPermission,ModelPermissionCriteria>  {
    List<ModelPermission> findAllOptimized();

}
