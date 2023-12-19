package nuc.edu.cn.chapter05_mybatis1_2113042727.controller;

import nuc.edu.cn.chapter05_mybatis1_2113042727.pojo.User;
import nuc.edu.cn.chapter05_mybatis1_2113042727.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    // 注入用户服务类
    @Autowired
    private IUserService userService;
    // 1.通过URL传递参数
    @GetMapping("/{id}")
// 相应为JSON数据集
    @ResponseBody
// @PathVariable 通过参数名称获取参数
    public User get(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }
    @RequestMapping("/list1")
    @ResponseBody
    public List<User> list1() {
// 访问模型层得到数据
        List<User> users = userService.findAllUser();
        for (User user : users) {
            System.out.println(user.getUserName());
        }
        return users;
    }
    @RequestMapping("/list2")
    @ResponseBody
    public List<User> list2(@RequestParam(value = "userName", required =
            false) String userName,
                            @RequestParam(value = "note", required = false) String note)
    {
// 访问模型层得到数据
        List<User> users = userService.findUsers(userName, note);
        for (User user : users) {
            System.out.println(user.getUserName());
        }
        return users;
    }
    @RequestMapping("/insert")
    @ResponseBody
    public Integer insert(@RequestParam(value = "userName", required =
            false) String userName,
                          @RequestParam(value = "note", required = false) String note)
    {
// 访问模型层得到数据
        User user=new User();
        user.setUserName(userName);
        user.setNote(note);
        userService.insertUser(user);
        return user.getId();
    }
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") Integer id) {
        return "删除数据["+userService.deleteUser(id)+"]条";
    }
    @RequestMapping("/update")
    @ResponseBody
    public Integer update(@RequestParam(value = "id") Integer id,
                          @RequestParam(value = "userName", required = false) String userName,
                          @RequestParam(value = "note", required = false) String note)
    {
        // 首先通过id获取要更新的用户
        User existingUser = userService.getUser(id);

        // 检查用户是否存在
        if (existingUser == null) {
            // 用户不存在，可以根据需要处理这种情况
            return 0;
        }

        // 更新用户信息
        if (userName != null) {
            existingUser.setUserName(userName);
        }
        if (note != null) {
            existingUser.setNote(note);
        }

        // 调用模型层更新数据
        userService.updateUser(existingUser);

        return existingUser.getId();
    }
}

