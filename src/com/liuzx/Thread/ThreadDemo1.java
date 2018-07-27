package com.liuzx.Thread;

public class ThreadDemo1 extends Thread {
	public String name;

	public ThreadDemo1(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();

		for (int i = 0; i < 10; i++) {
			System.out.println(i + name);
		}
	}

	public static void main(String[] args) {
		ThreadDemo1 threadDemo1 = new ThreadDemo1("aa");
		ThreadDemo1 threadDemo2 = new ThreadDemo1("bb");
		threadDemo1.start();
		threadDemo2.start();
	}

}
