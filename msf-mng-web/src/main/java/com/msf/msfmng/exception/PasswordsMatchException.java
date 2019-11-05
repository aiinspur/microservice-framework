package com.msf.msfmng.exception;

/**
 * @author shihujiang
 * @date 2019-06-27
 */
public class PasswordsMatchException extends SignupException {
    /**
     * Constructs a <code>PasswordsMatchException</code> with the specified message.
     *
     * @param msg the detail message.
     */
    public PasswordsMatchException(String msg) {
        super(msg);
    }

    /**
     * Constructs a {@code PasswordsMatchException} with the specified message and root
     * cause.
     *
     * @param msg the detail message.
     * @param t   root cause
     */
    public PasswordsMatchException(String msg, Throwable t) {
        super(msg, t);
    }
}
