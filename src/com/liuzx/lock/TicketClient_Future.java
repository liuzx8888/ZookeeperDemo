package com.liuzx.lock;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketClient_Future {
	static int lastnum = 1000;

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		for (int i = 0; i < 200; i++) {
			int ticknum = (int) ((Math.random()) * 10) + 1;
			Callable<Integer> callable = new TicketMangerment_Callable(lastnum, ticknum);
			FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
			Thread thread = new Thread(futureTask);
			thread.start();
			lastnum = futureTask.get();
			if (lastnum == 0)
				break;
		}

	}

}