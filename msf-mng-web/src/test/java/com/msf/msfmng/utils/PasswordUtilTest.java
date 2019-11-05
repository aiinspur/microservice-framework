package com.msf.msfmng.utils;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

public class PasswordUtilTest {

    @Test
    public void genDefaultPassword() {
        Assert.assertTrue(PasswordEncoderFactories.createDelegatingPasswordEncoder()
                .matches("1","{bcrypt}$2a$10$n3dG0Rk6Hgn3WDWIld0uRuCU5.eNuPhuW.4yL8eDlhjr3BxYOvcUm"));
    }
}