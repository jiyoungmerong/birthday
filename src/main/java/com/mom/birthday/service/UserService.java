package com.mom.birthday.service;

import com.mom.birthday.domain.User;
import com.mom.birthday.domain.dto.TokenDTO;
import com.mom.birthday.jwt.TokenProvider;
import com.mom.birthday.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class UserService {



    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;

//    @Transactional
//    public SignupResponse create(SignupRequest request){
//        User user = User.builder()
//                .userId(request.getUserId())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .nickname(request.getNickname())
//                .name(request.getName())
//                .build();
//
//        userRepository.save(user);
//
//        return SignupResponse.of(request.getUserId(), request.getNickname(), request.getName());
//    }

    public void signup(User user) {
        user.setUserId(user.getUserId());
        user.setName(user.getName());
        user.setNickname(user.getNickname());
        user.setPassword(user.getPassword());

        userRepository.save(user);
    }

    public TokenDTO login(String userId, String password) {
        // 1. ID/PW 를 기반으로 Authentication 객체 생성
        // authentication 객체는 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userId, password);

        //2. 실제 검증(사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 매서드가 실행될 때 JwtUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
//        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증된 정보를 기반으로 JWT 토큰 생성
        TokenDTO tokenDTO = tokenProvider.generageToken(authenticationToken);

        // 4. 로그인 성공하면 토큰DTO에 제대로 들어감
        return tokenDTO;
    }

}
