package com.msf.msfmng.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author shihujiang
 * @date 2019-07-18
 */
public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object obj1) {
        try {
            return objectMapper.writeValueAsString(obj1);
        } catch (JsonProcessingException e) {
            System.out.println("json转换异常");
        }
        return null;
    }

    public static Object parseObject(String jsonStr, Class<Object> targetClass) {
        try {
            return objectMapper.readValue(jsonStr, targetClass);
        } catch (IOException e) {
            System.out.println("json转换异常");
        }
        return null;
    }
}
