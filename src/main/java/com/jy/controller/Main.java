package com.jy.controller;

/**
 * Created by Administrator on 2016/5/16.
 */

import com.jy.domain.User;
import com.jy.redisservice.UserRedisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class Main {

    @Resource
    private UserRedisService userRedisService;

    @ResponseBody
    @RequestMapping("register")
    public String register(User user){
        Boolean exists = userRedisService.checkKeyExists(User.Key_username2Id(user.getUsername()));
       if (!exists){
            userRedisService.addUser(user);
            return "<script>alert('注册成功')</script>";
        }else {
            return "<script>alert('用户已存在')</script>";
        }
    }
    @RequestMapping("login")
    public String login(User user, HttpSession session, HttpServletRequest request){
        User userFromRedis = userRedisService.getUser(user.getUsername());
        if(userFromRedis!=null && userFromRedis.getPassword().equals(user.getPassword())){
            session.setAttribute("user",userFromRedis);
            return "redirect:/user/toHome";
        }else{
            request.setAttribute("err","用户名或密码错误");
            return "error";
        }
    }
}
