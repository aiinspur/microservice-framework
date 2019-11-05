package com.msf.msfmng.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author shihujiang
 * @date 2019-06-14
 */
@Data
@Entity
@Table(name = "idf_sys_resource")
@EntityListeners(AuditingEntityListener.class)
public class SysResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    @Column(name = "pid")
    private Long parentId;

    private String permission;

    private String menuHref;

    private Integer menuSort;

    private String menuIcon;

    @Column(name = "is_show")
    private String show;

    private String remarks;

    @CreatedDate
    private Date gmtCreate;

    @LastModifiedDate
    private Date gmtModified;

    @Override
    public String toString() {
        return "SysResource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", parentId=" + parentId +
                ", permission='" + permission + '\'' +
                ", menuHref='" + menuHref + '\'' +
                ", menuSort=" + menuSort +
                ", menuIcon='" + menuIcon + '\'' +
                ", show='" + show + '\'' +
                ", remarks='" + remarks + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
