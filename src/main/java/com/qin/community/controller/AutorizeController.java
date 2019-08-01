package com.qin.community.controller;

import com.qin.community.Provider.GitHubProvider;
import com.qin.community.dto.AccessTokenDto;
import com.qin.community.dto.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: community
 * @description: 登录控制层
 * @author: qin
 * @create: 2019-07-31 23:46
 **/
@Controller
public class AutorizeController {
    @Autowired
    private GitHubProvider gitHubProvider;
    @GetMapping("/callback")
    public String callBack(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state){
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDto.setState(state);
        accessTokenDto.setClient_id("c9c31928909a04da5245");
        accessTokenDto.setClient_secret("920868c9285b27338845bf3ba4faba14c9e7bc45");
        String accessToken = gitHubProvider.getAccessToken(accessTokenDto);
        GithubUser user = gitHubProvider.getUser(accessToken);
        System.out.println( user.getName());
        return "index";
    }
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
