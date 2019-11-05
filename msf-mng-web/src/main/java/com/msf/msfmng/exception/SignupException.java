package com.msf.msfmng.exception;

/**
 * @author shihujiang
 * @date 2019-06-27
 */
public class SignupException extends Exception{

    /**
     * Constructs a <code>SignupException</code> with the specified message.
     *
     * @param msg the detail message.
     */
    public SignupException(String msg){
        super(msg);
    }



    /**
     * Constructs a {@code UsernameNotFoundException} with the specified message and root
     * cause.
     *
     * @param msg the detail message.
     * @param t root cause
     */
    public SignupException(String msg,Throwable t){
        super(msg,t);
    }
}
