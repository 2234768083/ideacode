package nuc.edu;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import nuc.edu.entity.User;
import nuc.edu.mapper.UserMapper;
import org.apache.velocity.runtime.directive.Foreach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author hongjun
 * @create 2020-12-09 8:05
 */
@SpringBootTest
public class mybtisTest {

    @Test
    public void generatorCode(){
        //创建generator对象
        AutoGenerator mpg = new AutoGenerator();

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl("jdbc:mysql://localhost:3306/mybatis-plus?serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("hongjun");
        mpg.setDataSource(dsc);
        //全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setOpen(false);//是否打开文件夹
        gc.setAuthor("洪军");
        mpg.setGlobalConfig(gc);
        //包信息
        PackageConfig packageConfig=new PackageConfig();
        packageConfig.setParent("nuc.edu");
        packageConfig.setController("controller");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setMapper("mapper");
        packageConfig.setEntity("entity");
        mpg.setPackageInfo(packageConfig);
        //配置策略
        StrategyConfig strategy = new StrategyConfig();
        strategy.setEntityLombokModel(true);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setLogicDeleteFieldName("deleted");//逻辑删除属性名称

        //自动填充配置
        TableFill creatTime = new TableFill("creat_time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        List<TableFill> tableFills=new ArrayList<TableFill>();
        tableFills.add(creatTime);
        tableFills.add(updateTime);
        strategy.setTableFillList(tableFills);//表填充字段

        strategy.setEntityTableFieldAnnotationEnable(true);//是否生成实体时，生成字段注解
        strategy.setVersionFieldName("version");  //乐观锁
        strategy.setControllerMappingHyphenStyle(true);//驼峰转连字符
        mpg.setStrategy(strategy);
        mpg.execute();

    }
    @Autowired
    UserMapper userMapper;

    /*查询user表所有用户*/
    @Test
    public void findAllUser(){
        List<User> userList = userMapper.selectList(null);
        for (User user: userList
             ) {
            System.out.println(user);
        }
    }
    /*
    * 插入一条user数据
    * */
    @Test
    public void insertUser(){
        User user=new User();
        user.setName("yyyy");
        user.setAge(81);
        user.setEmail("yyyy@nuc.edu.cn");
        //原始设置方式
        /*user.setCreateTime(new Date());
        user.setUpdateTime(new Date());*/
        int insert = userMapper.insert(user);
        System.out.println("insert:"+insert);
    }
    //按照用户id更新用户数据
    @Test
    public void updateById(){
        User user=new User();
        user.setId(1L);
        user.setAge(88);
       int result= userMapper.updateById(user);
        System.out.println("result:"+result);
    }

    //测试乐观锁
    @Test
    public void testOptimisticLocker(){
        //根据id查询数据

        User user = userMapper.selectById(1L);
        // 进行修改
        user.setAge(200);
        userMapper.updateById(user);


    }
    //根据id查询用户信息
    @Test
    public void testSelectbyUserId(){
        User user = userMapper.selectById(1l);
        System.out.println(user);
    }
    //测试id批量查询
    @Test
    public void testSelectMany(){
        List<User> userList = userMapper.selectBatchIds(Arrays.asList(1,2));
        System.out.println(userList);
    }

    //测试分页功能
    @Test
    public void testPage(){
        //1 创建page对象,传入当前页，及每页记录数

        Page<User> page= new Page<>(1,3);
        // 调用MP中的分页查询方法,把分页所有数据封装到page对象里面
        userMapper.selectPage(page,null);
        //通过page对象获取分页数据
        System.out.println(page.getCurrent()); //当前页
        System.out.println(page.getRecords());//每页数据list集合
        System.out.println(page.getTotal());//总记录数
        System.out.println(page.getSize());//每页显示记录数
        System.out.println(page.getPages()); //总页数
        System.out.println(page.hasNext());//是否有下一页
        System.out.println(page.hasPrevious());//是否有上一页


    }
    //逻辑删除测试
    @Test
    public void testDeleteById(){
        int result = userMapper.deleteById(1336504709690146818l);
        System.out.println(result);
    }
    //批量删除
    @Test
    public void testDeleteByIds(){
        int result = userMapper.deleteBatchIds(Arrays.asList(5,6,7));
        System.out.println(result);
    }
    //mp实现条件查询
    @Test
    public void testSelectQuery() {
        //创建对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //ge、gt、le、lt
        //wrapper.ge("age",25);

        //eq ne
        wrapper.eq("name","hyq");
        //between notbetween
        // wrapper.between("age",21,41);
        //like
        //wrapper.like("name","h");
        //orderby
//wrapper.orderByDesc("age");

        //last
        //wrapper.last("limit 1");
        List<User> userList = userMapper.selectList(wrapper);
        System.out.println(userList);

    }

    @Test
    public void testOnetoOne(){
        List<User> userList=userMapper.findUserAndOrder();
        System.out.println(userList);
    }
}
