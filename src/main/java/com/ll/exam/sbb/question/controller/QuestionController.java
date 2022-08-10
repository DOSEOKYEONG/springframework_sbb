package com.ll.exam.sbb.question.controller;

import com.ll.exam.sbb.answer.Answer;
import com.ll.exam.sbb.answer.AnswerForm;
import com.ll.exam.sbb.question.Question;
import com.ll.exam.sbb.question.QuestionForm;
import com.ll.exam.sbb.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {
    private final QuestionService questionService;

    @RequestMapping("/list")
    public String list(Model model) {
        List<Question> questionList = questionService.findAll();
        model.addAttribute("questionList", questionList);

        return "question_list";
    }

    @RequestMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Optional<Question> neededQuestion = questionService.findById(id);
        Question question = neededQuestion.get();
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }

    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        int id = questionService.create(questionForm.getSubject(), questionForm.getContent());

        return """
                redirect:/question/detail/%d
                """.formatted(id);
    }
}
