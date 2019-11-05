package com.msf.msfmng.controller.sys.vo;

import com.msf.msfmng.entity.SysResource;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MenuVoTest {

    @Test
    public void conversionMenuVo() {

        MenuVo mv = new MenuVo();

        List<MenuVo> list = mv.conversionMenuVo(mockList());

        list.forEach(vo -> System.out.println(vo));

    }


    /**
     * mock resource list.
     */
    public static List<SysResource> mockList() {
        List<SysResource> nodes = new ArrayList<>();

        SysResource s1 = new SysResource();
        s1.setId(1L);
        s1.setParentId(0L);
        s1.setMenuSort(8);
        nodes.add(s1);

        SysResource s1_1 = new SysResource();
        s1_1.setId(2444L);
        s1_1.setParentId(0L);
        s1_1.setMenuSort(5);
        nodes.add(s1_1);

        SysResource s2 = new SysResource();
        s2.setId(2L);
        s2.setParentId(1L);
        s2.setMenuSort(5);
        nodes.add(s2);


        SysResource s3 = new SysResource();
        s3.setId(3L);
        s3.setParentId(1L);
        s3.setMenuSort(20);
        nodes.add(s3);

        SysResource s5 = new SysResource();
        s5.setId(500L);
        s5.setParentId(3L);
        s5.setMenuSort(2);
        nodes.add(s5);

        SysResource s4 = new SysResource();
        s4.setId(400L);
        s4.setParentId(3L);
        s4.setMenuSort(1);
        nodes.add(s4);

        return nodes;
    }
}