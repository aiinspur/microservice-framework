package com.msf.msfmng.utils;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;

/**
 * @author shihujiang
 * @date 2019-06-28
 */
public class PasswordUtil {

    /**
     * Generate an encrypted password.
     * @param unencryptedPassword unencrypted password.
     * @return  encrypted password.
     */
    public static String genDefaultPassword(String unencryptedPassword) {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(unencryptedPassword);
    }
}
