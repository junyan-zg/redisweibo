package com.jy.redisservice;

import com.jy.domain.Post;
import com.jy.domain.User;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

/**
 * Created by Administrator on 2016/5/18.
 */
public interface UserRedisService {
    public RedisTemplate getRedisTemplate();
    public User getUser(String username);
    public List<Post> getPosts(Long userid);
    public void addUser(User user);
    public Boolean checkKeyExists(String key);
    public List getNewUserNames();
    public void addPost(Post post);
    public Boolean isMyCatch(final Long myuserid,final Long catcherId);
    public void addCatch(final Long myuserid,final Long catcherId);
    public void removeCatch(final Long myuserid,final Long catcherId);
}
