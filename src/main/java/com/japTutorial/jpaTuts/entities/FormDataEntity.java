package com.japTutorial.jpaTuts.entities;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class FormDataEntity {
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FormDataEntity{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", image=" + image +
                ", aadhar='" + aadhar + '\'' +
                '}';
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getPassword() {
        return password;
    }

    public MultipartFile getImage() {
        return image;
    }

    public String getAadhar() {
        return aadhar;
    }

    public FormDataEntity(String name, String email, String password, MultipartFile image, String aadhar) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.image = image;
        this.aadhar = aadhar;
    }

    private String password;
    private MultipartFile image;
    private String aadhar;
}
