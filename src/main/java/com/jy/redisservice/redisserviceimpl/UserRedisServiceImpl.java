package com.jy.redisservice.redisserviceimpl;

import com.jy.domain.Post;
import com.jy.domain.User;
import com.jy.redisdao.RedisDao;
import com.jy.redisservice.UserRedisService;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.SortParameters;
import org.springframework.data.redis.core.BulkMapper;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.query.SortQueryBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/5/18.
 */
@Service("userRedisService")
public class UserRedisServiceImpl implements UserRedisService{
    @Resource
    private RedisDao redisDao;

    @Override
    public User getUser(String username) {
        if(checkKeyExists(User.Key_username2Id(username))){
            Long id = Long.parseLong( redisDao.get(User.Key_username2Id(username)));
            String password = redisDao.get(User.Key_id2Password(id));
            User user = new User();
            user.setId(id);
            user.setUsername(username);
            user.setPassword(password);
            return user;
        }else{
            return null;
        }
    }

    @Override
    public void addUser(final User user) {
        final User fUser = user;
        SessionCallback sessionCallback = new SessionCallback() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
               // operations.multi();
                Long id  = operations.opsForValue().increment(User.Key_global(), 1L);
                operations.opsForList().leftPush("newuserlink",id+"");
                operations.opsForList().trim("newuserlink",0,49);
                operations.opsForValue().set(User.Key_username2Id(fUser.getUsername()),id+"");
                operations.opsForValue().set(User.Key_id2Username(id),fUser.getUsername());
                operations.opsForValue().set(User.Key_id2Password(id),fUser.getPassword());
                //operations.exec();
                return null;
            }
        };
        redisDao.getRedisTemplate().execute(sessionCallback);
    }

    @Override
    public Boolean checkKeyExists(String key) {
        return redisDao.getRedisTemplate().hasKey(key);
    }

    @Override
    public List getNewUserNames() {
        return (List)redisDao.getRedisTemplate().execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                SortQueryBuilder s = SortQueryBuilder.sort("newuserlink");
                s.order(SortParameters.Order.DESC);
                s.get("user:id:*:username");
                return operations.sort(s.build());
            }
        });
    }

    @Override
    public void addPost(final Post post) {
        final Post fPost = post;
      SessionCallback sessionCallback = new SessionCallback() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                // operations.multi();
                Long id  = operations.opsForValue().increment(Post.Key_global(), 1L);
                operations.opsForValue().set(Post.Key_id2Time(id),post.getTime()+"");
                operations.opsForValue().set(Post.Key_id2Userid(id),post.getUserid()+"");
                operations.opsForValue().set(Post.Key_id2Content(id),post.getContent());
                //operations.exec();
                return null;
            }
        };
        redisDao.getRedisTemplate().execute(sessionCallback);
    }
}
