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
    public ModelAndView registerExit(User user){
        ModelAndView mav = new ModelAndView();
        List<User> list =userService.selectNameExit(user);
        if(user.getUname()!=null && user.getUname() != ""){
            if (list.size() >= 0){
                //说明该用户名存在
                mav.addObject("message","用户已存在");
                mav.setViewName("register");
            }else {
                userService.addUser(user);
                mav.setViewName("login");
            }
        }
        return mav;
    }

    @RequestMapping("/loginExit")
    @ResponseBody
    public Map loginExit(@RequestParam("uname")String uname,@RequestParam("upass")String upass, HttpServletRequest request){
        Map<String,Object> model = new HashMap<>();
        HttpSession session = request.getSession();
        User user = new User();
        user.setUname(uname);
        user.setUpass(upass);
        System.out.println(uname);
        System.out.println(upass);
        boolean b = userService.selectUserExit(user);
        int res = 0;
        if (b){
            //如果验证通过，则将用户信息传到前台
            User user1 = userDao.selectUserExit(user);
            session.setAttribute("uname",user1.getUname());
            session.setAttribute("upass",user1.getUpass());
            session.setAttribute("uflag",user1.getUflag());
            session.setAttribute("ustate",user1.getUstate());
            request.setAttribute("message","登录成功");
            res=1;
        }else {
            request.setAttribute("message","账号或密码错误");
            res=0;
        }
        model.put("res",res);
        return model;
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
