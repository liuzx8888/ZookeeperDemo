package com.liuzx.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyTryLockDemo {
	
		private static ArrayList<Integer> arrayList = new ArrayList<Integer>();
		static Lock lock = new ReentrantLock(); // ע������ط�
		public static void main(String[] args) {
			
			new Thread() {
				public void run() {
					Thread thread = Thread.currentThread();
					boolean tryLock = lock.tryLock();
					System.out.println(thread.getName()+" "+tryLock);
					if (tryLock) {
						try {
							System.out.println(thread.getName() + "�õ�����");
							for (int i = 0; i < 5; i++) {
								thread.sleep(1);
								arrayList.add(i);
							}
						} catch (Exception e) {
							// TODO: handle exception
						} finally {
							System.out.println(thread.getName() + "�ͷ�����");
							lock.unlock();
						}
					}
				};
			}.start();

			new Thread() {
				public void run() {
					Thread thread = Thread.currentThread();
					boolean tryLock = lock.tryLock();
					System.out.println(thread.getName()+" "+tryLock);
					if (tryLock) {
						try {
							System.out.println(thread.getName() + "�õ�����");
							for (int i = 0; i < 5; i++) {
								arrayList.add(i);
							}
						} catch (Exception e) {
							// TODO: handle exception
						} finally {
							System.out.println(thread.getName() + "�ͷ�����");
							lock.unlock();
						}
					}

				};
			}.start();
	}

}
