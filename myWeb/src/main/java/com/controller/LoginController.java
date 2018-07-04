package com.controller;

import com.entity.User;
import com.service.UserService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginController implements Controller {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String username = "admin";
        String password = "123";
        User user = userService.login(username,password);
        ModelAndView mav = new ModelAndView();
        mav.addObject("user",user);
        mav.setViewName("index.jsp");
        return mav;
    }
}
