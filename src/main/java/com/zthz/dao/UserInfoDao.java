package com.zthz.dao;

import com.zthz.shiro.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zouxiang on 2017/8/14.
 */
public interface UserInfoDao extends JpaRepository<UserInfo,Long> {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}
