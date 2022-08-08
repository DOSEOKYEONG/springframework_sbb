package com.ll.exam.sbb.answer.repository;

import com.ll.exam.sbb.answer.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
