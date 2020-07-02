package com.zephon.shopping.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.manager.controller
 * @date 2020/7/1 下午9:40
 * @Copyright ©
 */
@RequestMapping("/login")
@Controller
public class LoginController {

    @RequestMapping("/info")
    @ResponseBody
    public Map<String,String> getUsername() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Map<String,String> map = new HashMap<>();
        map.put("loginName", username);
        map.put("loginTime",new Date().toString());
        return map;
    }
    @GetMapping("")
    public String login(){
        return "/shoplogin.html";
    }

}
