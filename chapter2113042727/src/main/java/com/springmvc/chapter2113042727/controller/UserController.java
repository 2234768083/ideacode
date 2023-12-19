package com.springmvc.chapter2113042727.controller;

import com.springmvc.chapter2113042727.pojo.User;
import com.springmvc.chapter2113042727.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Controller
//@RequestMapping("/user")
//public class UserController {
//    // 注入用户服务类
//    @Autowired
//    private IUserService userService;
//    // 按 id 查询显示结果, 展示用户详情 ,展示结果 Json 格式
//// URL 地址： http://localhost:8080/user/detailsForJson?id=3
//    @RequestMapping("/detailsForJson")
//    public ModelAndView detailsForJson(Integer id) {
//// 访问模型层得到数据
//        User user = userService.getUser(id);
//// 模型和视图
//        ModelAndView mv = new ModelAndView();
//// 生成 JSON 视图
//        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
//        mv.setView(jsonView);
//// 加入模型
//        mv.addObject("user", user);
//        return mv;
//    }
//}
//@Controller
//@RequestMapping("/user")
//public class UserController {
//    // 注入用户服务类
//    @Autowired
//    private IUserService userService;
//    // 按 id 查询显示结果, 展示用户详情 ,展示结果 Json 格式
//// URL 地址： http://localhost:8080/user/detailsForJson?id=3
//    @RequestMapping("/detailsForJson")
//    public ModelAndView detailsForJson(Integer id) {
//// 访问模型层得到数据
//        User user = userService.getUser(id);
//// 模型和视图
//        ModelAndView mv = new ModelAndView();
//// 生成 JSON 视图
//        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
//        mv.setView(jsonView);
//// 加入模型
//        mv.addObject("user", user);
//        return mv;
//    }
//
//    // 按 id 查询显示结果, 展示用户详情，展示结果 jsp 视图
//// URL 地址： http://localhost:8080/user/details?id=3
//    @RequestMapping("/details")
//    public ModelAndView details(Integer id) {
//// 访问模型层得到数据
//        User user = userService.getUser(id);
//// 模型和视图
//        ModelAndView mv = new ModelAndView();
//// 定义模型视图
//// 视 图 路 径 ： application.property 文 件 中 设 置spring.mvc.view.prefix=/WEB-INF/jsp/
//// 视图名称: user/details.jsp
//                mv.setViewName("user/details");
//// 加入数据模型
//        mv.addObject("user", user);
//// 返回模型和视图
//        return mv;
//    }
//}
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService = null;

    /*
     * 打开请求页面
     * return 字符串，指向页面
     */
    @GetMapping("/add")
    public String add() {
        return "/user1/add";
    }

    /*
     * 新增用户
     *@param user 通过@RequestBody注解得到JSON参数
     *return 返回用户信息
     */
    @PostMapping("/insert")
    @ResponseBody
    public User insert(@RequestBody User user) {
        userService.insertUser(user);
        return user;
    }

    //显示数据 http://localhost:8080/user/list
    @RequestMapping("/list")
    @ResponseBody
    public List<User> list() {
        //访问模型层得到数据
        List<User> users = userService.findAllUser();
        return users;
    }

    //显示数据 http://localhost:8080/user/details1
    @RequestMapping("/details1")
    public ModelAndView table0() {
//访问模型层得到数据
        List<User> users = userService.findAllUser();
//模型和视图
        ModelAndView mv = new ModelAndView();
//定义模型视图
        mv.setViewName("user/details1");
//加入数据模型
        mv.addObject("users", users);
//返回模型和视图
        return mv;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User getUserDetails(@PathVariable("id") Integer id) {
        // Fetch user details by ID
        User user = userService.getUser(id);

        // Return the user details as JSON
        return user;
    }
    @RequestMapping("/format/form")
    public String showFormat() {
        return "/format/formatter";
    }
    //获取提交参数
    @PostMapping("/format/commit")
    @ResponseBody
    public Map<String, Object> format(
            @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) Date date,
            @NumberFormat(pattern="#,###.###") Double number
    ){
        Map<String, Object> dataMap=new HashMap();
        dataMap.put("date", date);
        dataMap.put("number", number);
        return dataMap;
    }
}