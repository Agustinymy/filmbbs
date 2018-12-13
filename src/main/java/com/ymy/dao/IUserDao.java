package com.ymy.dao;

import com.ymy.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @BelongsProject: filmbbs
 * @BelongsPackage: com.ymy.dao
 * @Author: ymy
 * @CreateTime: 2018-12-13 10:54
 * @Description: ${Description}
 * @Version: 1.0
 */
@Repository
public interface IUserDao {

    List<User> selectNameExit(User user);

    int addUser(User user);

}
