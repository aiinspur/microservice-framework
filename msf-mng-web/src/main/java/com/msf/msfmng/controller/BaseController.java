package com.msf.msfmng.controller;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author shihujiang
 * @date 2019-07-05
 */
public class BaseController<T, E> {


    protected E beanCopy(T form, E entity) {
        BeanCopier copier = BeanCopier.create(form.getClass(), entity.getClass(), false);
        copier.copy(form, entity, null);
        return entity;

    }

    /**
     * Used to indicate to {@code AbstractSecurityInterceptor} whether it should present
     * the authentication token to the <code>AuthenticationManager</code>.
     *
     * @return true if the token has been authenticated and the
     * <code>AbstractSecurityInterceptor</code> does not need to present the token to the
     * <code>AuthenticationManager</code> again for re-authentication.
     */
    protected boolean isAuthenticated() {
        return SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
    }
}
