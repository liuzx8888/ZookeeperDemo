package com.liuzx.Thread;

import java.util.Random;

public class TestDemo {

	public static void main(String[] args) throws InterruptedException {
         

		SynchronizedDemo.lastnum=500 ;
		for (int i = 3; i > 0; i--) {

		//	Thread thread1 = new Thread(new SynchronizedDemo(SynchronizedDemo.lastnum,1) ,"´°¿Ú1");
			//Thread thread2 = new Thread(new SynchronizedDemo(j,1) ,"´°¿Ú2");
			//thread1.start();
			//thread2.start();
			//j =SynchronizedDemo.lastnum;
		}
	}
}
