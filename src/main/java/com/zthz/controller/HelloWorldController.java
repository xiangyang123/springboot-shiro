package com.zthz.controller;

import com.alibaba.fastjson.JSONObject;
import com.zthz.bean.User;
import com.zthz.service.UserService;
import com.zthz.util.PageUtil;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zouxiang on 2017/8/11.
 */
@Controller
public class HelloWorldController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
    @Autowired
    private UserService userService;
    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "456");
        return "home";
    }
    @RequestMapping("/hello/{myName}")
    @ResponseBody
    public String index(@PathVariable String myName){
        return "hello"+myName+"!";
    }

    @RequestMapping("/findAll")
    public String users(){
//        userService.findAll()
//        return userService.findAll();
        User user = userService.findByName("zouxiang");
        System.out.println("age: "+user.getAge());

        List<User> users = userService.findAllByNulls();
        System.out.println(users.size());

        /**
         * 分页查找数据
         */
        int page=1,size=10;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<User> userList = userService.findByName("zouxiang1",pageable);
        System.out.println("totalpages: "+userList.getTotalPages());
        return null;
    }


    @RequestMapping(value = "yard")
    public String yardRecord(){
        return "yard";
    }

    @RequestMapping(value="userList")
    @ResponseBody
    public JSONObject userList(@RequestParam int page,@RequestParam int rows){
        Pageable pageable = new PageRequest(page-1, rows);
        Page<User> userList = userService.findByName("5",pageable);
        JSONObject jsonObject = PageUtil.page(userList);
        return jsonObject;
    }


}
