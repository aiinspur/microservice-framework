package com.msf.msfmng.controller.sys.vo;

import com.msf.msfmng.entity.SysResource;
import com.msf.msfmng.utils.MenuUtil;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * menu tree model.
 * <p>
 * only support three level.
 *
 * @author shihujiang
 * @date 2019-07-11
 */
@Data
public class MenuVo {

    /**
     * top level
     */
    private SysResource first;

    /**
     * child menu.only support two level.
     */
    private List<Map<SysResource, List<SysResource>>> children;


    public List<MenuVo> conversionMenuVo(List<SysResource> resources) {

        List<MenuVo> menus = new ArrayList<>();

        // top level
        List<SysResource> topMenus = MenuUtil.childNode(resources, 0L);
        for (SysResource res : topMenus) {
            MenuVo vo = new MenuVo();
            vo.setFirst(res);
            children = new ArrayList<>();

            // second level
            List<SysResource> secondLevel = MenuUtil.childNode(resources, res.getId());

            for (SysResource res2 : secondLevel) {
                Map<SysResource, List<SysResource>> map2 = new HashMap<>();
                map2.put(res2,MenuUtil.childNode(resources,res2.getId()));
                children.add(map2);
            }

            vo.setChildren(children);
            menus.add(vo);

        }


        return menus;

    }


    @Override
    public String toString() {
        return "MenuVo{" +
                "first=" + first +
                ", children=" + children +
                '}';
    }
}
