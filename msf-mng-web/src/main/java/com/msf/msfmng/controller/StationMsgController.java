package com.msf.msfmng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 站内消息
 * @author shihujiang
 * @date 2019-11-13
 */
@Controller
@RequestMapping("/station-msg")
public class StationMsgController extends BaseController{

    private static final String LIST_VIEW_NAME = "sys/station-msg/list.html";

    @GetMapping
    public String list() {
        return LIST_VIEW_NAME;
    }

}
