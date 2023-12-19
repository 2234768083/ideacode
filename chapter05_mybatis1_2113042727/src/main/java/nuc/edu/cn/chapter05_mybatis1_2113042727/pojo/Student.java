package nuc.edu.cn.chapter05_mybatis1_2113042727.pojo;

import java.util.List;

public class Student {
    private Integer id;
    private String name;
    private String mobile;
    private List<Role> roleList;
    public List<Role> getRoleList() {
        return roleList;
    }
    public void setRoleList(List<Role>roleList) {
        this.roleList = roleList;
    }
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
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}