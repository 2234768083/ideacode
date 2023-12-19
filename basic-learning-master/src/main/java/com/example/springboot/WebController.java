package com.example.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/web")
public class WebController {

//    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

    // 返回基本的字符串
    @GetMapping("/hello")
    public String hello() {
        return "你好世界";
    }

    // 自定义请求路径
    // 请求路径必须全英文，不要出现数字、符号
    @GetMapping("/nihao")
    public String nihao() {
        return "你好啊  亲哥哥哥";
    }

    // 返回数字
    @GetMapping("/num")
    public Integer num() {
        return 123;
    }

    // 返回布尔值
    @GetMapping("/bool")
    public boolean bool() {
        return true;
    }

    // 返回数组
    @GetMapping("/array")
    public String[] array() {
        return new String[]{"123", "465"};
    }

    @GetMapping("/array1")
    public Integer[] array1() {
        return new Integer[]{123, 456};
    }

    // json对象
    @GetMapping("/map")
    public Map<String, Object> map() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("name", "电脑");
        map.put("brand", "品牌");
        map.put("price", 4999);
        return map;
    }

    // json数组
    @GetMapping("/maps")
    public Map<String, Object>[] maps() {
        Map[] maps = new Map[2];
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("name", "电脑");
        map.put("brand", "品牌");
        map.put("price", 4999);
        maps[0] = map;
        maps[1] = map;
        return maps;
    }

    // 返回json对象
    @GetMapping("/bean")
    public User bean() {
        User user = new User();
        user.setName("电脑");
        user.setBrand("戴尔");
        user.setPrice(4999D);
        return user;
    }

    // list  返回json数组
    @GetMapping("/list")
    public List<User> list() {
        ArrayList<User> users = new ArrayList<>();
        User user = new User();
        user.setName("电脑");
        user.setBrand("戴尔");
        user.setPrice(4999D);
        users.add(user);
        users.add(user);
        users.add(user);
        return users;
    }

    // set  返回json数组
    @GetMapping("/set")
    public Set<User> set() {
        Set<User> users = new HashSet<>();
        User user = new User();
        user.setName("电脑");
        user.setBrand("戴尔");
        user.setPrice(4999D);
        users.add(user);
        users.add(user);
        users.add(user);
        return users;
    }

    @GetMapping("/getUser")
    public Result getUser() {
        User user = new User();
        user.setName("电脑");
        user.setBrand("戴尔");
        user.setPrice(4999D);
        user.setIsLeader(true);
        user.setNums(Collections.singletonList(1));

        User user1 = new User();
        user1.setName("小金鱼");
        user.setUser(user1);

        HashMap<String, Object> map = new HashMap<>();
        map.put("aaa", "亲哥哥哥");
        user.setMap(map);
        return Result.success(user);
    }

    @GetMapping("/getError")
    public Result getError() {
        log.info("我进来了 {} 方法，当前时间是 {}", "getError", LocalDateTime.now());
        try {
            int a = 1/0;  // 肯定报错
        } catch (Exception e) {
            log.error("getError方法出错了！", e);
//            return Result.error(e.getMessage());
        }
        log.warn("我是warn，warn 是啥样的？ 橙色的吗？");
        log.debug("我是debug，我看看我是啥样的");
        log.info("我出来了 getError 方法，当前时间是{}", LocalDateTime.now());
        return Result.success();
    }


    // SpringMVC 帮我们做了数据转换


}
