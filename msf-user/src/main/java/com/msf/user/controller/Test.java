package com.msf.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shihujiang
 * @date 2019-11-15
 */
@Controller
@RequestMapping("/h")
public class Test {

    @RequestMapping("/uu")
    public String h(){

        return "hello";

    }
}
