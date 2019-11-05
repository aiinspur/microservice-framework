package com.msf.msfmng.repository;

import com.eigpay.idf.entity.SysResource;
import com.eigpay.idf.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shihujiang
 * @date 2019-07-10
 */
public interface RoleRepository extends JpaRepository<SysRole, Long> {

}
