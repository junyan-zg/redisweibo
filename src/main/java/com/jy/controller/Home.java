package com.jy.controller;

/**
 * Created by Administrator on 2016/5/16.
 */

import com.jy.domain.Post;
import com.jy.domain.User;
import com.jy.redisservice.UserRedisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class Home {

    @Resource
    private UserRedisService userRedisService;

    @RequestMapping("/toHome")
    public String toHome(){
        return "WEB-INF/jsp/user/home";
    }
    @RequestMapping("/toProfile")
    public String toProfile(String username,HttpServletRequest request,HttpSession session){
        User userCatch = userRedisService.getUser(username);
        request.setAttribute("userCatch",userCatch);
        User user = (User) session.getAttribute("user");
        Boolean isMyCatch = userRedisService.isMyCatch(user.getId(), userCatch.getId());
        request.setAttribute("isMyCatch",isMyCatch);
        return "WEB-INF/jsp/user/profile";
    }
    @RequestMapping("/toTimeline")
    public String toTimeline(HttpServletRequest request){
        request.setAttribute("newusers",userRedisService.getNewUserNames());
        return "WEB-INF/jsp/user/timeline";
    }

    @RequestMapping("/follow")
    public String follow(Long userCatchId,String username,int action,HttpSession session){
        User user = (User) session.getAttribute("user");
        if (action==0){
            userRedisService.removeCatch(user.getId(),userCatchId);
        }else if (action==1){
            userRedisService.addCatch(user.getId(),userCatchId);
        }
        return "redirect:toProfile?username="+username;
    }
    @RequestMapping("/post")
    public void post(Post post,HttpSession session){
        post.setTime(new Date().getTime());
        post.setUserid(((User)session.getAttribute("user")).getId());
        userRedisService.addPost(post);
    }



}
