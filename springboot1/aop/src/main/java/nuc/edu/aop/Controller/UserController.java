package nuc.edu.aop.Controller;

import nuc.edu.aop.Entity.User;
import nuc.edu.aop.Service.UserService;
import nuc.edu.aop.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hongjun
 * @create 2020-09-16 8:10
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/print")
    @ResponseBody
    public User print(Integer id,String name){
        User user=new User();
        //System.out.println(user.toString());
        user.setId(id);
        user.setName(name);
        userService.printUser(user);
        return user;
    }
 /*   @RequestMapping("/printandvalidate")
    @ResponseBody
    public User print(Integer id, String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        UserValidator userValidator = (UserValidator) userService;
        //验证用户名是否为空
        if (userValidator.validate(user)) {
            userService.printUser(user);
        }
        return user;
    }*/
}
