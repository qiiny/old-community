package com.qin.community.mapper;

import com.qin.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;


/**
 * @program: community
 * @description: 用户表映射
 * @author: qin
 * @create: 2019-08-02 16:20
 **/
@Mapper
@Service
public interface UserMapper {
    /**
     * 登陆成功往数据库写入数据
     * @param user
     */
    @Insert("INSERT INTO \"PUBLIC\".\"USER\" (\"ACCOUNT_ID\", \"NAME\", \"TOKEN\", \"GMT_CREATE\", \"GMT_MODIFIED\") VALUES (#{accountId}, #{name}, #{token}, #{gmtCreate}, #{gmtModified})")
   void insert (User user);

    /**
     * 查找数据库是否有token
     * @param token
     * @return User
     */
    @Select("select * from user where token=#{token}")
    User findToken(@Param("token") String token);
}
