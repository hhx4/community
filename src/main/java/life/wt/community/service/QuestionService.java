package life.wt.community.service;

/**
 * @created by wt at 2021-04-28 18:47
 **/

import life.wt.community.dto.PaginationDTO;
import life.wt.community.dto.QuestionDTO;
import life.wt.community.mapper.QuestionMaper;
import life.wt.community.mapper.UserMapper;
import life.wt.community.model.Question;
import life.wt.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionMaper questionMaper;

    @Autowired
    private UserMapper userMapper;

    public PaginationDTO list(Integer page, Integer size) {
        Integer offset = size * (page - 1);
        List<Question> questions = questionMaper.list(offset,size);
        List<QuestionDTO> questionDTOS = new ArrayList<>();

        PaginationDTO paginationDTO = new PaginationDTO();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOS);
        Integer totalCount = questionMaper.count();
        paginationDTO.setPagination(totalCount,page,size);
        return paginationDTO;
    }
}