package com.msf.msfmng.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * 机构Entity
 *
 * @author shihujiang
 * @date 2019-07-30
 */
@Data
@Entity
@Table(name = "idf_sys_institution")
@EntityListeners(AuditingEntityListener.class)
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pid;

    private String name;

    private String fullName;

    private String principal;

    private String officePhone;

    private String address;

    private String zipCode;

    private String remarks;

    private Integer sort;

    @CreatedDate
    private Date gmtCreate;

    @LastModifiedDate
    private Date gmtModified;

    @Override
    public String toString() {
        return "Institution{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", principal='" + principal + '\'' +
                ", officePhone='" + officePhone + '\'' +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", remarks='" + remarks + '\'' +
                ", sort=" + sort +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
