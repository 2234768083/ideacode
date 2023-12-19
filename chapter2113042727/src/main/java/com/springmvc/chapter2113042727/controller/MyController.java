package com.springmvc.chapter2113042727.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/***import***/
@Controller
@RequestMapping("/my")
public class MyController {
    /**
     * 在无注解下获取参数，要求参数名称和HTTP请求参数名称一致.
     13
     * @param intVal-- 整数
     * @param longVal-- 长整形
     * @param str--字符串
     * @return 响应JSON参数
     */

    @GetMapping("/no/annotation")
    @ResponseBody
    public Map<String, Object> noAnnotation(Integer intVal, Long longVal,
                                            String str) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("intVal", intVal);
        paramsMap.put("longVal", longVal);
        paramsMap.put("str", str);
        return paramsMap;
    }
    @RequestMapping("/annotation")
    @ResponseBody
    public Map<String, Object> requestParam(@RequestParam("int_Val")
                                            Integer intVal,
                                            @RequestParam("long_Val") Long longVal,
                                            @RequestParam("str_Val") String str) {
        Map<String, Object> paramsMap = new HashMap();
        paramsMap.put("intVal", intVal);
        paramsMap.put("longVal", longVal);
        paramsMap.put("str", str);
        return paramsMap;
    }
    @RequestMapping("/requestArray")
    @ResponseBody
    public Map<String, Object> requestArray(Integer [] intArr,
                                            Long [] longArr, String [] strArr) {
        Map<String, Object> paramsMap = new HashMap();
        paramsMap.put("intArr", intArr);
        paramsMap.put("longArr", longArr);
        paramsMap.put("strArr", strArr);
        return paramsMap;
    }
}
