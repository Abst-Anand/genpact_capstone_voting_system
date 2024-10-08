package com.votingSystem.repository;

import com.votingSystem.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    Optional<Candidate> findById(int id);

    Candidate save(Candidate candidate);

    List<Candidate> findAll();

    @Modifying
    @Query("UPDATE Candidate c SET  c.voteCount = c.voteCount + 1 WHERE c.candidateId= :cId")
    int incrementVote(@Param("cId") int candidateId);


}
