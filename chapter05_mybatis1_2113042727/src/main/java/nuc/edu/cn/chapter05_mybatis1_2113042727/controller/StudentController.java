package nuc.edu.cn.chapter05_mybatis1_2113042727.controller;

import nuc.edu.cn.chapter05_mybatis1_2113042727.pojo.Role;
import nuc.edu.cn.chapter05_mybatis1_2113042727.pojo.Student;
import nuc.edu.cn.chapter05_mybatis1_2113042727.service.IRoleService;
import nuc.edu.cn.chapter05_mybatis1_2113042727.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stu")
public class StudentController {
    @Autowired
    private IStudentService stuService;
    @Autowired
    private IRoleService roleService;
    @RequestMapping("/getstu/{id}")
    @ResponseBody
    public Student findById(@PathVariable("id") Integer id) {
        return stuService.findById(id);
    }
    @RequestMapping("/getrole/{id}")
    @ResponseBody
    public Role findByRoleId(@PathVariable("id") Integer id) {
        return roleService.findById(id);
    }
}