package com.qin.community.controller;

import com.qin.community.mapper.QuestionMapper;
import com.qin.community.mapper.UserMapper;
import com.qin.community.model.Question;
import com.qin.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: community
 * @description: 添加
 * @author: qin
 * @create: 2019-08-03 17:35
 **/
@Controller
public class PublishController {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }
    @PostMapping("/publish")
    public String doPublish(@RequestParam("title") String title, @RequestParam("description") String description,
            @RequestParam("tag") String tag, HttpServletRequest request, Model model){
        model.addAttribute("title",title);
        model.addAttribute("tag",tag);
        model.addAttribute("description",description);
        if ("".equals(title.trim())){
            model.addAttribute("error","请输入标题");
            return "publish";
        }
        if ("".equals(description.trim())){
            model.addAttribute("error","请输入内容");
            return "publish";
        }
        if ("".equals(tag.trim())){
            model.addAttribute("error","请输入标签");
            return "publish";
        }
        Cookie[] cookies = request.getCookies();
        User user = null;
        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName())){
                String token = cookie.getValue();
                user = userMapper.findToken(token);
                if (user!=null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        if (user==null){
            model.addAttribute("error","用户未登录");
            return "publish";
        }
        Question question=new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmt_create(System.currentTimeMillis());
        question.setGmt_Modified(question.getGmt_create());
        questionMapper.create(question);
        return "redirect:/";
    }
}
