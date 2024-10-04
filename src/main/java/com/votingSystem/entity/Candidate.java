package com.votingSystem.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int candidateId;

    @Column(length = 30)
    private String candidateName;

    @Column(length = 60)
    private String candidateDescription;

    @Column(length = 14)
    private String aadharNumber;

    private int profilePicId;

    @Column(length = 45)
    private String partyName;

    private int partyLogoId;
    private int voteCount;
    private boolean isCandidatureRevoked;
    private int created_by;

    @CreatedDate
    private LocalDateTime created_on;


    public Candidate(int candidateId, String candidateName, String candidateDescription, String aadharNumber, int profilePicId, String partyName, int partyLogoId, int voteCount, boolean isCandidatureRevoked, int created_by) {
        this.candidateId = candidateId;
        this.candidateName = candidateName;
        this.candidateDescription = candidateDescription;
        this.aadharNumber = aadharNumber;
        this.profilePicId = profilePicId;
        this.partyName = partyName;
        this.partyLogoId = partyLogoId;
        this.voteCount = voteCount;
        this.isCandidatureRevoked = isCandidatureRevoked;
        this.created_by = created_by;
    }

    public Candidate(String candidateName, String candidateDescription, String aadharNumber, int profilePicId, String partyName, int partyLogoId, int voteCount, boolean isCandidatureRevoked, int created_by) {
        this.candidateName = candidateName;
        this.candidateDescription = candidateDescription;
        this.aadharNumber = aadharNumber;
        this.profilePicId = profilePicId;
        this.partyName = partyName;
        this.partyLogoId = partyLogoId;
        this.voteCount = voteCount;
        this.isCandidatureRevoked = isCandidatureRevoked;
        this.created_by = created_by;
    }

    public int getProfilePicId() {
        return profilePicId;
    }

    public void setProfilePicId(int profilePicId) {
        this.profilePicId = profilePicId;
    }

    public LocalDateTime getCreated_on() {
        return created_on;
    }

    public void setCreated_on(LocalDateTime created_on) {
        this.created_on = created_on;
    }

    public Candidate(String candidateName, String candidateDescription, String aadharNumber, int profilePicId, String partyName, int partyLogoId, int created_by) {
        this.candidateName = candidateName;
        this.candidateDescription = candidateDescription;
        this.aadharNumber = aadharNumber;
        this.profilePicId = profilePicId;
        this.partyName = partyName;
        this.partyLogoId = partyLogoId;
        this.voteCount = 0;
        this.isCandidatureRevoked = false;
        this.created_by = created_by;
    }



    public Candidate() {
        super();
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateID) {
        this.candidateId = candidateID;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateDescription() {
        return candidateDescription;
    }

    public void setCandidateDescription(String candidateDescription) {
        this.candidateDescription = candidateDescription;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public int getPartyLogoId() {
        return partyLogoId;
    }

    public void setPartyLogoId(int partyLogoId) {
        this.partyLogoId = partyLogoId;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public boolean isCandidatureRevoked() {
        return isCandidatureRevoked;
    }

    public void setCandidatureRevoked(boolean candidatureRevoked) {
        isCandidatureRevoked = candidatureRevoked;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "candidateId=" + candidateId +
                ", candidateName='" + candidateName + '\'' +
                ", candidateDescription='" + candidateDescription + '\'' +
                ", aadharNumber='" + aadharNumber + '\'' +
                ", profilePicId=" + profilePicId +
                ", partyName='" + partyName + '\'' +
                ", partyLogoId=" + partyLogoId +
                ", voteCount=" + voteCount +
                ", isCandidatureRevoked=" + isCandidatureRevoked +
                ", created_by=" + created_by +
                ", created_on=" + created_on +
                '}';
    }
}
