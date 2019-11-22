package com.msf.msfmng.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
/**
 *
 * @author shihujiang
 * @date 2019-11-16
 */
@FeignClient(value = "md-center",fallback = MdServiceFallBackImpl.class)
public interface MdService {

    /**
     * hello test
     * @return  data of master data service hello api.
     */
    @GetMapping("/api/hello")
    String hello();
}
