package com.msf.oauth2.conf;

import com.msf.oauth2.service.SysUserDetailsServiceImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @author shihujiang
 * @date 2019-06-12
 */
@Component
public class SysAuthenticationProvider extends DaoAuthenticationProvider {

    public SysAuthenticationProvider(SysUserDetailsServiceImpl userDetailsService) {
        super();
        setUserDetailsService(userDetailsService);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // do nothing.
        // use default DaoAuthenticationProvider.
        return super.authenticate(authentication);
    }

}