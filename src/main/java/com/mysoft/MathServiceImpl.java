package com.mysoft;

public class MathServiceImpl implements MathService {

	public int sum(int a, int b) {
		System.out.println("a = "+a);
		System.out.println("b = "+b);
		return a+b;
	}

	
}
