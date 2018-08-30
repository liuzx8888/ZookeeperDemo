package com.liuzx.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class TestPerson {
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		Person person = new Person();
		System.out.println(person.getClass().getName());
		Constructor<?>[] Cons = null;
		Method M1 = null;

		@SuppressWarnings("unchecked")
		Class<Person> C1 = (Class<Person>) Class.forName("com.liuzx.reflect.Person");

		Method[] Methods = C1.getMethods();
		for (int i = 0; i < Methods.length; i++) {
			System.out.println(Methods[i]);
		}

		Field[] Fields = C1.getDeclaredFields();
		for (int i = 0; i < Fields.length; i++) {
			System.out.println(Fields[i]);
		}

		Constructor<?>[] Constructors = C1.getConstructors();
		for (int i = 0; i < Constructors.length; i++) {
			System.out.println(Constructors[i]);
		}

		try {
			Cons = C1.getConstructors();
			Person person2 = (Person) Cons[1].newInstance("AAA", 30, "F");
			System.out.println(person2);
			M1 = C1.getMethod("print");
			M1.invoke(person2);

		} catch (SecurityException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
