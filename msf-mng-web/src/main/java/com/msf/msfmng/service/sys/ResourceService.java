package com.msf.msfmng.service.sys;


import com.msf.msfmng.entity.SysResource;
import com.msf.msfmng.service.base.BaseService;

import java.util.List;

/**
 * @author shihujiang
 * @date 2019-07-10
 */
public interface ResourceService extends BaseService<SysResource> {

    /**
     * get user allResources.
     *
     * @param userId user id.
     * @return allResources.
     */
    List<SysResource> getResources(Long userId);


    /**
     * 查询特定用户的资源
     *
     * @param userId user id.
     * @return resources.
     */
    List<SysResource> resources(Long userId);

    /**
     * 资源列表.根据前端模版展示需要重排的资源列表.
     *
     * @return menu list.
     */
    List<SysResource> allResources();


    /**
     * get user permissions.
     *
     * @param userId user id.
     * @return permissions.
     */
    List<String> getPermissions(Long userId);

}
