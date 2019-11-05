package com.msf.msfmng.controller.sys;

import com.msf.msfmng.controller.sys.vo.MenuVoTest;
import com.msf.msfmng.entity.SysResource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author shihujiang
 * @date 2019-07-10
 */
public class T {


    /**
     * 根据parent id获取孩子结点并根据sort排序
     * @param parentId parent id.
     * @return  child nodes.
     */
    private static List<SysResource> childNode(Long parentId) {
        List<SysResource> firstLevelNodes = new ArrayList<>();
        for (SysResource o : MenuVoTest.mockList()) {
            if (o.getParentId().equals(parentId)) {
                firstLevelNodes.add(o);
            }
        }

        firstLevelNodes.sort(Comparator.comparing(SysResource::getMenuSort));
        //System.out.println("排序后:");
        //firstLevelNodes.forEach(sysResource -> System.out.println(sysResource.getId()));

        return firstLevelNodes;
    }


    private static void depthFirstSearch(SysResource node) {

        for (SysResource n : childNode(node.getId())) {
            System.out.println(n);
            depthFirstSearch(n);
        }


    }


    public static void main(String[] args) {

//        SysResource rootNode = new SysResource();
//        rootNode.setId(0L);
//
//        depthFirstSearch(rootNode);

        System.out.println(new Date());

    }
}
