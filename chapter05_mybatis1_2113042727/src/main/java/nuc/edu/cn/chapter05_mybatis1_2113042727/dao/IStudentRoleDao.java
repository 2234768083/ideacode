package nuc.edu.cn.chapter05_mybatis1_2113042727.dao;

import nuc.edu.cn.chapter05_mybatis1_2113042727.pojo.Role;
import nuc.edu.cn.chapter05_mybatis1_2113042727.pojo.User;

import java.util.List;

public interface IStudentRoleDao {
    public List<User> getStusByRoleId(Integer roleId);
    public List<Role> getRolesByStuId(Integer stuId);
}