package com.msf.msfmng.utils;


import com.msf.msfmng.entity.SysResource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author shihujiang
 * @date 2019-07-11
 */
public class MenuUtil {


    /**
     * 根据parent id获取孩子结点并根据sort排序
     *
     * @param parentId parent id.
     * @return child nodes.
     */
    public static List<SysResource> allChildNode(List<SysResource> nodes, Long parentId) {
        List<SysResource> firstLevelNodes = new ArrayList<>();
        for (SysResource o : nodes) {
            if (o.getParentId().equals(parentId)) {
                firstLevelNodes.add(o);
            }
        }

        firstLevelNodes.sort(Comparator.comparing(SysResource::getMenuSort));

        return firstLevelNodes;
    }


    /**
     * 根据parent id获取孩子结点并根据sort排序.去除非菜单资源
     *
     * @param parentId parent id.
     * @return child nodes.
     */
    public static List<SysResource> childNode(List<SysResource> nodes, Long parentId) {
        List<SysResource> list = allChildNode(nodes, parentId);

        for (SysResource o : nodes) {
            if (!"1".equals(o.getType())) {
                list.remove(o);
            }
        }

        return list;
    }
}
