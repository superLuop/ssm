package com.lp.ssm.web.controller;

import com.lp.ssm.model.User;
import com.lp.ssm.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public ModelAndView login(String username, String password, ModelAndView mv, HttpSession session){

//        //1.获取用户名和密码数据
//        Map<String, String[]> map = request.getParameterMap();
//        //2.封装User对象
//        User user = new User();
//        try {
//            BeanUtils.populate(user,map);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        System.out.println(user);
        //3.调用service查询
        User user = userService.login(username,password);
        System.out.println(user);

        if(user != null){
            //登录成功
            //1.保存session
            session.setAttribute("user",user);
            //2.进入主页面
            mv.setViewName("mainPage");
        }else {
            //登录失败
            mv.addObject("message","登录名和密码错误，请重新输入");
            //进入登录页面
            mv.setViewName("login");
        }
        return mv;
    }
}
