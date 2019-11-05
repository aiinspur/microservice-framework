package com.msf.msfmng.repository;

import com.eigpay.idf.entity.RoleAndResourceRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author shihujiang
 * @date 2019-07-19
 */
public interface RoleAndResourceRelRepository extends JpaRepository<RoleAndResourceRelationship, Long> {

    /**
     * delete relationship by role id.
     *
     * @param roleId role id.
     */
    void deleteByRoleId(Long roleId);


    /**
     * get relationship by role id.
     *
     * @param roleId role's id
     */
    List<RoleAndResourceRelationship> getByRoleId(Long roleId);
}
