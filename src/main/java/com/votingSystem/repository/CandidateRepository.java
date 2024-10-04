package com.votingSystem.repository;

import com.votingSystem.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    Optional<Candidate> findById(int id);

    Candidate save(Candidate candidate);

    List<Candidate> findAll();


}
