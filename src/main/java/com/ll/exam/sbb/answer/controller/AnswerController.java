package com.ll.exam.sbb.answer.controller;

import com.ll.exam.sbb.answer.Answer;
import com.ll.exam.sbb.answer.service.AnswerService;
import com.ll.exam.sbb.question.Question;
import com.ll.exam.sbb.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/answer")
@Controller
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;
    private final QuestionService questionService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam("content") String content) {
        Question question = questionService.getQuestion(id);
        answerService.create(question, content);

        return """
                redirect:/question/detail/%s
                """.formatted(id);
    }


}
