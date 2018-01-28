package com.soecode.lyf.interceptor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class InterceptorLogin implements HandlerInterceptor {

    private static RestTemplate restTemplate = new RestTemplate();

//    @Value("${cas.redirect.url}")
//    private String casUrl;
//
//    @Value("${cas.redirect.service}")
//    private String appService;

    private String casLoginUrl = "http://cas.example.com:8080/cas/login";
    private String appService = "http%3a%2f%2flocalhost%3a8083%2flogin";


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
       String user = (String) httpServletRequest.getSession().getAttribute("username");
       if(null == user){
           String ticket = httpServletRequest.getParameter("ticket");
           if(null!=ticket){
               String casValidate = "http://cas.example.com/serviceValidate";
               String casVaildateUrl = casValidate+"?service="+httpServletRequest.getRequestURL()+"&ticket="+ticket;
               httpServletResponse.sendRedirect(casVaildateUrl);
               return false;
           }

//          Map<String, Object> uriVariables = new HashMap<String, Object>();
//           uriVariables.put("service", appService);
//           String result = restTemplate.getForObject(url, String.class,uriVariables);


           String url = casLoginUrl +"?service="+ httpServletRequest.getRequestURL();
           String result = restTemplate.getForObject(url, String.class);
           httpServletResponse.sendRedirect(url);
//           httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/user/showLogin");
           return false;
       }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
