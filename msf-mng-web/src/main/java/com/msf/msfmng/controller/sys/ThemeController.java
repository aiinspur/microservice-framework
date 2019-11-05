package com.msf.msfmng.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 主题设置
 *
 * @author shihujiang
 * @date 2019-07-19
 */
@Controller
public class ThemeController {

    @GetMapping("sys/themes")
    public String list(){
        return "sys/theme/list.html";
    }

}
