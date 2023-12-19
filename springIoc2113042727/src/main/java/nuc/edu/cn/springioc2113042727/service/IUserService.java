package nuc.edu.cn.springioc2113042727.service;
public class UserServiceImpl implements IUserService {
    private IUserDao userDao;
    @Override
    public void saveCustom(String arg) {
// TODO Auto-generated method stub
        System.out.println("业务逻辑层被调用");
        System.out.println("Service接收参数："+arg);
        arg=arg+":"+this.hashCode();

// this.hashCode()JVM每new一个Object,它都会将这个Object丢到一个
//Hash哈希表中去，这样的话,下次做 Object的比较或者取这个对象的时候,
//它会根据对象的hashcode再从Hash表中取这个对象。这样做的目的是提高取对象的效率。
        userDao=new UserDaoImpl();
        userDao.saveCustom(arg);
    }
}
