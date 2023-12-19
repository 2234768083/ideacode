package com.example.mongodb.controller;

import com.example.mongodb.entity.Commodity;
import com.example.mongodb.entity.Logistics;
import com.example.mongodb.service.CommodityService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 商品Con
 */
@RestController
@RequestMapping("commodity")
public class CommodityController {
    @Resource
    private CommodityService commodityService;

    /**
     * 添加商品
     */
    @PostMapping("addcommodity")
    public String addCommodity(Commodity commodity) {
        commodityService.addCommodity(commodity);
        return "添加成功";
    }


    /**
     * 查询所有商品
     */
    @GetMapping("list")
    public Map<String, Object> selectCommodityList() {

        return commodityService.selectCommodityList();

    }

    /**
     * 根据ID查询商品
     */
    @PostMapping("add")
    public String  SelectByIdToCar(String cid,String uid) {
        commodityService.SelectByIdToCar(cid,uid);
        return "购买成功！";
    }

    /**
     * 删除商品
     */
    @PostMapping("dele")
    public String deleteCommodityById(String cid){
        commodityService.deleteCommodityById(cid);
        return "删除成功！！";
    }
    /**
     * 通过ID查询商品
     */
    @GetMapping("{cid}")
    public Commodity SelectOrderByID(@PathVariable String cid){

        return commodityService.selectCarByID(cid);
    }

    /**
     * 修改商品
     */
    @PostMapping("update")
    public String updateOrderAddLogistics(String name,Integer price,String firm,String profile,String cid){
        commodityService.UpdateComById(name,price,firm,profile,cid);
        return "物流添加成功";
    }
}
