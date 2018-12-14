package com.ymy.service;

import com.ymy.entity.User;

import java.util.List;

/**
 * @BelongsProject: filmbbs
 * @BelongsPackage: com.ymy.service
 * @Author: ymy
 * @CreateTime: 2018-12-13 11:09
 * @Description: ${Description}
 * @Version: 1.0
 */
public interface IUserService {

    List<User> selectNameExit(User user);

    int addUser(User user);

    boolean selectUserExit(User user);
}
