package com.liuzx.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketClient {

	public static void main(String[] args) {
		TicketMangerment.lastnum = 500;
		Lock lock = new ReentrantLock();

		for (int i = 0; i < 100; i++) {
			try {
				int ticknum=(int) ((Math.random()) * 5)+1;
				Thread thread1 = new Thread(new TicketMangerment(ticknum), "ck1");
				boolean trylock = lock.tryLock();
				if (trylock) {
					thread1.start();
					thread1.sleep(100);
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				lock.unlock();
			}
		}

		for (int i = 0; i < 100; i++) {
			try {
				int ticknum=(int) ((Math.random()) * 5)+1;
				Thread thread2 = new Thread(new TicketMangerment(ticknum), "ck2");
				boolean trylock = lock.tryLock();
				if (trylock) {
					thread2.start();
					thread2.sleep(200);
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				lock.unlock();
			}
		}
	}

}