package com.msf.msfmng.service.sys;


import com.msf.msfmng.controller.login.SignupForm;
import com.msf.msfmng.entity.SysUser;
import com.msf.msfmng.exception.SignupException;
import com.msf.msfmng.service.base.BaseService;

import java.util.List;

/**
 * @author shihujiang
 * @date 2019-06-13
 */
public interface UserService extends BaseService<SysUser> {






    /**
     * get user by username.
     *
     * @param username username
     * @return user object.
     */
    SysUser getUserByUsername(String username);


    /**
     * User sign up.
     *
     * @param signupForm sign up object
     * @return user object.
     * @throws SignupException  se.
     */
    void signUp(SignupForm signupForm) throws SignupException;

}
