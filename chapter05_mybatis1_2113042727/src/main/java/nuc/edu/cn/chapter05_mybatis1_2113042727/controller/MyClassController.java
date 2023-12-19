package nuc.edu.cn.chapter05_mybatis1_2113042727.controller;

import nuc.edu.cn.chapter05_mybatis1_2113042727.pojo.MyClass;
import nuc.edu.cn.chapter05_mybatis1_2113042727.service.IMyClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/class")
public class MyClassController {
    @Autowired
    private IMyClassService classService;
    @RequestMapping("/getclass/{id}")
    @ResponseBody
    public MyClass getMyClass(@PathVariable("id") Integer id) {
// TODO Auto-generated method stub
        return classService.getMyClass(id);
    }
    @RequestMapping("/getclass2/{id}")
    @ResponseBody
    public MyClass getMyClass2(@PathVariable("id") Integer id) {
// TODO Auto-generated method stub
        return classService.getMyClass(id);
    }
}