package com.votingSystem.repository;

import com.votingSystem.entity.Election;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectionRepository extends JpaRepository<Election, Integer> {

    Election save(Election election);
    Election findById(int id);

    List<Election> findAll();
}
