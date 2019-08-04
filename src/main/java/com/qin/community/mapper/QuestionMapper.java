package com.qin.community.mapper;

import com.qin.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
* @Description: 发布问题
* @Param:
* @return:
* @Author: Qin
* @Date: 2019/8/4
*/
@Mapper
@Component
public interface QuestionMapper {
    /**
     * 插入问题数据
     * @param question
     */
    @Insert("INSERT INTO \"PUBLIC\".\"QUESTION\" (\"TITLE\", \"DESCRIPTION\", " +
            "\"GMT_CREATE\", \"GMT_MODIFIED\", \"CREATOR\", \"COMMENT_COUNT\", \"VIEW_COUNT\", " +
            "\"LIKE_COUNT\", \"TAG\") VALUES (#{title}, #{description},#{gmtCreate}," +
            "#{gmtModified}, #{creator}, #{commentCount}, #{viewCount}, #{likeCount}, #{tag})")
    public void create(Question question);
}
