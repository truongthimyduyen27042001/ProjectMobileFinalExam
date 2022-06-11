package com.midterm.reviewfilmproject;

import java.util.List;

public class UserModel {
    String name;
    String email;
    String password;
    String profileImg;

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public UserModel(String name, String email, String password, String profileImg) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.profileImg = profileImg;
    }
    public UserModel() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
