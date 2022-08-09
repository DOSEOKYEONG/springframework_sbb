package com.ll.exam.sbb.question.controller;

import com.ll.exam.sbb.question.Question;
import com.ll.exam.sbb.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
