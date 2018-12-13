package com.ymy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.ymy.entity.User;
import com.ymy.service.IUserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

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
public class UserAction extends ActionSupport {
    private String uname;
    private String upass;
    private String result;

    @Autowired
    private IUserService userService;

    public String registerExit(User user){
        user.setUname(uname);
        List<User> list =userService.selectNameExit(user);
        Map<String,String> map = new HashMap<String,String>();
        if (list.size() != 0){
            //说明该用户名存在
            System.out.println("该用户名存在");
            map.put("result","false");
            JSONObject json = JSONObject.fromObject(map);
            result = json.toString();
            return "failed";
        }else {
            map.put("result","true");
        }
        JSONObject json = JSONObject.fromObject(map);
        result = json.toString();
        System.out.println(result);
        return "success";
    }

    public String register(User user){
        user.setUname(uname);
        user.setUpass(upass);
        userService.addUser(user);
        return "addSuccess";
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
}
