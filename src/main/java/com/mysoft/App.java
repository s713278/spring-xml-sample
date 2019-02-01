package com.mysoft;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    	MathService mathService = ctx.getBean(MathService.class);
    	System.out.println(mathService.sum(19, 90));
        
    }
}
