package nuc.edu.service.impl;

import nuc.edu.entity.Order;
import nuc.edu.mapper.OrderMapper;
import nuc.edu.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 洪军
 * @since 2020-12-09
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
