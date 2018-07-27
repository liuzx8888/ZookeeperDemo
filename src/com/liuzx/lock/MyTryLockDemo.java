package com.liuzx.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyTryLockDemo {
	public static List<Integer> arrlist = new ArrayList<Integer>();
	static Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				Thread thread = new Thread("进程1");
				boolean trylock = lock.tryLock();
				System.out.println(trylock);
				if (trylock) {
					try {
						System.out.println(thread.currentThread().getName() + "获取资源");
						for (int i = 0; i < 100; i++) {
							 int j=1/0;
							arrlist.add(i);
						}
						System.out.println(arrlist);
					} catch (Exception e) {
						// TODO: handle exception
					} finally {
						System.out.println(thread.currentThread().getName() + "释放资源");
						lock.unlock();
					}

				}
			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				Thread thread = new Thread("进程2");
				boolean trylock = lock.tryLock();
				System.out.println(trylock);
				if (trylock) {
					try {
						System.out.println(thread.currentThread().getName() + "获取资源");
						for (int i = 0; i < 100; i++) {
							arrlist.add(i);
						}
						System.out.println(arrlist);
					} catch (Exception e) {
						// TODO: handle exception
					} finally {
						System.out.println(thread.currentThread().getName() + "释放资源");
						lock.unlock();
					}

				}
			}
		}.start();

	}

}
