package com.msf.msfmng.security;

import com.eigpay.idf.constant.SysConstant;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author shihujiang
 * @date 2019-06-14
 */
@Component
public class SysPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {

        if (authentication instanceof AnonymousAuthenticationToken) {
            return false;
        }

        if (authentication.getPrincipal().equals(SysConstant.ADMIN)) {
            return true;
        }

        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission + "");
        if (authentication.getAuthorities().contains(grantedAuthority)) {
            return true;
        }

        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
