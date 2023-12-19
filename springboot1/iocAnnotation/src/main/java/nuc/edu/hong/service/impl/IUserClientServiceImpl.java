package nuc.edu.hong.service.impl;

import nuc.edu.hong.dao.IUserClientDao;
import nuc.edu.hong.dao.impl.IUserClientDaoImpl;
import nuc.edu.hong.service.IUserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author hongjun
 * @create 2020-09-09 16:56
 */
@Service
public class IUserClientServiceImpl implements IUserClientService {
    @Autowired
    private IUserClientDao userClientDao;
    @Value("hongjun")
    private String name;

    public void setList(List list) {
        this.list = list;
    }

    private List<String> list;

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    private String[] arr;

    public void setSet(Set<String> set) {
        this.set = set;
    }

    private Set<String> set;

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    private Map<String, String> map;


    @Override
    public void saveCustom() {
        System.out.println("业务层调用持久层"+name);
        userClientDao.saveCustom();
    }

}
