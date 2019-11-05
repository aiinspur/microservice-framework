package com.msf.msfmng.controller.sys.vo;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 机构Form
 *
 * @author shihujiang
 * @date 2019-07-30
 */
@Data
public class InstitutionForm {

    private Long id;

    private Long pid;

    private String name;

    private String fullName;

    private String principal;

    private String officePhone;

    private String address;

    private String zipCode;

    private String remarks;

}
