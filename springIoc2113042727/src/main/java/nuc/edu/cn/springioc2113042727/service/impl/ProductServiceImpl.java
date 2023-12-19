package nuc.edu.cn.springioc2113042727.service.impl;

import nuc.edu.cn.service.IProductService;
import org.springframework.stereotype.Component;

@Component("productService")
public class ProductServiceImpl implements IProductService {
    public void browse(String loginName, String productName) {

        System.out.println("ִbrowse方法被调用");
 //       throw new RuntimeException("这是为测试抛出异常");
        int i = 100000000;
        while (i > 0) {
           i--;
       }
   }
}
