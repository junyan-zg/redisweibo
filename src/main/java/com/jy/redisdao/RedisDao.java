package com.jy.redisdao;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016/5/18.
 */
public interface RedisDao {
    public void set(String key,String value);
    public void update(String key,String newValue) throws Exception;
    public String get(String key);
    public void del(String key) throws Exception;
    public RedisTemplate getRedisTemplate();
}
