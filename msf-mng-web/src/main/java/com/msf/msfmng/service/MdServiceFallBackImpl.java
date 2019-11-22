package com.msf.msfmng.service;

import org.springframework.stereotype.Component;

/**
 * Master Data Service
 * @author shihujiang
 * @date 2019-11-15
 */
@Component
public class MdServiceFallBackImpl implements MdService {

    @Override
    public String hello() {
        return "I'm sorry. master data service（主数据服务） not available .";
    }
}
