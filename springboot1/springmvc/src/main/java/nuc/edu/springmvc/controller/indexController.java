package nuc.edu.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author hongjun
 * @create 2020-10-21 17:44
 */
@Controller
public class indexController {
    @RequestMapping({"/index", "/"})
    public String index(){
        return "index";
    }
    @RequestMapping("/hello")
    public String sayHello(Model model){
        model.addAttribute("name","hongjun");
        return "index.html";

    }
    @RequestMapping("/hellomv")
    public ModelAndView sayHello(ModelAndView mv){
        mv.addObject("name","hongjun");
        mv.setViewName("index.html");
        return mv;

    }
}
