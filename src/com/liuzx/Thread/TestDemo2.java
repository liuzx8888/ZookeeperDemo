package com.liuzx.Thread;

import java.util.Random;

public class TestDemo2 {

	public static void main(String[] args) throws InterruptedException {

		SynchronizedDemo.lastnum = 500;

		for (int i = 100; i > 0; i--) {
			SynchronizedDemo demo = new SynchronizedDemo((int) (Math.random() * 5));
	        
			Thread thread1 = new Thread(demo, "´°¿Ú1");
			thread1.start();
			thread1.sleep(500);
			Thread thread2 = new Thread(demo, "´°¿Ú2");
			thread2.start();
			thread1.sleep(300);
			Thread thread3 = new Thread(demo, "´°¿Ú3");
			thread3.start();
			thread1.sleep(400);
			System.out.println(i);
		}
	}
}
