package com.liuzx.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketClient_Queue {
	static int lastnum = 500;
	static volatile int lastnum1;
	static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();

	public static void main(String[] args) throws InterruptedException {

		try {
			queue.put(lastnum);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < 100; i++) {
			int ticknum = (int) ((Math.random()) * 10) + 1;
			try {
				lastnum1 = queue.take();
				if (lastnum1 == 0) {
					break;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			TicketMangerment_Queue mangerment_Queue = new TicketMangerment_Queue(lastnum1, ticknum, queue);

			Thread thread = new Thread(mangerment_Queue);
			thread.start();

		}

	}
}
