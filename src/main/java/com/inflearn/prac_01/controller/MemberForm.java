package com.inflearn.prac_01.controller;

import com.inflearn.prac_01.domain.Member;
import org.springframework.web.bind.annotation.PostMapping;

public class MemberForm {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
