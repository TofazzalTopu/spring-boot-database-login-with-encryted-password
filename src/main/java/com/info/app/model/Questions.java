package com.info.app.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "questions")
public class Questions {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="question_no", length = 3)
    @Size(min = 1, max = 3)
    private int questionNo;

    @Column(name="description", length = 500)
    @Size(min = 1, max = 500)
    private String description;

    @Column(name="is_main_question")
    private boolean isMainQuestion;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isMainQuestion() {
        return isMainQuestion;
    }

    public void setMainQuestion(boolean mainQuestion) {
        isMainQuestion = mainQuestion;
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }
}
