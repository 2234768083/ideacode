package nuc.edu.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hongjun
 * @create 2020-10-23 7:54
 */
@Controller
public class helloController {

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "hello spring boot!";
    }

}

