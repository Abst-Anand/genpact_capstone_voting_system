package com.votingSystem.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/* Role 1=Admin, 2=SubAdmin, 3=Voter
* */


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    private String email;
    private int profilePictureId;
    private String aadharNumber;
    private int role;
    private String password;
    private boolean isAuthorityRevoked;
    private int createdBy;

    public User(){
        super();
    }

    public User(String name, String email, int profilePictureId,String aadharNumber, int role, String password, int createdBy) {
        super();
        this.name = name;
        this.email = email;
        this.profilePictureId = profilePictureId;
        this.aadharNumber = aadharNumber;
        this.role = role;
        this.password = password;
        this.createdBy = createdBy;
        this.isAuthorityRevoked = false;
    }

    public User(int userId,String name, String email, int profilePictureId, String aadharNumber, int role, String password, int createdBy) {
        super();
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.profilePictureId = profilePictureId;
        this.aadharNumber = aadharNumber;
        this.role = role;
        this.password = password;
        this.createdBy = createdBy;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getProfilePictureId() {
        return profilePictureId;
    }

    public void setProfilePictureId(int profilePictureId) {
        this.profilePictureId = profilePictureId;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAuthorityRevoked() {
        return isAuthorityRevoked;
    }

    public void setAuthorityRevoked(boolean authorityRevoked) {
        isAuthorityRevoked = authorityRevoked;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }
}
