package nuc.edu.mapper;

import nuc.edu.entity.orders;

public interface ordersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(orders record);

    int insertSelective(orders record);

    orders selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(orders record);

    int updateByPrimaryKey(orders record);
}