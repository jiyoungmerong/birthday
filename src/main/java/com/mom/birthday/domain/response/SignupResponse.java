package com.mom.birthday.domain.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SignupResponse {
    private String id;
    private String name;
    private String nickname;

    public static SignupResponse of(String id, String name, String nickname){
        return new SignupResponse(id, name, nickname);
    }
}
