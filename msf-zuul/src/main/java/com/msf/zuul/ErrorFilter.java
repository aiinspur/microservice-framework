//package com.msf.zuul;
//
//import com.msf.zuul.common.Result;
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.netflix.zuul.exception.ZuulException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @author shihujiang
// * @date 2019-11-25
// */
//public class ErrorFilter extends ZuulFilter {
//
//    Logger log = LoggerFactory.getLogger(ErrorFilter.class);
//
//
//    @Override
//    public String filterType() {
//        return "error";
//    }
//
//    /**
//     * filterOrder() must also be defined for a filter. Filters may have the same  filterOrder if precedence is not
//     * important for a filter. filterOrders do not need to be sequential.
//     *
//     * @return the int order of a filter
//     */
//    @Override
//    public int filterOrder() {
//        return 0;
//    }
//
//    /**
//     * a "true" return from this method means that the run() method should be invoked
//     *
//     * @return true if the run() method should be invoked. false will not invoke the run() method
//     */
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
//    /**
//     * if shouldFilter() is true, this method will be invoked. this method is the core method of a ZuulFilter
//     *
//     * @return Some arbitrary artifact may be returned. Current implementation ignores it.
//     * @throws ZuulException if an error occurs during execution.
//     */
//    @Override
//    public Object run() throws ZuulException {
//        RequestContext ctx = RequestContext.getCurrentContext();
////        Throwable throwable = ctx.getThrowable();
////        log.error("this is a ErrorFilter : {}", throwable.getCause().getMessage());
////        ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
////        ctx.set("error.exception", throwable.getCause());
//
//
//        HttpServletRequest request = ctx.getRequest();
//
//        Result result = new Result();
//        result.setStatusCode((Integer) request.getAttribute("javax.servlet.error.status_code"));
//        result.setMsg(request.getAttribute("javax.servlet.error.exception") + "");
//
//        return new ResponseEntity(result, HttpStatus.BAD_GATEWAY);
//    }
//}
