package com.msf.msfmng.service.sys;

import com.msf.msfmng.entity.SysResource;
import com.msf.msfmng.repository.ResourceRepository;
import com.msf.msfmng.service.base.BaseServiceImpl;
import com.msf.msfmng.utils.MenuUtil;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shihujiang
 * @date 2019-07-10
 */
@Service
public class ResourceServiceImpl
        extends BaseServiceImpl<ResourceRepository, SysResource> implements ResourceService {

    private static List<SysResource> rearrangeList = new ArrayList<>();

    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        super(resourceRepository);
    }


    @Override
    public List<SysResource> resources(Long userId) {
        //TODO 需要关联角色查询资源
        return repository.findAll();
    }

    @Cacheable(value = "sysUserCache", key = "#userId")
    @Override
    public List<SysResource> getResources(Long userId) {


        return null;
    }


    @Override
    public List<String> getPermissions(Long userId) {
        List<String> permissions = new ArrayList<>();

        List<SysResource> resources = getResources(userId);
        for (SysResource sysResource : resources) {
            permissions.add(sysResource.getPermission());
        }

        return permissions;
    }


    @Override
    public List<SysResource> allResources() {
        List<SysResource> resourceList = repository.findAll();

        // 重排菜单以符合页面展示需要,需要实现深度优先遍历
        SysResource rootNode = new SysResource();
        rootNode.setId(0L);
        rearrangeList.clear();
        return depthFirstSearch(resourceList, rootNode);
    }

    private List<SysResource> depthFirstSearch(List<SysResource> nodes, SysResource node) {

        for (SysResource n : MenuUtil.allChildNode(nodes, node.getId())) {
            rearrangeList.add(n);
            depthFirstSearch(nodes, n);
        }

        return rearrangeList;
    }


}
