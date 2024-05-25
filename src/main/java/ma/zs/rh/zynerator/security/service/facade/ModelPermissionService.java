package ma.zs.rh.zynerator.security.service.facade;

import ma.zs.rh.zynerator.security.bean.ModelPermission;
import ma.zs.rh.zynerator.security.dao.criteria.core.ModelPermissionCriteria;
import ma.zs.rh.zynerator.service.IService;
import java.util.List;



public interface ModelPermissionService extends  IService<ModelPermission,ModelPermissionCriteria>  {
    List<ModelPermission> findAllOptimized();

}
