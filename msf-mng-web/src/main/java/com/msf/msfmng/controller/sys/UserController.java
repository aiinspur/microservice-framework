package com.msf.msfmng.controller.sys;


import com.msf.msfmng.controller.BaseController;
import com.msf.msfmng.entity.Institution;
import com.msf.msfmng.entity.SysUser;
import com.msf.msfmng.service.sys.InstitutionService;
import com.msf.msfmng.service.sys.UserService;
import com.msf.msfmng.utils.PasswordUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.validation.Valid;
import java.util.List;


/**
 * @author shihujiang
 * @date 2019-06-12
 */
@Controller
public class UserController extends BaseController {

    private static final String ADD_VIEW_NAME = "sys/user/add.html";
    private static final String UPDATE_VIEW_NAME = "sys/user/update.html";
    private static final String LIST_VIEW_NAME = "sys/user/list.html";

    private UserService userService;

    private InstitutionService institutionService;


    @GetMapping("sys/users")
    public String list(SysUser userQuery, Model model) {
        // 获取用户列表
        model.addAttribute("list", userService.list(userQuery));
        // 获取全部组织机构
        List<Institution> institutions = institutionService.list(new Institution());
        model.addAttribute("institutions",institutions);
        return LIST_VIEW_NAME;
    }

    /**
     * 局部更新用户列表
     * @return html
     */
    @GetMapping("sys/users/partial-refresh")
    public String userList(Model model){
        SysUser query = new SysUser();
        query.setInstitutionId("7");
        model.addAttribute("list",userService.list(query));
        return LIST_VIEW_NAME+"::user-list";
    }


    @GetMapping("sys/user")
    public String add(Model model) {
        model.addAttribute("obj", new SysUser());
        return ADD_VIEW_NAME;

    }

    @GetMapping("sys/user/{userId}")
    public String get(Model model, @PathVariable Long userId) {
        model.addAttribute("obj", userService.get(userId));
        return UPDATE_VIEW_NAME;

    }

    @PutMapping("sys/user")
    public String update(@Valid SysUser form, Errors errors) {
        if (errors.hasErrors()) {
            return UPDATE_VIEW_NAME;
        }
        userService.saveOrUpt(form);
        return "redirect:/sys/users";
    }

    @PostMapping("sys/user")
    public String save(@Valid SysUser form, Errors errors) {
        if (errors.hasErrors()) {
            return ADD_VIEW_NAME;
        }

        form.setPassword(PasswordUtil.genDefaultPassword("helloword"));

        userService.saveOrUpt(form);

        return "redirect:/sys/users";
    }


    public UserController(UserService userService, InstitutionService institutionService) {
        this.userService = userService;
        this.institutionService = institutionService;

    }
}
