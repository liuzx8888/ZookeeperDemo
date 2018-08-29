package com.liuzx.reflect;

public class Person {

	private String name;
	private int age;
	private String sex;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
	public void print() {
		System.out.println("Person [name=" + name + ",  sex=" + sex + "]");
	}

}
