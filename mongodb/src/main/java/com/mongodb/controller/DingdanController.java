package com.mongodb.controller;

import com.mongodb.config.MongoDBAppender;
import com.mongodb.pojo.Logistics;
import com.mongodb.pojo.dingdan;
import com.mongodb.pojo.historyorder;
import com.mongodb.service.dingdanService;
import com.mongodb.utils.CommonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单管理控制器
 */
@RestController
@Api(tags = "订单管理")
public class DingdanController {
    // 日志信息注入
    private static final Logger logger = LoggerFactory.getLogger(DingdanController.class);
    private static final Logger logs = LoggerFactory.getLogger(CommonUtils.class);
    private static final Logger los = LoggerFactory.getLogger(MongoDBAppender.class);

    @Autowired
    dingdanService dingdanService;

    // 添加订单信息
    @PostMapping("addorder")
    @ApiOperation(value = "添加订单信息")
    public String addorder(dingdan dingdan) {
        dingdan.setStatus("发货中");
        dingdan.setOrderTime(new Date());
        dingdan.setShipTime(new Date());
        dingdanService.addorder(dingdan);
        return "添加成功";
    }

    // 添加物流信息
    @PostMapping("updateorder")
    @ApiOperation(value = "添加物流信息")
    public String updateorder(Logistics logistics) {
        logistics.setOperationTime(new Date());
        dingdanService.addLogisticsAndUpdateStatus(logistics);
        return "添加成功";
    }

    // 修改订单信息
    @PostMapping("editorder")
    @ApiOperation(value = "修改订单信息")
    public String editupdateorder(int id, String recevier, String recevierAddress, long receviePhone) {
        dingdanService.editOrder(id, recevier, recevierAddress, receviePhone);
        return "修改成功";
    }

    //按id查找订单信息
    @GetMapping("getorderbyid")
    @ApiOperation(value = "按id查找订单信息")
    public dingdan getOrderById(int id) {
        dingdan dingdan = dingdanService.getOrderById(id);
        return dingdan;
    }

    //按id删除订单信息
    @GetMapping("deletebyid")
    @ApiOperation(value = "按id删除订单信息")
    public String deleteById(int id) {
        dingdanService.deleteOrderById(id);
        return "成功";
    }

    //展示订单信息
    @GetMapping("getallorders")
    @ApiOperation(value = "展示订单信息")
    public Map<String, Object> getAllOrder() {
        Map<String, Object> map = new HashMap<>();
        List<dingdan> list = dingdanService.getAllorder();
        map.put("code", "0");
        map.put("count", list.size());
        map.put("data", list);
        return map;
    }

    //通过id查找历史订单信息
    @GetMapping("gethistoryorderbyid")
    @ApiOperation(value = "通过id查找历史订单信息")
    public historyorder getHistoryOrderById(int id) {
        historyorder historyorder = dingdanService.getHistoryorderById(id);
        return historyorder;
    }

    // 展示所有历史订单信息
    @GetMapping("getallhistoryorders")
    @ApiOperation(value = "展示所有历史订单信息")
    public Map<String, Object> getAllHistoryOrder() {
        Map<String, Object> map = new HashMap<>();
        List<historyorder> list = dingdanService.getAllHistoryorder();
        map.put("code", "0");
        map.put("count", list.size());
        map.put("data", list);
        return map;
    }
}
