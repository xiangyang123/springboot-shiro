package com.zthz.service.impl;

import com.zthz.bean.User;
import com.zthz.dao.UserMapper;
import com.zthz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zouxiang on 2017/6/30.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllByNulls() {
        return userMapper.findAllByNulls();
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public Page<User> findByName(String name, Pageable pageable) {

        return userMapper.findByName(name,pageable);
    }

}
