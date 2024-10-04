package com.votingSystem.service;

import com.votingSystem.entity.Election;
import com.votingSystem.repository.ElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectionService {

    private final ElectionRepository electionRepository;

    public ElectionService(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    public List<Election> getAllElections() {
        return electionRepository.findAll();
    }

    public Election insertElection(Election election) {
        return electionRepository.save(election);
    }

    public Election findElectionById(int id) {
        return electionRepository.findById(id);
    }
}
