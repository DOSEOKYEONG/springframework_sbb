package com.ll.exam.sbb.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserCreateForm {
    @NotEmpty(message = "이름을 입력해주세요.")
    @Size(min = 2, max = 25)
    private String username;

    @NotEmpty(message = "비밀번호를 입력해주세요.")
    private String password1;

    @NotEmpty(message = "비밀번호 확인은 필수 항목입니다.")
    private String password2;

    @NotEmpty(message = "이메일을 입력해주세요.")
    @Email
    private String email;
}
