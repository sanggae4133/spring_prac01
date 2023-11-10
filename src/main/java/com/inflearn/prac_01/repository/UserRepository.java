package com.inflearn.prac_01.repository;

import com.inflearn.prac_01.domain.User;
import org.springframework.stereotype.Repository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete



import java.util.List;
import java.util.Optional;



public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long id);

    Optional<User> findByLoginID(String userID);

    Optional<User> findByLoginPW(String userPW);

    Optional<User> findByName(String name);

    Optional<User> findByEmail(String email);

    List<User> findAll();
}
