package com.qin.community.dto;

import com.qin.community.model.User;
import lombok.Data;

/**
 * @program: community
 * @description: 获取发布数据的DTO层
 * @author: qin
 * @create: 2019-08-09 17:39
 **/
@Data
public class QuestionDTO {
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
    private User user;
}
