package com.softusing.BaiYunXiao.mapperIterfac;

import com.softusing.BaiYunXiao.entity.User;

import java.util.List;

public interface UserServiceInterface {
//    int save(User user);
    int save(User user);

    boolean login(User user);

    List<User> findByPassword(String password);

    List<User> findByUsername(String username);

    List<User> findAll();
}
