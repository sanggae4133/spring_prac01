package com.inflearn.prac_01;

import com.inflearn.prac_01.domain.User;
import com.inflearn.prac_01.repository.MemoryUserRepository;
import com.inflearn.prac_01.repository.UserRepository;
import com.inflearn.prac_01.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    /*
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    */

    @Bean
    public UserService userService() {
        return new UserService(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new MemoryUserRepository();
    }
}
