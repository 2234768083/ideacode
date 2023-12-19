package nuc.edu.cn.chapter05_mybatis1_2113042727.pojo;

import java.util.List;

public class Dept {
    private Integer deptno;
    private String dname;
    private String location;
    //一个部门有多名员工
    private List<Emp> emps;
//    setter,getter 方法

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }
}