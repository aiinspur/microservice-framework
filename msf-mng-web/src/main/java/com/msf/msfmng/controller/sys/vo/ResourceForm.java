package com.msf.msfmng.controller.sys.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 资源模型
 * @author shihujiang
 * @date 2019-07-10
 */
@Data
public class ResourceForm {
    private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";

    private Long id;

    @NotBlank(message = NOT_BLANK_MESSAGE)
    private String name;

    /**
     * 1 menu
     * 0 permission
     */
    @NotBlank(message = NOT_BLANK_MESSAGE)
    private String type;

    private Long parentId;

    private String permission;

    private String menuHref;

    private Integer menuSort;

    private String menuIcon;

    /**
     * 1 display
     * 0 hide
     */
    @NotBlank(message = NOT_BLANK_MESSAGE)
    private String show;

    private String remarks;


}
