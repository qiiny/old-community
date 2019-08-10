package com.qin.community.mapper;

import com.qin.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

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
            "\"GMT_CREATE\", \"GMT_MODIFIED\", \"CREATOR\",  \"TAG\") VALUES (#{title}, #{description},#{gmt_create}," +
            "#{gmt_Modified}, #{creator}, #{tag})")
    void create(Question question);

    /**
     * 查询数据库
     * @return List<Question>
     */
    @Select("select * from question")
    List<Question> list();
}
