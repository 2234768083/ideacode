package nuc.edu.cn.service.impl;

import org.springframework.stereotype.Component;

import nuc.edu.cn.service.IProductService;

@Component("productService")
public class ProductServiceImpl implements IProductService {
	//ʵ�ַ���browse��ģ��ĳ�û������Ʒ
	@Override
	public void browse(String loginName, String productName) {
		// TODO Auto-generated method stub
		System.out.println("ִ��browse����");

		// �����쳣֪ͨ
  //     throw new RuntimeException("���������׳����쳣��Ϣ");
		
		//���Ի���֪ͨ��ͨ��whileѭ���ӳ�������ִ��ʱ��
	    int i=100000000;
	    while(i>0) {
	    	i--;
	    }
	}

}
