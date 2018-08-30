package com.liuzx.reflect;

public class Person  {
	String name;
	int    age;
	String sex;	

	public Person() {
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
	public void print() {
		System.out.println("Person [name=" + name + ",  sex=" + sex + "]");
	}
	

}
