package com.qin.community.service.Impl;

import com.qin.community.dto.QuestionDTO;
import com.qin.community.mapper.QuestionMapper;
import com.qin.community.mapper.UserMapper;
import com.qin.community.model.Question;
import com.qin.community.model.User;
import com.qin.community.service.QuestionService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: community
 * @description: 实现层
 * @author: qin
 * @create: 2019-08-09 18:39
 **/
@Mapper
@Service
public class QusetionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<QuestionDTO> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDTO>questionDTOList=new ArrayList<>();
        for (Question question:questions) {
            User user=userMapper.findById(question.getCreator());
            QuestionDTO questionDTO=new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
