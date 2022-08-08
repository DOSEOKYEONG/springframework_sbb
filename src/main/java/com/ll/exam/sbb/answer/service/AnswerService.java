package com.ll.exam.sbb.answer.service;

import com.ll.exam.sbb.answer.Answer;
import com.ll.exam.sbb.answer.repository.AnswerRepository;

import java.util.List;

public class AnswerService {
    AnswerRepository answerRepository;
    public List<Answer> findAll() {
        return answerRepository.findAll();
    }
}
