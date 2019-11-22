# Micro Service Framework

- Eureka Cluster
- Spring Oauth2 Service
    除管理端外采用网关统一token鉴权的方式；
    管理端自行鉴权
    每个服务可以自己配置资源访问权限，默认全部允许。
- Master Data 
- User Service
- Mng-web Service
- Zuul Service


Feign服务间调用

## 服务降级
> 使用feign + hystrix实现服务降级
```
1. 配置Feign和Hystrix集成 feign.hystrix.enabled=true
2. 编写降级后的服务处理类
```





## 参考资料
Spring Cloud 微服务中搭建 OAuth2.0 认证授权服务：
https://www.cnblogs.com/Irving/p/9343377.html


https://www.jianshu.com/p/d3901772c95a spring cloud oauth2 搭建认证中心（授权服务器）

http://www.leftso.com/blog/136.html
https://blog.csdn.net/w1054993544/article/details/78932614
https://www.cnblogs.com/Irving/p/9343377.html
https://blog.csdn.net/qq_34490951/article/details/79930270
http://www.ruanyifeng.com/blog/2019/04/oauth-grant-types.html
https://blog.csdn.net/qq_33517844/article/details/98482089
https://blog.csdn.net/lyong1223/article/details/84261089



资源服务器 vs 授权服务器 
https://www.cnblogs.com/meibaorui/p/9182660.html


微服务的用户认证与授权杂谈
https://blog.51cto.com/zero01/2435946

OAuth 2.0定义了四种授权方式
https://blog.csdn.net/lixiang987654321/article/details/83381494



cas：
https://www.cnblogs.com/jiang-000/p/11222932.html