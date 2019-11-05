package com.msf.msfmng.repository;

import com.msf.msfmng.entity.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {


    private UserRepository userRepository;

    @Test
    public void sysUserCrudTest() {

        String password = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("hello");

        // saveOrUpt test
        SysUser sysUser = new SysUser("hello", password);
        SysUser user = userRepository.save(sysUser);

        assertNotNull(user.getId());

        // retrieve test
        SysUser userEntity = null;
        Optional<SysUser> result = userRepository.findById(user.getId());
        if (result.isPresent()) {
            userEntity = result.get();
        }
        assertNotNull(userEntity);
        assertEquals("hello", userEntity.getUsername());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // update test
        userEntity.setNickname("aiinspur");
        userEntity = userRepository.save(userEntity);
        assertEquals("aiinspur", userEntity.getNickname());

        assertTrue(userEntity.getGmtModified().getTime() > userEntity.getGmtCreate().getTime());

        // delete test
        assertTrue(userRepository.findById(userEntity.getId()).isPresent());
        userRepository.delete(userEntity);
        assertFalse(userRepository.findById(userEntity.getId()).isPresent());

    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}