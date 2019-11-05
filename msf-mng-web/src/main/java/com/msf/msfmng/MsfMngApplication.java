package com.msf.msfmng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 *
 * @author shihujiang
 * @date 2019-11-05
 */
@SpringBootApplication
@EnableCaching
@EnableJpaAuditing
public class MsfMngApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsfMngApplication.class, args);
    }

}
