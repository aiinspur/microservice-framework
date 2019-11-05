package com.msf.msfmng.repository;

import com.msf.msfmng.entity.SysResource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shihujiang
 * @date 2019-07-10
 */
public interface ResourceRepository extends JpaRepository<SysResource, Long> {

//    List<SysResource> getBy

}
