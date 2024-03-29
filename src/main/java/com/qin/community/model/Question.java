package com.qin.community.model;

import lombok.Data;

/**
 * @program: community
 * @description: 发布问题
 * @author: qin
 * @create: 2019-08-04 15:09
 **/
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private Long gmt_create;
    private Long gmt_Modified;
    private Integer creator;
    private Integer comment_count;
    private Integer view_count;
    private Integer like_count;
    private String tag;
}
