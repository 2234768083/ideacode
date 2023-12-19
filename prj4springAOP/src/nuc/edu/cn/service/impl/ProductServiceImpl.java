package nuc.edu.cn.service.impl;

import org.springframework.stereotype.Component;

import nuc.edu.cn.service.IProductService;

@Component("productService")
public class ProductServiceImpl implements IProductService {
	//实现方法browse，模拟某用户浏览商品
	@Override
	public void browse(String loginName, String productName) {
		// TODO Auto-generated method stub
		System.out.println("执行browse方法");

		// 测试异常通知
  //     throw new RuntimeException("这是特意抛出的异常信息");
		
		//测试环绕通知，通过while循环延长方法的执行时间
	    int i=100000000;
	    while(i>0) {
	    	i--;
	    }
	}

}
