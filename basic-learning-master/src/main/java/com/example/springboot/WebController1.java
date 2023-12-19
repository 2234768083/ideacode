package com.example.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/query")
@RestController
public class WebController1 {

    // 触发后台做某些操作
    @GetMapping("/")  //  /query/
    public void q1() {
        //  更新数据
        // 删除数据
        // 新增数据
    }

    @GetMapping("/q2")  //  /query/q2
    public Result q2() {
        return Result.success();
    }

    @GetMapping("/q3")  //  /query/q3?name=111
    public Result q3(@RequestParam String name) {
        return Result.success(name);  // 111
    }

    @GetMapping("/q4")
    public Result q4(@RequestParam Boolean bool) {
        return Result.success(bool);
    }

    @GetMapping("/q5")   // ?name=1122&birth=21211&num=111
    public Result q5(String name, String birth, Integer num) {
        return Result.success(name + ", " + birth + ", " + num);
    }

    @GetMapping("/q6/{hhh}")
    public Result q6(@PathVariable(name = "hhh") String name) {

        return Result.success(name);
    }

    @GetMapping("/q7/{name}/data")  // /q6/xxxx/data
    public Result q7(@PathVariable(name = "name") String name) {

        return Result.success(name);
    }

    @GetMapping("/q8")   // ?name=1122&brand=21211&price=111
    public Result q8(User user) {
        return Result.success(user);
    }

}
