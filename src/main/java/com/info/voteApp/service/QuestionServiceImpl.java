package com.info.voteApp.service;

import com.info.voteApp.model.Questions;
import com.info.voteApp.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionsService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    QuestionsRepository questionsRepository;


    @Override
    public List<Questions> getQuestionsList() {
        List<Questions> questionsList =new ArrayList<>();
        Iterable<Questions> questions = questionsRepository.findAll();

        for (Questions q : questions){
            questionsList.add(q);
        }
        return questionsList;
    }

    @Override
    public Questions getQuestionByIsMain(int v) {
        return null;
    }

    @Override
    public void save(Questions questions) {

    }
}
