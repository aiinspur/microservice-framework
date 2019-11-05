package com.msf.msfmng.repository;

import com.msf.msfmng.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shihujiang
 * @date 2019-06-17
 */
public interface UserRepository extends JpaRepository<SysUser,Long> {

    /**
     * find SysUser by username.
     * @param username user name.
     * @return  SysUser Object.
     */
    SysUser findByUsername(String username);
}
