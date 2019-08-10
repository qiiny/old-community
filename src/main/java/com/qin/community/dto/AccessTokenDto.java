package com.qin.community.dto;


import lombok.Data;

/**
 * @program: community
 * @description: 数据流对象
 * @author: qin
 * @create: 2019-08-01 12:32
 **/
@Data
public class AccessTokenDto {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
