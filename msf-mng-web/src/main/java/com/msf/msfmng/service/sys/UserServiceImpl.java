package com.msf.msfmng.service.sys;

import com.msf.msfmng.controller.login.SignupForm;
import com.msf.msfmng.entity.SysUser;
import com.msf.msfmng.exception.PasswordsMatchException;
import com.msf.msfmng.exception.SignupException;
import com.msf.msfmng.exception.UsernameExistsException;
import com.msf.msfmng.repository.UserRepository;
import com.msf.msfmng.service.base.BaseServiceImpl;
import com.msf.msfmng.utils.PasswordUtil;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shihujiang
 * @date 2019-06-13
 */
@Service
public class UserServiceImpl
        extends BaseServiceImpl<UserRepository, SysUser> implements UserService {

//    private UserRepository userRepository;


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
//        this.userRepository = userRepository;
    }

    @Override
    public void signUp(SignupForm signupForm) throws SignupException {

        // 1.Compare password and rePassword
        if (!matchPassword(signupForm.getPassword(), signupForm.getRePassword())) {
            throw new PasswordsMatchException("password not match.");
        }

        // 2.Check username
        if (isUsernameExits(signupForm.getEmail())) {
            throw new UsernameExistsException("username already exits.");
        }

        SysUser user = new SysUser(signupForm.getEmail(), PasswordUtil.genDefaultPassword(signupForm.getPassword()));
        repository.save(user);
    }


    /**
     * Is username exits.
     *
     * @param username username
     * @return return true if username exits.
     */
    private boolean isUsernameExits(String username) {
        return repository.findByUsername(username) != null;
    }

    /**
     * match password
     *
     * @param password   password
     * @param rePassword re password
     * @return match or not.
     */
    private boolean matchPassword(String password, String rePassword) {

        if ("".equals(password) || "".equals(rePassword)) {
            return false;
        }

        return password.equals(rePassword);

    }
}
