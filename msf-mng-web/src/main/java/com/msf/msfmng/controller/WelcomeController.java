package com.msf.msfmng.controller;

import com.msf.msfmng.service.MdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

/**
 *
 * @author shihujiang
 * @date 2019-06-12
 */
@Controller
public class WelcomeController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${application.message:Hello World}")
    private String message = "Hello World";


    MdService mdService;

    public WelcomeController(MdService mdService) {
        this.mdService = mdService;
    }


    @ResponseBody
    @GetMapping("/getPrinciple")
    public OAuth2Authentication getPrinciple(OAuth2Authentication oAuth2Authentication, Principal principal, Authentication authentication) {
        logger.info(oAuth2Authentication.getUserAuthentication().getAuthorities().toString());
        logger.info(oAuth2Authentication.toString());
        logger.info("principal.toString() " + principal.toString());
        logger.info("principal.getName() " + principal.getName());
        logger.info("authentication: " + authentication.getAuthorities().toString());

        return oAuth2Authentication;
    }

    @GetMapping("/t")
    @ResponseBody
    public String hello(HttpServletRequest request){
        String a = request.getHeaderNames().toString();

        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()){
            logger.debug(headers.nextElement());
        }
        return mdService.hello();
    }

    @GetMapping("/h")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", this.message);
        return "welcome";
    }

    @RequestMapping("/foo")
    public String foo(Map<String, Object> model) {
        throw new RuntimeException("Foo");
    }
}
