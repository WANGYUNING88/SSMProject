package com.wang.com.wang.domain;

public class User {
    private String username;
    private String psd;
    private Integer age;

    public User() {
    }

    public User(String username, String psd, Integer age) {
        this.username = username;
        this.psd = psd;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", psd='" + psd + '\'' +
                ", age=" + age +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
