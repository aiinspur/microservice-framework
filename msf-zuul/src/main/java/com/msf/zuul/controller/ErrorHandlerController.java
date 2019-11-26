package com.msf.zuul.controller;

import com.msf.zuul.common.Result;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author shihujiang
 * @date 2019-11-25
 */

@Controller
public class ErrorHandlerController implements ErrorController {

    @RequestMapping("/error")
    @ResponseBody
    public ResponseEntity<Result> error(HttpServletRequest request) {
        Result result = new Result();
        result.setStatusCode((Integer) request.getAttribute("javax.servlet.error.status_code"));
        result.setMsg(request.getAttribute("javax.servlet.error.exception") + "");
        result.setResult(new HashMap<>(0));

        return new ResponseEntity(result, HttpStatus.BAD_GATEWAY);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
