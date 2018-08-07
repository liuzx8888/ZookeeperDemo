package com.liuzx.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketClient {

	public static void main(String[] args) {
		TicketMangerment.lastnum = 100;
		Lock lock = new ReentrantLock();

		new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				Boolean trylock = lock.tryLock();
				if (trylock) {
					for (int i = 0; i < 100; i++) {
						int ticknum = (int) ((Math.random()) * 5) + 1;
						TicketMangerment mangerment = new TicketMangerment(ticknum);
						Thread thread = new Thread(mangerment, "ck1");
						thread.start();
						try {
							thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				Boolean trylock = lock.tryLock();
				if (trylock) {
					for (int i = 0; i < 100; i++) {
						int ticknum = (int) ((Math.random()) * 5) + 1;
						TicketMangerment mangerment = new TicketMangerment(ticknum);
						Thread thread = new Thread(mangerment, "ck2");
						thread.start();
						try {
							thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

			}
		}.start();

		/*
		 * for (int i = 0; i < 100; i++) { trylock = lock.tryLock(); if (trylock) try {
		 * int ticknum = (int) ((Math.random()) * 5) + 1; TicketMangerment mangerment =
		 * new TicketMangerment(ticknum); Thread thread1 = new Thread(mangerment,
		 * "ck1"); thread1.start(); thread1.sleep(1000);
		 * 
		 * } catch (Exception e) { // TODO: handle exception } finally { lock.unlock();
		 * } }
		 * 
		 * trylock = lock.tryLock(); for (int i = 0; i < 100; i++) {
		 * 
		 * if (trylock) try { int ticknum = (int) ((Math.random()) * 5) + 1; Thread
		 * thread2 = new Thread(new TicketMangerment(ticknum), "ck2"); if (trylock) {
		 * thread2.start(); thread2.sleep(2000); } } catch (Exception e) { // TODO:
		 * handle exception } finally { lock.unlock(); } }
		 */
	}

}