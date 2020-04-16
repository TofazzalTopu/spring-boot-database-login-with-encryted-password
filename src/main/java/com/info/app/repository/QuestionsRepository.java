package com.info.app.repository;

import com.info.app.model.Questions;
import org.springframework.data.repository.CrudRepository;

public interface QuestionsRepository extends CrudRepository<Questions, Long> {
}
