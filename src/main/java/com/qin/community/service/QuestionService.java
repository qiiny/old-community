package com.qin.community.service;

import com.qin.community.dto.QuestionDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

/** 
* @Description:
* @Param:  
* @return:  
* @Author: Qin
* @Date: 2019/8/9 
*/

public interface QuestionService {
    /**
     * question与user表整合
     * @return List<Question>
     */
    List<QuestionDTO> list();
}
