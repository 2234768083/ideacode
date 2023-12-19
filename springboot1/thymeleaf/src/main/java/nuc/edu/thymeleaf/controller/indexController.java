package nuc.edu.thymeleaf.controller;

import nuc.edu.thymeleaf.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hongjun
 * @create 2020-10-22 14:47
 */
@Controller
public class indexController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("msg","今天心情不错");
        return "test";
    }
    @GetMapping("test2")
    public String test2(Model model){
        User user = new User();
        user.setAge(21);
        user.setName("Jackson");
        user.setFriend(new User("李小龙", 30));
        model.addAttribute("user", user);
        return "hello2";
    }
    @GetMapping("test3")
    public String show(Model model){
        model.addAttribute("today", new Date());
        return "hello3";
    }
    @GetMapping("test4")
    public String show3(Model model){
        List<User> userList=new ArrayList<>();
        User user1 = new User();
        user1.setAge(21);
        user1.setName("Jackson");
        User user2 = new User();
        user2.setAge(20);
        user2.setName("John");
        userList.add(user1);
        userList.add(user2);
        model.addAttribute("userlist",userList);
        return "hello4";
    }

}
