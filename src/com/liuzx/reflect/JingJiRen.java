package com.liuzx.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JingJiRen {

	public PersonInter MxProxy(String name, int money) {
		PersonInter mx = new Mingxing(name);
		return (PersonInter) Proxy.newProxyInstance(

				mx.getClass().getClassLoader(), 
				//mx.getClass().getInterfaces(),
				new Class[] {PersonInter.class}, 
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// TODO Auto-generated method stub
						if (method.getName().equals("sing")) {
							System.out.println("����" + name + "������,�����븶��" + money);
							Thread.sleep(3000);
							System.out.println("�յ�" + money);							
							return method.invoke(mx, args);
						}
						
						
						if (method.getName().equals("dance")) {
							System.out.println("����" + name + "������,�����븶��" + money);
							Thread.sleep(2000);
							System.out.println("�յ�" + money);	
							return method.invoke(mx, args);
						}
						return null;
					}

				}

		);
	}

}
