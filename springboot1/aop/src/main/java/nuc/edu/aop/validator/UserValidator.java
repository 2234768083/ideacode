package nuc.edu.aop.validator;

import nuc.edu.aop.Entity.User;

/**
 * @author hongjun
 * @create 2020-09-16 8:50
 */
public interface UserValidator {
    //检测用户对象是否为空
    public boolean validate (User user);
}
