package nuc.edu.aop.validator.impl;

import nuc.edu.aop.Entity.User;
import nuc.edu.aop.validator.UserValidator;

/**
 * @author hongjun
 * @create 2020-09-16 8:51
 */
public class UserValidatorImpl implements UserValidator {
    @Override
    public boolean validate(User user) {
        System.out.println("引入新的接口："+UserValidator.class.getSimpleName());
        return user!=null;
    }
}
