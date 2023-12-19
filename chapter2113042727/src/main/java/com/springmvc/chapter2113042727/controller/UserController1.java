package com.springmvc.chapter2113042727.controller;

import com.springmvc.chapter2113042727.pojo.User;
import com.springmvc.chapter2113042727.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user1")
public class UserController1 {
    @Autowired
    private IUserService userService;
    @ModelAttribute
    public void init0() {
        System.out.println("init0....");
    }
    @ModelAttribute
    public void init1() {
        System.out.println("init1....");
    }
    @GetMapping("/findById/{id}")
    @ResponseBody
    public String findById(@PathVariable Integer id) {
        User user = userService.getUser(id);
        return user.getUserName();
    }
    @ModelAttribute
    public void init2() {
        System.out.println("init2....");
    }
}
