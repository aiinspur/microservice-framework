package com.msf.msfmng.controller.login;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author shihujiang
 * @date 2019-06-26
 */
@Data
public class SignupForm {

    private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";
    private static final String EMAIL_MESSAGE = "{email.message}";
    private static final String PASSWORD_RULE_MESSAGE = "{password.rule.message}";

    @NotBlank(message = NOT_BLANK_MESSAGE)
    @Email(message = EMAIL_MESSAGE)
    private String email;

    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,10}$",message = PASSWORD_RULE_MESSAGE)
    @NotBlank(message = NOT_BLANK_MESSAGE)
    private String password;

    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,10}$",message = PASSWORD_RULE_MESSAGE)
    @NotBlank(message = NOT_BLANK_MESSAGE)
    private String rePassword;
}
