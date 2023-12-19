package nuc.edu.hong.dao.impl;

import nuc.edu.hong.dao.IUserClientDao;
import org.springframework.stereotype.Repository;

/**
 * @author hongjun
 * @create 2020-09-09 16:53
 */
@Repository
public class IUserClientDaoImpl implements IUserClientDao {
    @Override
    public void saveCustom() {
        System.out.println("调用持久层DAO");
    }
}
