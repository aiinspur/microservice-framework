package com.msf.zuul.common;

import lombok.Data;

/**
 * @author shihujiang
 * @date 2019-11-25
 */
@Data
public class Result<T> {

    private int statusCode;

    private String msg;

    private T result;
}
