package com.qin.community.dto;

import lombok.Data;

/**
 * @program: community
 * @description: 获取登录用户的信息
 * @author: qin
 * @create: 2019-08-01 15:11
 **/
@Data
public class GithubUser {
    private String name;
    private long id;
    private String bio;
    private String avatar_url;

}
