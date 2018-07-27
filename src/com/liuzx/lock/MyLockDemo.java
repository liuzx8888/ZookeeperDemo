package com.liuzx.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLockDemo {
	public static List<Integer> arrlist = new ArrayList<Integer>();
	static Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				Thread thread = new Thread("����1");
				lock.lock();
				// TODO Auto-generated method stub
				super.run();
				try {
					System.out.println(thread.currentThread().getName() + "��ȡ��Դ");
					for (int i = 0; i < 5; i++) {
						arrlist.add(i);
						thread.sleep(500);
						System.out.println(arrlist);
					}
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					System.out.println(thread.currentThread().getName() + "�ͷ���Դ");
					lock.unlock();
				}
			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				Thread thread = new Thread("����2");
				lock.lock();
				// TODO Auto-generated method stub
				super.run();
				try {
					System.out.println(thread.currentThread().getName() + "��ȡ��Դ");
					for (int i = 0; i < 5; i++) {
						arrlist.add(i);
					}
					thread.sleep(300);
					System.out.println(arrlist);
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					System.out.println(thread.currentThread().getName() + "�ͷ���Դ");
					lock.unlock();
				}
			}
		}.start();

	}

}
