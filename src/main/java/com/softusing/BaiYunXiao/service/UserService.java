package com.softusing.BaiYunXiao.service;

import com.softusing.BaiYunXiao.entity.User;
import com.softusing.BaiYunXiao.entity.UserExample;
import com.softusing.BaiYunXiao.mapperIterfac.UserMapper;
import com.softusing.BaiYunXiao.mapperIterfac.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
@Service
public class UserService implements UserServiceInterface {
//    @Autowired
//    private UserMapper userMapper;
//    public int save(User user){
//        return userMapper.insert(user);
//    }

    @Autowired
    private UserMapper userMapper;

    public int save(User user) {
        return userMapper.insert(user);
    }

    public List<User> findByUsername(String username) {
        return userMapper.selectByName(username);
    }

    public List<User> findByPassword(String password) {

        return userMapper.selectByUserPassword(password);
    }

    public List<User> findAll() {
        return userMapper.selectByExample(new UserExample());
    }

    public boolean login(User user) {
        String name = user.getUserName();
        String password = user.getPassword();
        List<User> userLoginList = userMapper.selectByName(name);
        if (userLoginList == null) {
            return false;
        } else {
            for (int i = 0; i < userLoginList.size(); i++) {
                if (userLoginList.get(i).getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
}
