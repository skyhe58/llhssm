package com.soecode.lyf.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/interceptor")
public class testInterceptorController {

    @RequestMapping("/add")
    public String add(){
        System.out.println("InterceptorController.add()");
        return "success";
    }

    @RequestMapping("/remove")
    public void remove(){
        System.out.println("InterceptorController.remove()");
    }

    @RequestMapping("/modify")
    public void modify(){
        System.out.println("InterceptorController.modify()");
    }

    @RequestMapping("/find")
    public void find(){
        System.out.println("InterceptorController.find()");
    }

}
