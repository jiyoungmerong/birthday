package com.mom.birthday.domain.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class UserDto {
    @NotNull(message = "아이디는 필수 입력 값입니다.")
    private String userId; // 아이디

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String password; // 비밀번호

    @NotNull(message = "이름은 필수 입력 값입니다.")
    private String name; // 이름

    @NotBlank
    @Pattern(regexp = "^[가-힣a-zA-Z]{2,10}$", message = "닉네임 형식에 맞지 않습니다.")
    private String nickname; // 닉네임

    @Builder
    public UserDto(String userId, String password, String name, String nickname){
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
    }
}
