package com.msf.oauth2.service;

import com.msf.oauth2.entity.SysUser;
import com.msf.oauth2.repository.UserRepository;
import com.msf.oauth2.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shihujiang
 * @date 2019-06-13
 */
@Service
public class UserServiceImpl
        extends BaseServiceImpl<UserRepository, SysUser> implements UserService {


    @Override
    public List<SysUser> list(SysUser query) {
        SysUser user = new SysUser();

        return super.list(query);
    }

    @Override
    public SysUser getUserByUsername(String username) {
        return repository.findByUsername(username);
    }


    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
    }



}
