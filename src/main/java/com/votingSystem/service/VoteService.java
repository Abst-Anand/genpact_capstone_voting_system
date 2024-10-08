package com.votingSystem.service;

import com.votingSystem.entity.Vote;
import com.votingSystem.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VoteService implements VoteRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int saveVote(Vote vote) {

        String sql;

        return 0;
    }

    @Override
    public Vote getVotingDetails(int voteId) {
        return null;
    }
}
