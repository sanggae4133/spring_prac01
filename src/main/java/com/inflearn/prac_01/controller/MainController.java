package com.inflearn.prac_01.controller;


import com.inflearn.prac_01.repository.UserEntity;
import com.inflearn.prac_01.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // 클래스 컨트롤러
@RequestMapping(path="/demo") // url/demo로 이동할 때
public class MainController{
    /*
    @GetMapping("/demo")
    public String home() {
        return "home";
    }

     */

    @Autowired // bean으로 userRepository랑 연결시켜줌
    private UserRepository userRepository;

    @PostMapping(path="/add") // Post요청만 받아준다
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        UserEntity n = new UserEntity();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<UserEntity> getAllUsers() {
        // Json or XML로 모든 user 뱉어내기
        return userRepository.findAll();
    }
}
