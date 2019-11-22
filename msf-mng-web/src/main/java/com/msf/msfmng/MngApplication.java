package com.msf.msfmng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 *
 * @author shihujiang
 * @date 2019-11-05
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableCaching
@EnableJpaAuditing
@EnableFeignClients
public class MngApplication {

    public static void main(String[] args) {
        SpringApplication.run(MngApplication.class, args);
    }

}
