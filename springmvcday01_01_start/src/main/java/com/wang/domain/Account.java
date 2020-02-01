package com.wang.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Account implements Serializable {
    private String username;
    private String psd;
    private Double money;

    private List<User> list;
    private Map<String,User> map;

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public Map<String, User> getMap() {
        return map;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }
    /*private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", psd='" + psd + '\'' +
                ", money=" + money +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
