package com.ll.exam.sbb.question.controller;

import com.ll.exam.sbb.question.Question;
import com.ll.exam.sbb.question.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping("/question/list")
    public String list(Model model) {
        List<Question> questionList = questionService.findAll();
        model.addAttribute("questionList", questionList);

        return "question_list";
    }

    @RequestMapping(value = "/question/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Optional<Question> neededQuestion = questionService.findById(id);
        Question question = neededQuestion.get();
        model.addAttribute("question", question);
        return "question_detail";
    }
}
