package com.info.voteApp.service;

import com.info.voteApp.model.Questions;

import java.util.List;

public interface QuestionsService {

    List<Questions> getQuestionsList();

    Questions getQuestionByIsMain(int val);

    void save(Questions questions);
}
