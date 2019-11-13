package com.msf.oauth2.service;


import com.msf.oauth2.entity.SysUser;

/**
 * @author shihujiang
 * @date 2019-06-13
 */
public interface UserService {

    /**
     * get user by username.
     *
     * @param username username
     * @return user object.
     */
    SysUser getUserByUsername(String username);

}
