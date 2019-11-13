package com.msf.oauth2.service;

import com.msf.oauth2.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shihujiang
 * @date 2019-06-13
 */
@Component
public class SysUserDetailsServiceImpl implements UserDetailsService {

    private UserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (null == username || "".equals(username)) {
            throw new UsernameNotFoundException("username is empty or null.");
        }

        SysUser sysUser = sysUserService.getUserByUsername(username);

        Set<GrantedAuthority> authorities = new HashSet<>();


        return new SysUser(sysUser.getUsername(), sysUser.getPassword(), authorities);
    }


    @Autowired
    public void setUserService(UserService sysUserService) {
        this.sysUserService = sysUserService;
    }
}
