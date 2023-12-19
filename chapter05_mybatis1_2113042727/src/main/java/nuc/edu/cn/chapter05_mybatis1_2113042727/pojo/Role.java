package nuc.edu.cn.chapter05_mybatis1_2113042727.pojo;

import java.util.List;

public class Role {
    private Integer id;
    private String name;
    private List<Student> stuList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStuList() {
        return stuList;
    }

    public void setStuList(List<Student> stuList) {
        this.stuList = stuList;
    }
}
