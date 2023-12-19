package nuc.edu.cn.chapter05_mybatis2_2113042727.controller;

import nuc.edu.cn.chapter05_mybatis2_2113042727.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private IClassService classService;
    @RequestMapping("/getclass/{id}")
    @ResponseBody
    public Class getClass(@PathVariable("id") Integer id) {
// TODO Auto-generated method stub
        return classService.getClass(id);
    }
    @RequestMapping("/getclass2/{id}")
    @ResponseBody
    public Class getClass2(@PathVariable("id") Integer id) {
// TODO Auto-generated method stub
        return classService.getClass(id);
    }
}