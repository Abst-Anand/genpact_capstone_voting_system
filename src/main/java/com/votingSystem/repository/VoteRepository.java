package com.votingSystem.repository;


import com.votingSystem.entity.Vote;

public interface VoteRepository {

    int saveVote(Vote vote);

    Vote getVotingDetails(int voteId);


}
