package com.msf.md;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @author shihujiang
 * @date 2019-11-06
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MdApplication {

    public static void main(String[] args) {
        SpringApplication.run(MdApplication.class, args);
    }

}
