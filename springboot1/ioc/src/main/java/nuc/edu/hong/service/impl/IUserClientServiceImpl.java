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
public class IUserClientServiceImpl implements IUserClientService {
    private IUserClientDao userClientDao;
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

   /* public IUserClientServiceImpl(IUserClientDaoImpl userClientDao) {
        this.userClientDao=userClientDao;
    }*/

    public void setUserClientDao(IUserClientDaoImpl userClientDao) {
        this.userClientDao = userClientDao;
    }
    public IUserClientServiceImpl() {
    }
    @Override
    public void saveCustom() {
        System.out.println("业务层调用持久层"+name);
        userClientDao.saveCustom();
        /*for (String str:list
             ) {
            System.out.println(str);
        }
        for (String str:arr
             ) {
            System.out.println(str);
        }
        for (String s:set
             ) {
            System.out.println(s);
        }
        Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
        while(entries.hasNext()){
            Map.Entry<String, String> entry = entries.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+":"+value);
        }*/
    }

}
