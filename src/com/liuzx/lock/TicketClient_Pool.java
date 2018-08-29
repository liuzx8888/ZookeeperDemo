package com.liuzx.lock;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketClient_Pool {
	static int lastnum = 1000;

	public static void main(String[] args) throws InterruptedException, ExecutionException {

/*		ExecutorService pool = Executors.newCachedThreadPool();*/
		
/*		ExecutorService pool  =Executors.newFixedThreadPool(10);*/
		
/*		ExecutorService pool  =Executors.newSingleThreadExecutor();*/
		
		ScheduledExecutorService pool  =Executors.newScheduledThreadPool(10);
		for (int i = 0; i < 200; i++) {
			int ticknum = (int) ((Math.random()) * 10) + 1;
			Callable<Integer> callable = new TicketMangerment_Callable(lastnum, ticknum);
		
/*			Future<Integer> futureTask = pool.submit(callable);*/
			Future<Integer> futureTask=pool.schedule(callable, 500L, TimeUnit.MILLISECONDS);
			lastnum = futureTask.get();
			if (lastnum == 0)
				break;
		}
		pool.shutdown();

	}

}