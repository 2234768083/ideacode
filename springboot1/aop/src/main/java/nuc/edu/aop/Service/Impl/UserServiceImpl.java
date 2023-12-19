package nuc.edu.aop.Service.Impl;

import nuc.edu.aop.Entity.User;
import nuc.edu.aop.Service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author hongjun
 * @create 2020-09-16 7:39
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public void printUser(User user) {
        if(user==null){
            throw new RuntimeException("用户不能为空！");
        }
        System.out.println("用户id:"+user.getId());
        System.out.println("用户姓名："+user.getName());
    }
}
