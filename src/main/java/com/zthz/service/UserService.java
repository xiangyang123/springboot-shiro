package com.zthz.service;


import com.zthz.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by zouxiang on 2017/6/30.
 */
public interface UserService {
    List<User> findAllByNulls();

    User findByName(String userName);

    Page<User> findByName(String name, Pageable pageable);
}
