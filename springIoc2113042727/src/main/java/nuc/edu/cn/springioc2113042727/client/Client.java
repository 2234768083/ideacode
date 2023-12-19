package nuc.edu.cn.springioc2113042727.client;

import nuc.edu.cn.springioc2113042727.service.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
// TODO Auto-generated method stub
        IUserService userService=new UserServiceImpl();
        userService.saveCustom("这是要保存的数据"); }
}