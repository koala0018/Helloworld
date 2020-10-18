package com.oracle.demo7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FruitFactory {

	public static void createFruit(String className) throws Exception{
		Class c = null;
		c = Class.forName(className);
		Method m = c.getMethod("created", null);
		m.invoke(c.newInstance(), null);
		
	}
}
