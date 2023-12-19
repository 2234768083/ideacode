package com.example.springboot.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.entity.Goods;
import com.example.springboot.service.IGoodsService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.common.Result;
import org.springframework.web.multipart.MultipartFile;
import com.example.springboot.entity.User;
import com.example.springboot.utils.TokenUtils;

import com.example.springboot.service.ICartService;
import com.example.springboot.entity.Cart;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2023-01-18
 */
@RestController
@RequestMapping("/cart")
public class CartController {

    @Resource
    private ICartService cartService;
    @Resource
    private IGoodsService goodsService;

    private final String now = DateUtil.now();

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody Cart cart) {
        if (cart.getId() == null) {
            //cart.setTime(DateUtil.now());
            //cart.setUser(TokenUtils.getCurrentUser().getUsername());
        }
        cartService.saveOrUpdate(cart);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        cartService.removeById(id);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        cartService.removeByIds(ids);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        List<Cart> list = cartService.list();
        for (Cart cart : list) {
            Goods goods = goodsService.getById(cart.getGoodsId());
            cart.setGoodName(goods.getName());
            cart.setImg(goods.getImg());
            cart.setPrice(goods.getPrice());
        }
        return Result.success(list);
    }

    @GetMapping("/personCart")
    public Result personCart() {
        BigDecimal total = new BigDecimal(0);
        List<Cart> list = cartService.list();
        for (Cart cart : list) {
            Goods goods = goodsService.getById(cart.getGoodsId());
            cart.setGoodName(goods.getName());
            cart.setImg(goods.getImg());
            cart.setPrice(goods.getPrice());
            total = total.add(goods.getPrice().multiply(BigDecimal.valueOf(cart.getNum())));
        }
        Dict dict = Dict.create().set("list", list).set("total", total);
        return Result.success(dict);
    }

    @PostMapping("/cal")
    public Result cal(@RequestBody List<Cart> carts) {
        BigDecimal total = new BigDecimal(0);
        for (Cart cart : carts) {
            Goods goods = goodsService.getById(cart.getGoodsId());
            total = total.add(goods.getPrice().multiply(BigDecimal.valueOf(cart.getNum())));
        }
        return Result.success(total);
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(cartService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam(defaultValue = "") String name,
                           @RequestParam Integer pageNum,
                           @RequestParam Integer pageSize) {
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        if (!"".equals(name)) {
            queryWrapper.like("name", name);
        }
        User currentUser = TokenUtils.getCurrentUser();
        if (currentUser.getRole().equals("ROLE_USER")) {
            queryWrapper.eq("userid", currentUser.getId());
        }
        Page<Cart> page = cartService.page(new Page<>(pageNum, pageSize), queryWrapper);
        List<Cart> records = page.getRecords();
        for (Cart record : records) {
            Goods goods = goodsService.getById(record.getGoodsId());
            record.setGoodName(goods.getName());
            record.setImg(goods.getImg());
            record.setPrice(goods.getPrice());
        }
        return Result.success(page);
    }

    /**
    * 导出接口
    */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<Cart> list = cartService.list();
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);

        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("Cart信息表", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();

        }

    /**
     * excel 导入
     * @param file
     * @throws Exception
     */
    @PostMapping("/import")
    public Result imp(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        // 通过 javabean的方式读取Excel内的对象，但是要求表头必须是英文，跟javabean的属性要对应起来
        List<Cart> list = reader.readAll(Cart.class);

        cartService.saveBatch(list);
        return Result.success();
    }

    private User getUser() {
        return TokenUtils.getCurrentUser();
    }

}

