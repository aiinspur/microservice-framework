package com.msf.msfmng.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author shihujiang
 * @date 2019-06-14
 */
@Data
@Entity
@Table(name = "idf_sys_role")
@EntityListeners(AuditingEntityListener.class)
public class SysRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer sort;

    @Column(name = "is_sys")
    private Integer buildInSystem;

    private String remarks;

    private Date gmtCreate;

    private Date gmtModified;

}
