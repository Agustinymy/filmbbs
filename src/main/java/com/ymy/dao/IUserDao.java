package com.ymy.dao;

import com.ymy.entity.User;
import org.apache.ibatis.annotations.Param;
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

    int selectNameExit(@Param("uname")String uname);

    int addUser(User user);

    User selectUserExit(User user);

}
