package com.msf.msfmng.service.sys;


import com.msf.msfmng.entity.RoleAndResourceRelationship;
import com.msf.msfmng.entity.SysRole;
import com.msf.msfmng.service.base.BaseService;

import java.util.List;

/**
 * @author shihujiang
 * @date 2019-07-18
 */
public interface RoleService extends BaseService<SysRole> {


    /**
     * save relationship of role and resource.
     *
     * @param roleId      role id.
     * @param resourceIds user's resource ids.
     */
    void saveRoleAndResourceRelationship(Long roleId, List<Long> resourceIds);

    /**
     * delete relationship of role and resources.
     *
     * @param roleId role id.
     */
    void deleteRoleAndResourceRelationship(Long roleId);

    /**
     * get resources by role id.
     *
     * @param roleId role id.
     * @return resources.
     */
    List<RoleAndResourceRelationship> getResourcesByRole(Long roleId);


    /**
     * grant permission to role.
     *
     * @param roleId      role id
     * @param resourceIds resource ids.
     */
    void grantPermission(Long roleId, List<Long> resourceIds);
}
