package com.info.voteApp.repository;

import com.info.voteApp.model.Questions;
import org.springframework.data.repository.CrudRepository;

public interface QuestionsRepository extends CrudRepository<Questions, Long> {
}
