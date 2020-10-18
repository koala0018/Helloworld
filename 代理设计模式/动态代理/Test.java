package com.oracle.demo6;

public class Test {
	public static void main(String[] args) {
		RealDemo rd = new RealDemo();
		Real real = new Real();
		MyProxy proxy = new MyProxy();
		Demo demo = (Demo)proxy.bind(rd);
		String str = demo.sayHello("zs", 19);
		System.out.println(str);
	}
}
