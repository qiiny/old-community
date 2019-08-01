package com.qin.community.controller;

import com.qin.community.Provider.GitHubProvider;
import com.qin.community.dto.AccessTokenDto;
import com.qin.community.dto.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

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

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callBack(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state, HttpServletRequest request){
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        System.out.println(redirectUri+"\t"+clientSecret+"\t"+clientId);
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri(redirectUri);
        accessTokenDto.setState(state);
        accessTokenDto.setClient_id(clientId);
        accessTokenDto.setClient_secret(clientSecret);
        String accessToken = gitHubProvider.getAccessToken(accessTokenDto);
        GithubUser user = gitHubProvider.getUser(accessToken);
        if (user!=null){
            request.getSession().setAttribute("user",user);
            return "redirect:/";
        }else {
            return "redirect:/";
        }
    }
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
