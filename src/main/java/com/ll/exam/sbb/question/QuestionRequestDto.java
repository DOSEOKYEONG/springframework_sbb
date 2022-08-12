package com.ll.exam.sbb.question;

import com.ll.exam.sbb.question.Question;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class QuestionRequestDto {

    private String subject;
    private String content;
    private LocalDateTime createDate;

    @Builder
    public QuestionRequestDto(String subject, String content, LocalDateTime createDate) {
        this.subject = subject;
        this.content = content;
        this.createDate = createDate;
    }

//    public Question toEntity() {
//        return Question.builder()
//                .
//    }
}
