package com.example.empolyeemanegement.model;

public class User {

    //like employee id,
    //// employee name, department name, mobile number, and employee salary.
    private int userId;
    private String name;
    private String mobileNum;
    private Role role;

    public User() {
    }

    public User(int userId, String name, String mobileNum, Role role) {
        this.userId = userId;
        this.name = name;
        this.mobileNum = mobileNum;
        this.role = role;
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

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", mobileNum='" + mobileNum + '\'' +
                ", role=" + role +
                '}';
    }
}
