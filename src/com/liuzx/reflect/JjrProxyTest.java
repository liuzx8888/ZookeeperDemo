package com.liuzx.reflect;

public class JjrProxyTest {
	public static void main(String[] args) {
		JingJiRen jingJiRen  = new JingJiRen();
		PersonInter ldh = jingJiRen.MxProxy("���»�", 10000);
		String str =ldh.sing("���»�", "����");
		System.out.println(str);
		
		PersonInter lzx = jingJiRen.MxProxy("��־��", 20000);	
		String str1 =lzx.dance("��־��", "С���");
		System.out.println(str1);
	}

}
