package com.msf.msfmng.security;

import com.eigpay.idf.constant.SysConstant;
import com.eigpay.idf.entity.SysUser;
import com.eigpay.idf.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
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
        if (Objects.isNull(sysUser)) {
            throw new UsernameNotFoundException("SysUser is null.");
        }

        Set<GrantedAuthority> authorities = new HashSet<>();

//        // Admin has full access.
//        if (username.equals(SysConstant.ADMIN)) {
//            authorities.add(new SimpleGrantedAuthority("*:*"));
//            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        } else {
//            // 获取当前用户的权限信息.权限标识符规则[资源标识符:操作:对象实例ID]
//            List<String> permissions = sysUserService.getPermissions(sysUser.getId());
//            for (String permission : permissions) {
//                authorities.add(new SimpleGrantedAuthority(permission));
//            }
//            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//        }

        return new SysUser(sysUser.getUsername(), sysUser.getPassword(), authorities);
    }


    @Autowired
    public void setUserService(UserService sysUserService) {
        this.sysUserService = sysUserService;
    }
}
