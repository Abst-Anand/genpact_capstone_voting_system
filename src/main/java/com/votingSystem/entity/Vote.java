package com.votingSystem.entity;



public class Vote {

    private int voteId;

    private int voterId;
    private int electionId;
    private int candidateId;

    public Vote() {
    }

    public Vote(int voteId, int voterId, int electionId, int candidateId) {
        this.voteId = voteId;
        this.voterId = voterId;
        this.electionId = electionId;
        this.candidateId = candidateId;
    }

    public Vote(int voterId, int electionId, int candidateId) {
        this.voterId = voterId;
        this.electionId = electionId;
        this.candidateId = candidateId;
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public int getVoterId() {
        return voterId;
    }

    public void setVoterId(int voterId) {
        this.voterId = voterId;
    }

    public int getElectionId() {
        return electionId;
    }

    public void setElectionId(int electionId) {
        this.electionId = electionId;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }
}
