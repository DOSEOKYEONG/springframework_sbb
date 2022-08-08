package com.ll.exam.sbb.answer.controller;

import com.ll.exam.sbb.answer.Answer;
import com.ll.exam.sbb.answer.service.AnswerService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AnswerController {
    AnswerService answerService;

    public List<Answer> findAllAnswer() {
        List<Answer> answerList = answerService.findAll();

        return answerList;
    }
}
