package com.mysoft;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@ContextConfiguration("classpath:applicationContext.xml")
@TestExecutionListeners(inheritListeners = false)
public class MathServiceImplTest extends AbstractTestNGSpringContextTests {

	@BeforeClass
	public void beforeClass() {
		System.out.println("1.beforeClass()::applicationContext :"+applicationContext);
		//applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@AfterClass
	public void afterClassLoad() {
		//applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("5.afterClassLoad()::applicationContext :"+applicationContext);
		applicationContext=null;
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("2.beforeTest()::applicationContext :"+applicationContext);
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test(priority=1)
	public void sum() {
		System.out.println("4.Executing test case");
		MathService mathService = applicationContext.getBean(MathService.class);
		Assert.assertEquals(mathService.sum(10, 20), 30);
	}
	
	@Test(priority=2)
	public void sum1() {
		System.out.println("5.Executing test case");
		MathService mathService = applicationContext.getBean(MathService.class);
		Assert.assertEquals(mathService.sum(10, -20), -10);
	}
	
	@Test(priority=3)
	public void sum2() {
		System.out.println("6.Executing test case");
		MathService mathService = applicationContext.getBean(MathService.class);
		Assert.assertEquals(mathService.sum(0, 20), 20);
	}
}
