package com.msf.msfmng.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author shihujiang
 * @date 2019-08-01
 */
@Data
@Entity
@Table(name = "idf_sys_dict")
@EntityListeners(AuditingEntityListener.class)
public class Dict {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    private String remarks;

    @CreatedDate
    private Date gmtCreate;

    @LastModifiedDate
    private Date gmtModified;


}
