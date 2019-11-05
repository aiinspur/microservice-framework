package com.msf.msfmng.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author shihujiang
 * @date 2019-07-19
 */
@Data
@Entity
@Table(name = "idf_sys_role_res_rel")
@EntityListeners(AuditingEntityListener.class)
public class RoleAndResourceRelationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long roleId;

    private Long resourceId;

    @CreatedDate
    private Date gmtCreate;

    @LastModifiedDate
    private Date gmtModified;

}
