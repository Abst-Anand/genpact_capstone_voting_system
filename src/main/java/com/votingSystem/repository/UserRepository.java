package com.votingSystem.repository;

import com.votingSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserId(int userId);

    Optional<User> findByEmail(String email);

    User save(User user);

    List<User> findUserByRoleEquals(int role);
    
    List<User> findUserByRoleEqualsAndIsApprovedIsFalse(int role); // 1usage new
    
    




}
