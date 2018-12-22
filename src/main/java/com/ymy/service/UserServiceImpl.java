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
    public int selectNameExit(String uname) {

        return userDao.selectNameExit(uname);
    }

    @Override
    public int addUser(User user) {

        return userDao.addUser(user);
    }

    @Override
    public User selectUserExit(User user) {
        return userDao.selectUserExit(user);
    }

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}
