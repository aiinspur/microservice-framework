package com.msf.msfmng.controller.login;

import com.msf.msfmng.controller.BaseController;
import com.msf.msfmng.exception.SignupException;
import com.msf.msfmng.service.sys.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


/**
 * @author shihujiang
 * @date 2019-06-24
 */
@RequestMapping
@Controller
public class LoginController extends BaseController {

    private static final String SIGNUP_VIEW_NAME = "login/signup";
    private static final String SIGNIN_VIEW_NAME = "login/signin";

    private UserService sysUserService;

    LoginController(UserService sysUserService) {
        this.sysUserService = sysUserService;
    }


    @GetMapping("signin.html")
    public String signin() {
        return SIGNIN_VIEW_NAME;
    }


    @GetMapping("signup.html")
    public String signup(Model model) {
        model.addAttribute(new SignupForm());
        return SIGNUP_VIEW_NAME;
    }


    @PostMapping("signup.html")
    public String signup(@Valid @ModelAttribute SignupForm signupForm, Errors errors,Model model) {
        if (errors.hasErrors()) {
            return SIGNUP_VIEW_NAME;
        }

        String msg;
        try {
            sysUserService.signUp(signupForm);
            return "redirect:/signin.html";
        } catch (SignupException e) {
            msg = e.getMessage();
            e.printStackTrace();
        }

        model.addAttribute("msg", msg);
        return SIGNUP_VIEW_NAME;
    }


}
