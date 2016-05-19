package com.jy.redisservice;

import com.jy.domain.Post;
import com.jy.domain.User;

import java.util.List;

/**
 * Created by Administrator on 2016/5/18.
 */
public interface UserRedisService {
    public User getUser(String username);
    public void addUser(User user);
    public Boolean checkKeyExists(String key);
    public List getNewUserNames();
    public void addPost(Post post);
}
