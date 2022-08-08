package com.ll.exam.sbb.question.controller;

import com.ll.exam.sbb.question.Question;
import com.ll.exam.sbb.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class QuestionController {

    private final QuestionService questionService;


    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    public List<Question> findAllQuestion() {
        List<Question> questionList = questionService.findAll();

        return questionList;
    }


    public Optional<Question> findById(int id) {
        return questionService.findById(id);
    }

    public Question findBySubject(String subject) {
        return questionService.findBySubject(subject);
    }

    public Question findBySubjectAndContent(String subject, String content) {
        return questionService.findBySubjectAndContent(subject, content);
    }

    public List<Question> findBySubjectLike(String subjectLike) {
        return questionService.findBySubjectLike(subjectLike);
    }
}
