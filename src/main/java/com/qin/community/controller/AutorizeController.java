package com.qin.community.controller;

import com.qin.community.Provider.GitHubProvider;
import com.qin.community.dto.AccessTokenDto;
import com.qin.community.dto.GithubUser;
import com.qin.community.mapper.UserMapper;
import com.qin.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

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

    @Autowired
    private UserMapper userMapper;

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
        GithubUser githubUser = gitHubProvider.getUser(accessToken);
        if (githubUser!=null){
            User user = new User();
            user.setToken(UUID.randomUUID().toString());
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
            request.getSession().setAttribute("user",githubUser);
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
