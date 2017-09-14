package com.zthz.dao;

import com.zthz.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zouxiang on 2017/6/30.
 */
@Repository
public interface UserMapper extends JpaRepository<User, Long> {

    User findByName(String name);

    @Query("select u from User u")
    List<User> findAllByNulls();



    /**
     * 分页查找
     * @param name
     * @param pageable
     * @return
     */
    Page<User> findByName(String name, Pageable pageable);

    @Override
    User save(User user);

    //    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
//    int insert(@Param("name") String name, @Param("age") Integer age);
//
//    @Select("SELECT * FROM USER")
//    List<User> findAll();
}
