package com.zthz.controller;

import com.alibaba.fastjson.JSONObject;
import com.zthz.service.UserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zouxiang on 2017/9/11.
 */
@Controller
public class ShiroController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(ShiroController.class);


    @Autowired
    private UserInfoService UserInfoService;

    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String loginForm(Model model){
        return "login";
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    @ResponseBody
    public JSONObject checkLogin(HttpServletRequest request){
        return getJsonObject(request);

    }

    private JSONObject getJsonObject(HttpServletRequest request) {
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");

        logger.info("exception=" + exception);
        String msg = "";
        String status = "1";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                logger.info("UnknownAccountException -- > 账号不存在");
                msg = "账号不存在";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                logger.info("IncorrectCredentialsException -- > 密码不正确");
                msg = "密码不正确";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                logger.info("kaptchaValidateFailed -- > 验证码错误");
                msg = " 验证码错误";
            } else {
                msg = "登录失败";
                logger.info("else -- >" + exception);
            }
            status = "0";
        }
        return assemblyJson("",status,msg);
    }


    @RequestMapping(value="/",method= RequestMethod.GET)
    @ResponseBody
    public JSONObject login(HttpServletRequest request){
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        return getJsonObject(request);
    }

    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public String logout(RedirectAttributes redirectAttributes ){
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息
        SecurityUtils.getSubject().logout();
        redirectAttributes.addFlashAttribute("message", "您已安全退出");
        return "redirect:/login";
    }

}
