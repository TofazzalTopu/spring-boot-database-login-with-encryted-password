package com.info.app.service;

import com.info.app.model.Questions;

import java.util.List;

public interface QuestionsService {

    List<Questions> getQuestionsList();

    Questions getQuestionByIsMain(int val);

    void save(Questions questions);
}
