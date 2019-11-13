package com.msf.md.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shihujiang
 * @date 2019-11-06
 */
@RestController
@RequestMapping()
public class MdApi {

    @GetMapping("/api/hello")
    public String hello(){
        return "It's md here.";
    }


    @GetMapping("/md/api/hello")
    public String hello2(){
        return "It's md here22.";
    }
}
