package com.inflearn.prac_01;

import com.inflearn.prac_01.repository.MemberRepository;
import com.inflearn.prac_01.repository.MemoryMemberRepository;
import com.inflearn.prac_01.service.MemberService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
