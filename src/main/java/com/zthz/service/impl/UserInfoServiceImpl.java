package com.zthz.service.impl;

import com.zthz.dao.UserInfoDao;
import com.zthz.service.UserInfoService;
import com.zthz.shiro.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zouxiang on 2017/8/14.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }
}
