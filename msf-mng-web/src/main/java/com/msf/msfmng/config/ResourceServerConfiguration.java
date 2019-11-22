//package com.msf.msfmng.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//
///**
// * @author shihujiang
// * @date 2019-11-12
// */
//@Configuration
//@EnableResourceServer
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
//
//
////    @Override
////    public void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests()
////                .antMatchers("/user/**", "/zuul/**")
////                .authenticated()
////                .antMatchers(permitUrls())
////                .permitAll()
////                ;
////    }
//
//
//    /**
//     * 允许的urls列表
//     *
//     * @return urls
//     */
//    private String[] permitUrls() {
//        return new String[]{
//                "/user/product/**",
//                "/idf/s/**",
//                "/idf/",
//                "/idf",
//                "/idf/logout",
//                "/idf/signin.html",
//                "/idf/signup.html"
//        };
//    }
//}
