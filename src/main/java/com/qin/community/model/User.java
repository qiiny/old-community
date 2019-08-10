package com.qin.community.model;

import lombok.Data;

/**
 * @program: community
 * @description: 用户模型
 * @author: qin
 * @create: 2019-08-02 16:27
 **/
@Data
public class User {
    private Integer id;
    private String accountId;
    private String name;
    private String token;
    private long gmtCreate;
    private long gmtModified;
    private String avatar_url;

}
