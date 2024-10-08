package com.votingSystem.service;

import com.votingSystem.entity.Candidate;
import com.votingSystem.repository.CandidateRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public Candidate findCandidateById(int id) {
        return candidateRepository.findById(id).orElseThrow(()-> new RuntimeException("Could not find candidate with id: " + id));
    }

    public List<Candidate> findAllCandidates() {
        return candidateRepository.findAll();
    }

    public Candidate saveCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public Candidate updateCandidateVoteCount(int id, int voteCount) {
        Candidate candidate = findCandidateById(id);
        candidate.setVoteCount(voteCount);
        return candidateRepository.save(candidate);
    }

    public Candidate updateCandidateCandidature(int id, boolean status) {
        Candidate candidate = findCandidateById(id);
        candidate.setCandidatureRevoked(status);
        return candidateRepository.save(candidate);
    }

    @Transactional
    public int incrementVoteCount(int candidateId) {
        return candidateRepository.incrementVote(candidateId);
    }

}
