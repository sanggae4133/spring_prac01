package com.inflearn.prac_01.service;

import com.inflearn.prac_01.domain.User;
import com.inflearn.prac_01.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //  회원 가입
    public Long Signup(User user) {
        //중복 회원x
        validateDuplicateUser(user);

        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateUser(User user) {
        userRepository.findByName(user.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
        userRepository.findByLoginID(user.getLoginID())
                .ifPresent(m -> {
                    throw new IllegalStateException("아이디가 중복 되었습니다.");
                });
    }

    public Long Login(String userID, String userPW) {
        if (
                userRepository.findByLoginID(userID).isPresent() &&
                        userRepository.findByLoginPW(userPW).isPresent()) {
            return 200L;
        }
        else return 300L;
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findOne(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findLoginID(String loginID) {
        return userRepository.findByLoginID(loginID);
    }

    public Optional<User> findLoginPW(String loginPW) {
        return userRepository.findByLoginPW(loginPW);
    }

}
