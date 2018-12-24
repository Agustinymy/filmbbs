package com.ymy.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.ymy.dao.IUserDao;
import com.ymy.entity.User;
import com.ymy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: filmbbs
 * @BelongsPackage: com.ymy.action
 * @Author: ymy
 * @CreateTime: 2018-12-13 12:16
 * @Description: 用户控制层
 * @Version: 1.0
 */
// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("/userForm")
public class UserController extends ActionSupport {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserDao userDao;

    @RequestMapping("/registerExit")
    @ResponseBody
    public Map<String,Object> registerExit(User user){
        System.out.println(user);
        Map<String,Object> map = new HashMap<>();
        int res=0;
        if(user.getUname()!=null && user.getUname() != "" && user.getUpass()!=null && user.getUpass()!=""){
            try {
                res=userService.addUser(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (res>0){
                map.put("res",true);
                return map;
            }
        }
        return map;
    }

    /**
     * @author hyj
     * @param uname
     * @return
     * 异步显示用户注册账户时的账号占用信息
     */
    @RequestMapping(value = "/checkUname")
    @ResponseBody
     public Map<String,Object> checkUserByName(@RequestParam("uname")String uname){
        Map<String,Object> map = new HashMap<>();
        int res=userService.selectNameExit(uname);
        if (res>0){
            map.put("res",true);
            return map;
        }
        map.put("res",false);
        return map;
    }
    @RequestMapping("/loginExit")
    @ResponseBody
    public Map<String,Object> loginExit(@RequestParam("uname")String uname,@RequestParam("upass")String upass, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        HttpSession session = request.getSession();
        User user = new User();
        user.setUname(uname);
        user.setUpass(upass);
        System.out.println(uname+":"+upass);
        try {
            user = userService.selectUserExit(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int res = 0;
        if (user!=null){
            //用户存在，可登录
            session.setAttribute("message","登录成功");
            map.put("user",user);
            res=1;
        }else {
            session.setAttribute("message","账号或密码错误");
            res=0;
        }
        map.put("res",res);
        return map;
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}
