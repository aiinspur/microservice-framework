package com.msf.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("md-center")
public interface MdService {

    @GetMapping("/api/hello")
    public String hello();
}
