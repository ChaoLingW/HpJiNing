package hpe.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hpe.bean.Order;
import hpe.bean.User;

public class TestUserOrder {

	@Test
	public void test() {
		Order order = new Order();
		User user = new User();
		user.setName("user1");
		user.setPwd("123");
		order.setOrderId("order1");
	}

	@Test
	public void test2() {
		
		ApplicationContext atx = new ClassPathXmlApplicationContext("bean.xml");
		
		Order order = atx.getBean(Order.class);
		
		System.out.println(order);
		
		
		
	}
}
