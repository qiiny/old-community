package com.qin.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: community
 * @description: 登录控制层
 * @author: qin
 * @create: 2019-07-31 23:46
 **/
@Controller
public class AutorizeController {
    @GetMapping("/callback")
    public String callBack(){
        return "index";
    }
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
