package com.inflearn.prac_01.repository;

import java.util.*;

import com.inflearn.prac_01.domain.User;

public class MemoryUserRepository implements UserRepository {

    private static Map<Long, User> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public User save(User user) {
        user.setId( ++sequence);
        store.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<User> findByLoginID(String userID) {
        return Optional.ofNullable(store.get(userID));
    }

    @Override
    public Optional<User> findByLoginPW(String userPW) {
        return Optional.ofNullable(store.get(userPW));
    }

    @Override
    public Optional<User> findByName(String name) {
        return store.values().stream()
                .filter((member -> member.getName().equals(name)))
                .findAny();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(store.get(email));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
