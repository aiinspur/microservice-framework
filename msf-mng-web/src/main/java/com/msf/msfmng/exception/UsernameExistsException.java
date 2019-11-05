package com.msf.msfmng.exception;

/**
 * @author shihujiang
 * @date 2019-06-27
 */
public class UsernameExistsException extends SignupException {

    /**
     * Constructs a <code>UsernameExistsException</code> with the specified message.
     *
     * @param msg the detail message.
     */
    public UsernameExistsException(String msg) {
        super(msg);
    }

    /**
     * Constructs a {@code UsernameExistsException} with the specified message and root
     * cause.
     *
     * @param msg the detail message.
     * @param t   root cause
     */
    public UsernameExistsException(String msg, Throwable t) {
        super(msg, t);
    }
}
