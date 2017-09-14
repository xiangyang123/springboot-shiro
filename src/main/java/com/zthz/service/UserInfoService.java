package com.zthz.service;

import com.zthz.shiro.UserInfo;

/**
 * Created by zouxiang on 2017/8/14.
 */
public interface UserInfoService {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}
