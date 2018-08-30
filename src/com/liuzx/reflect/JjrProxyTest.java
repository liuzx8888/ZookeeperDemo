package com.liuzx.reflect;

public class JjrProxyTest {
	public static void main(String[] args) {
		JingJiRen jingJiRen  = new JingJiRen();
		PersonInter ldh = jingJiRen.MxProxy("刘德华", 10000);
		String str =ldh.sing("刘德华", "冰雨");
		System.out.println(str);
		
		PersonInter lzx = jingJiRen.MxProxy("罗志祥", 20000);	
		String str1 =lzx.dance("罗志祥", "小天鹅");
		System.out.println(str1);
	}

}
