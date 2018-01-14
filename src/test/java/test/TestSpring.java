package test;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.yl.oa.test.TestAction;
import cn.yl.oa.test.TestService;
import cn.yl.oa.test.User;

public class TestSpring {
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	@Test
	public void testSpring() {
		SessionFactory sf = ac.getBean("sessionFactory",SessionFactory.class);
		System.out.println(sf);
	}
	@Test
	public void testTransaction() {
		TestService testService = (TestService)ac.getBean("testService");
		testService.saveTwoUsers();
	}
}
