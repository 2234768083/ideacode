package nuc.edu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 用户的包装类型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserQueryVo {
    //包装查询条件
    private List<Integer> ids;
    //用户查询条件
    private UserCustomer userCustomer;
    //可以包装其他的查询条件，如订单表和商品表的条件

}
