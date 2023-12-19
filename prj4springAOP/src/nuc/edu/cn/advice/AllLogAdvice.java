package nuc.edu.cn.advice;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * ���������࣬�ڴ����б�д֪ͨ
 */
@Aspect
@Component
public class AllLogAdvice {
	// �����������ʽ
	@Pointcut("execution(* nuc.edu.cn.service.IProductService.*(..))")
	// ʹ��һ������ֵΪvoid��������Ϊ�յķ��������������
	private void allMethod() {

	}

	// �˷�������Ϊǰ��֪ͨ
	@Before("allMethod()")
	public void myBeforeAdvice(JoinPoint joinPoint) {
		// ��ȡ��������,JoinPoint�������������ӵ㷽��������״̬�����Ի�ȡ��ԭʼ�����ĵ��ò�����
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		// ��־��ʽ�ַ���
		String loginInfoText = "ǰ��֪ͨ:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "  "
				+ args.get(0).toString() + "  �����Ʒ " + args.get(1).toString();
		// ����־��Ϣ���������̨
		System.out.println(loginInfoText);
	}

	// �˷�������Ϊ����֪ͨ
	@After("allMethod()")
	public void myAfterAdvice(JoinPoint joinPoint) {
		// ��ȡ��������
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		// ��־��ʽ�ַ���
		String loginInfoText = "����֪ͨ:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "  "
				+ args.get(0).toString() + "  �����Ʒ " + args.get(1).toString();
		// ����־��Ϣ���������̨
		System.out.println(loginInfoText);
	}

	// �˷�������Ϊ����֪ͨ
	@AfterReturning("allMethod()")
	public void myAfterReturnAdvice(JoinPoint joinPoint) {
		// ��ȡ��������
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		// ��־��ʽ�ַ���
		String loginInfoText = "����֪ͨ:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "  "
				+ args.get(0).toString() + "  �����Ʒ " + args.get(1).toString();
		// ����־��Ϣ���������̨
		System.out.println(loginInfoText);
	}

	// �˷�������Ϊ�쳣֪ͨ
	@AfterThrowing(pointcut = "allMethod()", throwing = "e")
	public void myThrowingAdvice(JoinPoint joinPoint, Exception e) {
		// ��ȡ�����õ�����
		String targetClassName = joinPoint.getTarget().getClass().getName();
		// ��ȡ�����õķ�����
		String targetMethodName = joinPoint.getSignature().getName();
		// ��־��ʽ�ַ���
		String loginInfoText = "�쳣֪ͨ: ִ��" + targetClassName + " ��� " + targetMethodName + "  ����ʱ�����쳣 ";
		// ����־��Ϣ���������̨
		System.out.println(loginInfoText);
	}

	// �˷�������Ϊ����֪ͨ
	@Around("allMethod()")
	public void myAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		long beginTime = System.currentTimeMillis();
		joinPoint.proceed();
		long endTime = System.currentTimeMillis();
		String targetMethodName = joinPoint.getSignature().getName();
		// ��־��ʽ�ַ���
		String loginInfoText = "����֪ͨ: " + targetMethodName + " ��������ǰʱ�� " + beginTime + "����, " + "  �������ú�ʱ�� " + endTime
				+ "����. ";
		// ����־��Ϣ���������̨
		System.out.println(loginInfoText);
	}

}
