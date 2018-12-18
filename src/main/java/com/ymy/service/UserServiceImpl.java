package com.ymy.service;

import com.ymy.dao.IUserDao;
import com.ymy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: filmbbs
 * @BelongsPackage: com.ymy.service
 * @Author: ymy
 * @CreateTime: 2018-12-13 11:09
 * @Description: 用户业务层
 * @Version: 1.0
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public List<User> selectNameExit(User user) {

        return userDao.selectNameExit(user);
    }

    @Override
    public int addUser(User user) {

        return userDao.addUser(user);
    }

    @Override
    public boolean selectUserExit(User user) {
        User user1 = userDao.selectUserExit(user);
        if(user1 != null){
            if(user1.getUname().equals(user.getUname())){
                return true;
            }
        }
        return false;
    }

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}
