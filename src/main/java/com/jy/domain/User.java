package com.jy.domain;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/18.
 */
public class User implements Serializable{
    private Long id;
    private String username;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String Key_global(){
        return "global:userid";
    }
    public static String Key_id2Username(Long id){
        return "user:id:" + id + ":username";
    }
    public static String Key_id2Password(Long id){
        return "user:id:" + id + ":password";
    }
    public static String Key_username2Id(String username){
        return "user:username:" + username + ":id";
    }
}
