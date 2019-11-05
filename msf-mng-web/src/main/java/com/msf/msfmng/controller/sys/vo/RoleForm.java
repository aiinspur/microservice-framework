package com.msf.msfmng.controller.sys.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author shihujiang
 * @date 2019-07-18
 */
@Data
public class RoleForm {

    private Long id;

    @NotBlank
    private String name;

    private Integer sort;

    private String remarks;
}
