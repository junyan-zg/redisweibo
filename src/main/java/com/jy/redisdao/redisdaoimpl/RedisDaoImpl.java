package com.jy.redisdao.redisdaoimpl;

import com.jy.redisdao.RedisDao;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/18.
 */
@Repository("baseDao")
public class RedisDaoImpl implements RedisDao {
    @Resource
    private RedisTemplate<String, String>  redisTemplate;
    @Override
    public void set(String key,String value) {
        redisTemplate.opsForValue().set(key,value);
    }

    @Override
    public void update(String key, String newValue) throws Exception{
        if (redisTemplate.hasKey(key)){
            redisTemplate.opsForValue().set(key,newValue);
        }else{
            throw new Exception("Key: '" + key + "' isn't exists");
        }
    }

    @Override
    public String get(String key) {
        return  redisTemplate.opsForValue().get(key);
    }

    @Override
    public RedisTemplate getRedisTemplate(){
        return redisTemplate;
    }

    public void del(String key) throws Exception{
        if (redisTemplate.hasKey(key)){
            redisTemplate.delete(key);
        }else{
            throw new Exception("Key: '" + key + "' isn't exists");
        }
    }
}
