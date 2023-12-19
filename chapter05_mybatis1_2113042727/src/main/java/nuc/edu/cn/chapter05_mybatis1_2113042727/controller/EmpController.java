package nuc.edu.cn.chapter05_mybatis1_2113042727.controller;

import nuc.edu.cn.chapter05_mybatis1_2113042727.pojo.Dept;
import nuc.edu.cn.chapter05_mybatis1_2113042727.pojo.Emp;
import nuc.edu.cn.chapter05_mybatis1_2113042727.service.IDeptService;
import nuc.edu.cn.chapter05_mybatis1_2113042727.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private IEmpService empService;
    @Autowired
    private IDeptService deptService;
    @RequestMapping("/find1/{empno}")
    @ResponseBody
    public List<Emp> findByEmpno(@PathVariable("empno") Integer empno) {
        return empService.findByEmpno(empno);
    }
    @RequestMapping("/find2/{deptno}")
    @ResponseBody
    public List<Emp> findByDeptno(@PathVariable("deptno") Integer deptno) {
        return empService.findByDeptno(deptno);
    }
    @RequestMapping("/find3/{deptno}")
    @ResponseBody
    public Dept findByDeptno1(@PathVariable("deptno") Integer deptno) {
        return deptService.findByDeptno(deptno);
    }
}