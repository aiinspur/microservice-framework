package com.msf.msfmng.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * @author shihujiang
 * @date 2019-08-01
 */
@Data
@Entity
@Table(name = "idf_sys_dict_data")
@EntityListeners(AuditingEntityListener.class)
public class DictData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;

    private String value;

    private String code;

    private String sort;

}
