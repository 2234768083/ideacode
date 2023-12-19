package com.springmvc.chapter2113042727.controller;

import com.springmvc.chapter2113042727.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user2")
public class UserController2 {
    @ModelAttribute
    public void init(Model model) {
        User user=new User();
        user.setId(4);
        user.setUserName("lisi");
        user.setNote("zs_note");
        model.addAttribute("user", user);
    }
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    @ModelAttribute("name")
    public String init1(@RequestParam(value="name",required=false) String name)
    {
        return name;
    }
    @GetMapping("/hello1")
    public String hello1() {
        return "hello1";
    }
}
