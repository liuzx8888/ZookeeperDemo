package com.liuzx.Thread;

public class RunableDemo1 implements Runnable {
	public String name;

	public RunableDemo1(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName() +"-----"+ name);
		}
	}

	public static void main(String[] args) {
		RunableDemo1 demo1 = new RunableDemo1("a");
		RunableDemo1 demo2 = new RunableDemo1("b");

		Thread thread1 = new Thread(demo1, "11");
		Thread thread2 = new Thread(demo2, "22");
		thread1.start();
		thread2.start();

	}

}
