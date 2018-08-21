package com.liuzx.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketMangerment_Queue implements Runnable {

	private   int  lastnum;
	private   int salenum;
	public BlockingQueue<Integer> queue;
	public Lock lock;

	public TicketMangerment_Queue(int lastnum, int salenum, LinkedBlockingQueue<Integer> queue) {
		// TODO Auto-generated constructor stub
		this.lastnum = lastnum;
		this.salenum = salenum;
		this.queue = queue;
	}

	public  int saleticket() {

		return lastnum - salenum;

	}

	@Override
	public  void run() {
		// TODO Auto-generated method stub
		if (lastnum >= salenum) {
			lastnum = this.saleticket();
			try {
				queue.put(lastnum);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "卖出了" + salenum + "张票，现在剩余票数：" + lastnum);
		} else if (lastnum < salenum && lastnum > 0) {
			try {
				queue.put(lastnum);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "余票不够，够票数：" + salenum + "现在剩余票数：" + lastnum);
		} else if (lastnum == 0) {
			try {
				queue.put(lastnum);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "票卖光了！！！！");
		}
	}
}
