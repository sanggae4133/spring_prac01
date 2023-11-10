package com.inflearn.prac_01.controller;


import com.inflearn.prac_01.domain.User;
import com.inflearn.prac_01.repository.UserRepository;

import com.inflearn.prac_01.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // 클래스 컨트롤러
// @RequestMapping(path="/demo") // url/demo로 이동할 때
public class MainController {

    /*
    @GetMapping("/demo")
    public String home() {
        return "home";
    }
     */


    /*
    로그인: post, baseurl/login
        ㄴstatus: 200-login 성공, 300-login 실패
    회원가입: post, basurl/signup
        ㄴststus: 200-signin 성공, 300-id 곂침 실패
     */

    @Autowired
    private final UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    /*
    @PostMapping(path="/login")
    public @ResponseBody String loginUser (@RequestParam String id, @RequestParam String passwd) {
        if (userRepository.existsById()userRepository == )
        userRepository.
    }

     */

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping(path="/add") // Post요청만 받아준다
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // Json or XML로 모든 user 뱉어내기
        return userRepository.findAll();
    }

    @GetMapping(path = "login")
    public String loginPage() {
        return "login";
    }

    @ResponseBody
    @PostMapping(path="/login")
    public Long userLogin(@RequestParam UserLoginForm userLoginForm) {
        UserLoginForm userLoginForm1 = new UserLoginForm();
        return userService.Login(userID, userPW);
    }

    @GetMapping("/signup")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/signup")
    public String create(UserSignupForm form) {
        User user = new User();
        user.setName(form.getName());

        userService.Signup(user);

        return "redirect:/";
    }

    @GetMapping("/Users")
    public String list(Model model) {
        List<User> members = userService.findUsers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
