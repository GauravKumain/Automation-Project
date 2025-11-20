package com.ui.pojo;

public class UserLogin {

    private String emailAddress;
    private String password;

    public UserLogin(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
