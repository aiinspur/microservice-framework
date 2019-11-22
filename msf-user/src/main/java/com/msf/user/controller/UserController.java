package com.msf.user.controller;

import com.msf.user.service.MdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author shihujiang
 * @date 2019-11-12
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    MdService mdService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/current")
    public Principal getUser(Principal principal) {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>");
        logger.info(principal.toString());
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>");


        return principal;
    }


    @RequestMapping("/o")
    public String h(){

        return mdService.hello();
    }



}
