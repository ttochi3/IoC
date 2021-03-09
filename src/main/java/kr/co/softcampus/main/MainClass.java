package kr.co.softcampus.main;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import kr.co.softcampus.beans.TestBean;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test1();
		//test2();
		//test3();
		test4();
	}
	
	// BeanFactory - 패키지 내부의 beans.xml 을 통해 t1 호출,
	public static void test1() {
		ClassPathResource res = new ClassPathResource("kr/co/softcampus/config/beans.xml");
		XmlBeanFactory factory = new XmlBeanFactory(res);
		
		 //t1 객체생성 및 호출.
		TestBean t1 = factory.getBean("t1", TestBean.class);
		System.out.printf("t1 : %s\n", t1);
		
		TestBean t2 = factory.getBean("t1", TestBean.class);
		System.out.printf("t2 : %s\n", t2);
	}
	
	// BeanFactory - 패키지 외부의 beans.xml 을 통해 t2 호출
	public static void test2() {
		FileSystemResource res = new FileSystemResource("beans.xml");
		XmlBeanFactory factory = new XmlBeanFactory(res);;

		 //t2 객체생성 및 호출.
		TestBean t1 = factory.getBean("t2", TestBean.class);
		System.out.printf("t1 : %s\n", t1);

		TestBean t2 = factory.getBean("t2", TestBean.class);
		System.out.printf("t2 : %s\n", t2);
	}
	
	// ApplicationContext - 패키지 내부의 beans.xml 을 통해 t1 호출
	public static void test3() {
		 //t1 객체생성.
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/softcampus/config/beans.xml");

		 //t1 호출.
		TestBean t1 = ctx.getBean("t1", TestBean.class);
		System.out.printf("t1 : %s\n", t1);

		TestBean t2 = ctx.getBean("t1", TestBean.class);
		System.out.printf("t2 : %s\n", t2);
		
		ctx.close();
	}

	// ApplicationContext - 패키지 외부의 beans.xml 을 통해 t2 호출.
	public static void test4() {
		 //t2 객체생성.
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");

		 //t2 호출.
		TestBean t1 = ctx.getBean("t2", TestBean.class);
		System.out.printf("t1 : %s\n", t1);

		TestBean t2 = ctx.getBean("t2", TestBean.class);
		System.out.printf("t2 : %s\n", t2);
		
		ctx.close();
	}
}
