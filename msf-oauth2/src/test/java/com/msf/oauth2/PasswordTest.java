package com.msf.oauth2;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;

/**
 * @author shihujiang
 * @date 2019-11-11
 */
public class PasswordTest {


    @Test
    public void genPwd(){
        String pwd = "{bcrypt}" + new BCryptPasswordEncoder().encode("123456");
        System.out.println(pwd);
    }
}
