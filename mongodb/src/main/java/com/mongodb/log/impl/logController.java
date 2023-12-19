package com.mongodb.log.impl;


import com.mongodb.pojo.LogBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 日志管理控制器
 */
@RestController
@Api(tags = "日志管理")
public class logController {
    @Autowired
    com.mongodb.log.logService logService;

    //展示日志信息
    @GetMapping("getalllog")
    @ApiOperation(value = "mongodb日志展示")
    public Map<String, Object> getAlllogr() {
        Map<String, Object> map = new HashMap<>();
        List<LogBean> list = logService.findlog();
        map.put("code", "0");
        map.put("count", list.size());
        map.put("data", list);
        return map;
    }
}
