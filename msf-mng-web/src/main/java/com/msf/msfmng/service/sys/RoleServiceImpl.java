package com.msf.msfmng.service.sys;

import com.msf.msfmng.entity.RoleAndResourceRelationship;
import com.msf.msfmng.entity.SysRole;
import com.msf.msfmng.repository.RoleAndResourceRelRepository;
import com.msf.msfmng.repository.RoleRepository;
import com.msf.msfmng.service.base.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shihujiang
 * @date 2019-07-18
 */
@Service
public class RoleServiceImpl
        extends BaseServiceImpl<RoleRepository, SysRole> implements RoleService {

    private static Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    private RoleAndResourceRelRepository roleAndResourceRelRepository;

    public RoleServiceImpl(RoleRepository roleRepository, RoleAndResourceRelRepository roleAndResourceRelRepository) {
        super(roleRepository);
        this.roleAndResourceRelRepository = roleAndResourceRelRepository;
    }

    @Override
    public List<RoleAndResourceRelationship> getResourcesByRole(Long roleId) {
        return roleAndResourceRelRepository.getByRoleId(roleId);
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void grantPermission(Long roleId, List<Long> resourceIds) {
        deleteRoleAndResourceRelationship(roleId);
        saveRoleAndResourceRelationship(roleId, resourceIds);
    }

    @Override
    public void deleteRoleAndResourceRelationship(Long roleId) {
        if (get(roleId) == null) {
            logger.debug("deleteRoleAndResourceRelationship role is null. roleId:{}", roleId);
        }

        roleAndResourceRelRepository.deleteByRoleId(roleId);
    }

    @Override
    public void saveRoleAndResourceRelationship(Long roleId, List<Long> resourceIds) {

        List<RoleAndResourceRelationship> list = new ArrayList<>(resourceIds.size());

        for (Long id : resourceIds) {
            RoleAndResourceRelationship relationship = new RoleAndResourceRelationship();
            relationship.setResourceId(id);
            relationship.setRoleId(roleId);
            list.add(relationship);
        }
        roleAndResourceRelRepository.saveAll(list);

    }
}
