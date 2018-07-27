package com.liuzx.Thread;

public class SynchronizedDemo implements Runnable {

	private static int ticketnum = 0;
	public static int lastnum = 0;

	public SynchronizedDemo(int ticketnum) {
		// TODO Auto-generated constructor stub
		this.ticketnum = ticketnum;
	}
	/*
	 * 
	 * 方法锁
	 */
	/*
	 * public synchronized int saleticket() { return lastnum - ticketnum; }
	 */

	public int saleticket() {
		return lastnum - ticketnum;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		/*
		 * 
		 * 方法锁
		 */

		/*
		 * lastnum = this.saleticket(); if (lastnum > 0) {
		 * System.out.println(Thread.currentThread().getName() + "卖出" + ticketnum +
		 * "张,还剩余票数：" + lastnum); } else {
		 * System.out.println(Thread.currentThread().getName() + "票已卖光！！！"); }
		 */

		/*
		 * 同步代码块
		 */
		synchronized (this) {
			lastnum = this.saleticket();
			if (lastnum > 0) {
				System.out.println(Thread.currentThread().getName() + "卖出" + ticketnum + "张,还剩余票数：" + lastnum);
			} else {
				System.out.println(Thread.currentThread().getName() + "票已卖光！！！");
			}
		}

	}

}
