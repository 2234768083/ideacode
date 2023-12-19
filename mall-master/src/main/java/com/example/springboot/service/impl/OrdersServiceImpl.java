package com.example.springboot.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.controller.enums.OrderStatusEnum;
import com.example.springboot.entity.Cart;
import com.example.springboot.entity.Goods;
import com.example.springboot.entity.OrderItem;
import com.example.springboot.entity.Orders;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.OrdersMapper;
import com.example.springboot.service.ICartService;
import com.example.springboot.service.IGoodsService;
import com.example.springboot.service.IOrderItemService;
import com.example.springboot.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2023-01-18
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

    @Autowired
    private IOrderItemService orderItemService;
    @Autowired
    private ICartService cartService;

    @Autowired
    IGoodsService goodsService;

    @Transactional
    @Override
    public void addOrder(List<Cart> carts) {
        BigDecimal total = new BigDecimal(0);
        Orders orders = new Orders();
        orders.setOrderno(IdUtil.fastSimpleUUID());
        orders.setUserid(TokenUtils.getCurrentUser().getId());
        orders.setStatus(OrderStatusEnum.NEED_PAY.getCode());
        for (Cart cart : carts) {
            total = total.add(cart.getPrice().multiply(BigDecimal.valueOf(cart.getNum())));
        }
        orders.setTotal(total);  // 计算总价格
        save(orders); // 保存订单 获取订单id

        for (Cart cart : carts) {
            // 下单成功，扣库存
            Goods goods = goodsService.getById(cart.getGoodsId());
            if (goods.getNums() < cart.getNum()) {
                throw new ServiceException("-1", "库存不足");
            }
            goods.setNums(goods.getNums() - cart.getNum());
            goodsService.updateById(goods);

            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(orders.getId());
            orderItem.setGoodsName(cart.getGoodName());
            orderItem.setPrice(cart.getPrice());
            orderItem.setImg(cart.getImg());
            orderItem.setNum(cart.getNum());
            orderItem.setGoodsId(cart.getGoodsId());
            orderItemService.save(orderItem);

            // 下单成功后删除购物车商品
            cartService.removeById(cart.getId());
        }
    }

    @Override
    public void updateOrder(Orders orders) {
        if (Objects.equals(orders.getStatus(), OrderStatusEnum.CANCEL.getCode())) {
            // 取消订单，加库存
            Integer ordersId = orders.getId();
            List<OrderItem> orderItems = orderItemService.list(new QueryWrapper<OrderItem>().eq("order_id", ordersId));
            for (OrderItem orderItem : orderItems) {
                Goods goods = goodsService.getById(orderItem.getGoodsId());
                goods.setNums(goods.getNums() + orderItem.getNum());
                goodsService.updateById(goods);
            }
        }
        updateById(orders);
    }
}
