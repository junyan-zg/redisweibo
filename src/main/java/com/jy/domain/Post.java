package com.jy.domain;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/19.
 */
public class Post implements Serializable {
    private Long id;
    private Long time;
    private Long userid;
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }


    public static String Key_global(){
        return "global:postid";
    }
    public static String Key_id2Time(Long id){
        return "post:id:" + id + ":time";
    }
    public static String Key_id2Userid(Long id){
        return "post:id:" + id + ":userid";
    }
    public static String Key_id2Content(Long id){
        return "post:id:" + id + ":content";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
