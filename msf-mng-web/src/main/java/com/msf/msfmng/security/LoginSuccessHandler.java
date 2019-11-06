package com.msf.msfmng.security;

import com.msf.msfmng.constant.SysConstant;
import com.msf.msfmng.controller.sys.vo.MenuVo;
import com.msf.msfmng.entity.SysUser;
import com.msf.msfmng.service.sys.ResourceService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author shihujiang
 * @date 2019-07-11
 */
@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private ResourceService resourceService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        System.out.println("login success. loading allResources." + resourceService);
        SysUser user = (SysUser) authentication.getPrincipal();
        //1.直接存储前端可以解析的树形结构
        user.setMenus(new MenuVo().conversionMenuVo(resourceService.resources(user.getId())));


        //2.更新用户权限信息
        Set<GrantedAuthority> authorities = new HashSet<>();
        // Admin has full access.
        if (user.getUsername().equals(SysConstant.ADMIN)) {
            authorities.add(new SimpleGrantedAuthority("*:*"));
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            // 获取当前用户的权限信息.权限标识符规则[资源标识符:操作:对象实例ID]
            List<String> permissions = resourceService.getPermissions(user.getId());
            for (String permission : permissions) {
                authorities.add(new SimpleGrantedAuthority(permission));
            }
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }

        user.setAuthorities(authorities);

        updateAuthentication(authentication, user);

        super.onAuthenticationSuccess(request, response, authentication);

    }

    public LoginSuccessHandler(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    private void updateAuthentication(Authentication authentication, Object principal) {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        Authentication newAuthentication = new UsernamePasswordAuthenticationToken(principal, token.getCredentials(), token.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(newAuthentication);
    }
}
