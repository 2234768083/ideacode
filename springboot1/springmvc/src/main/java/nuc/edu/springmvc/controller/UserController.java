package nuc.edu.springmvc.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import io.swagger.models.auth.In;
import nuc.edu.springmvc.entity.User;
import nuc.edu.springmvc.exceptionhandler.ZdException;
import nuc.edu.springmvc.util.Res;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.util.*;

/**
 * @author hongjun
 * @create 2020-10-06 9:57
 */
@Controller
public class UserController {

    @RequestMapping(value = "/table", method = RequestMethod.GET)
    public ModelAndView query(){
        System.out.println("测试访问");
        List<User> userList=new ArrayList<User>();
        User user1=new User();
        user1.setId(1);
        user1.setName("phone");
        User user2=new User();
        user2.setId(2);
        user2.setName("computer");
        userList.add(user1);
        userList.add(user2);
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("table");
        return modelAndView;
    }
    @RequestMapping("/table1")
    public String query(Model model){
        System.out.println("测试访问");
        List<User> userList=new ArrayList<User>();
        User user1=new User();
        user1.setId(1);
        user1.setName("phone");
        User user2=new User();
        user2.setId(2);
        user2.setName("computer");
        userList.add(user1);
        userList.add(user2);
        model.addAttribute("userList",userList);
        return "table";
    }
    @ModelAttribute
    public void  userModel(String loginname,String password,Model model){
        User user=new User();
        user.setName(loginname);
        user.setPassword(password);
        model.addAttribute("user",user);
    }
    @RequestMapping("/login")

    public String getUser(Model model){
        User user = (User)model.asMap().get("user");
        System.out.println(user);
        return  "result.html";
    }

    /*无注解获取参数
    * */
    @RequestMapping("/list")
    @ResponseBody
    public List<User> querylist(String name){
        List<User> userList=new ArrayList<User>();
        List<User> list=new ArrayList<User>();
        User user1=new User();
        user1.setId(1);
        user1.setName("phone");
        User user2=new User();
        user2.setId(2);
        user2.setName("computer");
        list.add(user1);
        list.add(user2);
        for (User user:list
             ) {
            if(user.getName().equals(name)){
                userList.add(user);
            }
        }
        return userList;
    }

    /*注解获取参数
    默认value属性
    required参数是否是必选项
     * */
    @RequestMapping(value = "/query1")
    @ResponseBody
    public User query1(@RequestParam(value = "id") Integer id,@RequestParam("sname") String name){
        User user=new User();
        user.setId(id);
        user.setName(name);
        return user;
    }
    /*
    * 传递数组
    * */
    @GetMapping("/arr")
    @ResponseBody
    public Map<String ,Object> getarr(Integer[] num,String[] str){
        Map<String,Object> paramMap=new HashMap<>();
        paramMap.put("numarr",num);
        paramMap.put("strarr",str);
        return paramMap;
    }



    /*
    * json传递数据
    * */
    @RequestMapping("/insert")
    @ResponseBody
    public User insert(@RequestBody User user){
        System.out.println(user);
        return user;
    }





    @RequestMapping("/pojo")
    public String validatepage(){
        return "pojo";
    }

    @RequestMapping("/validate")
    @ResponseBody
    public  Map<String,Object> validate(@Validated @RequestBody User user, Errors errors){
        Map<String,Object> errmap=new HashMap<>();
        List<ObjectError> oes=errors.getAllErrors();
        for (ObjectError err: oes
             ) {
            String key=null;
            String msg=null;
            if(err instanceof FieldError){
                FieldError fe=(FieldError) err;
                key=fe.getField(); //获取错误验证字段名
            }else{
                key=err.getObjectName();//获取验证字段名称
            }
            //获取错误消息
            msg=err.getDefaultMessage();
            errmap.put(key,msg);
        }
        return errmap;
    }


    /*
     * RESTFUL风格
     * */
    @GetMapping("/rest/{sid}")
    @ResponseBody
    public Integer rest(@PathVariable Integer sid){
        return sid;
    }
    @GetMapping("/rest/{sid}/{sname}")
    @ResponseBody
    public Map<String,Object> multiparam(@PathVariable Integer sid, @PathVariable String sname){
        Map<String,Object> map=new HashMap<>();
        map.put("学号",sid);
        map.put("姓名",sname);
        return map;
    }
    @PutMapping("/user/{id}")
    @ResponseBody
    public User updateUser(@PathVariable("id") Integer id){
        User user=new User();
        user.setId(id);
        user.setName("hongjun");
        return user;
    }
    @PatchMapping("/user/{id}/{name}")
    @ResponseBody
    public User changeUser(@PathVariable("id") Integer id,@PathVariable("name") String name){
        User user=new User();
        user.setId(id);
        user.setName(name);
        return user;
    }
    @DeleteMapping("/user/{id}")
    @ResponseBody
    public List<User> delete(@PathVariable("id") Integer id){
        List<User> userList=new ArrayList<User>();
        User user1=new User();
        user1.setId(1);
        user1.setName("phone");
        User user2=new User();
        user2.setId(2);
        user2.setName("computer");
        userList.add(user1);
        userList.add(user2);
        for (int i=0;i<userList.size();i++){
            if(userList.get(i).getId()==id){
                userList.remove(i);
            }
        }
       return userList;
    }

    @RequestMapping("/testUpLoad")
    @ResponseBody
    public Res testUpLoad(HttpServletRequest req, @RequestParam("file") MultipartFile file, Model m) {
        try {
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            String destFileName = req.getServletContext().getRealPath("") + "uploaded" + File.separator + fileName;
            System.out.println(destFileName);
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            file.transferTo(destFile);
        } catch (Exception e) {
            System.out.println("文件没有找到啊！！");
            return Res.error();
        }
        return Res.ok();
    }
    @RequestMapping("/multiuploadPage")
    public String multiuploadPage() {

        return "multiupload";

    }


    @PostMapping("/multitestUpLoad")
    @ResponseBody
    public Res multitestUpLoad(HttpServletRequest req,@RequestParam("filename")  MultipartFile[] filename) {
        String uploadDir = req.getServletContext().getRealPath("") + "uploaded/";
        System.out.println(uploadDir);
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdir();
        }
        try {
            for (MultipartFile multiFile : filename) {
                if(!multiFile.isEmpty()){
                executeUpload(uploadDir, multiFile);}
            }

        } catch (Exception e) {
           e.printStackTrace();
            return Res.error();
        }

        return Res.ok();
    }
    private void executeUpload(String uploadDir, MultipartFile file) throws Exception {
        System.out.println("执行文件上传");
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String filename = UUID.randomUUID() + suffix;
        File serverFile = new File(uploadDir + filename);
        file.transferTo(serverFile);
    }



    /*
     * 数据格式化
     * */

    @RequestMapping("/date")
    public @ResponseBody String printDate(String dateStr) {
        //String dateStr = "2020/10/01";
        Date date=DateUtil.parseDate(dateStr);
        //结果 ****/**/**
        String format = DateUtil.format(date, "yyyy/MM/dd");
        return format;
       //常用格式的格式化，结果：2017-03-01
      /* String formatDate = DateUtil.formatDate(date);
       return formatDate;*/
        //结果：2017-03-01 00:00:00
        /*String formatDateTime = DateUtil.formatDateTime(date);
        return formatDateTime;*/
        //结果：00:00:00
       /* String formatTime = DateUtil.formatTime(date);
        return formatTime;*/
    }

    @GetMapping("/exception")
    public void exceptionpost(){
       // Integer res1= Integer.valueOf("abc");
       // int res2=10/0;
        //throw  new ZdException(201,"用户自定义异常");
    }
}

