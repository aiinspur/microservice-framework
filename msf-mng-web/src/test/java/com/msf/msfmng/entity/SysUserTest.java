package com.msf.msfmng.entity;

import org.junit.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class SysUserTest {

    @Test
    public void toStringTest() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("user:*"));
        authorities.add(new SimpleGrantedAuthority("menu:*"));
        SysUser sysUser = new SysUser("hello", "word", authorities);

        SysRole role1 = new SysRole();
//        role1.setCode("role1");
        List<SysRole> roles = new ArrayList<>();
        roles.add(role1);
        sysUser.setRoles(roles);

        String expectSysUserStr = sysUser.toString();
        System.out.println(expectSysUserStr);
        assertTrue(expectSysUserStr.contains("username"));
        assertTrue(expectSysUserStr.contains("roles"));
    }

}