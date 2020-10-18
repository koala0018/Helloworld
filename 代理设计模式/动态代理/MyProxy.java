package com.oracle.demo6;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy implements InvocationHandler{

	//定义一个Object类型的属性，代表真实主题实现类的对象,由于真实主题实现类我们不知道具体是哪一个类型，所以我们统一使用Object进行接收
	private Object obj;
	//自定义一个方法，用来将属性与真实主题实现类与代理对象进行绑定
	public Object bind(Object obj){
		//对属性进行赋值
		this.obj=obj;
		//创建代理对象,创建代理对象的时候需要有三个参数，第一个是类加载器，第二个是真实主题实现类实现的全部的接口，第三个是InvocationHandler的子类对象
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}
	//重写InvocationHandler接口的方法，此方法是一个回调方法，当代理对象调用方法的时候，就会执行此方法中的代码
	//此方法有三个参数，1.代理对象 2.当前正在执行的方法的对象 3.当前正在执行的方法的参数
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//通过真实主题实现类对象执行当前的方法
		Object temp = method.invoke(this.obj, args);
		return temp;
	}

}
