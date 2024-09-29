package com.votingSystem.service;

import com.votingSystem.entity.User;
import com.votingSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findUserById(int userId) {
        return userRepository.findByUserId(userId);
    }

    public List<User> findSubAdmins() {
        return userRepository.findUserByRoleEquals(2);
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean signUp(User user) {

        Optional<User> existingUser = findUserByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            return false;
        }

        User newUser = userRepository.save(user);

        return true;

    }





}
