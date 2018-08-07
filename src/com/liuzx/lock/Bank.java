package com.liuzx.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
	private double[] accounts = null;
	private Lock lock = new ReentrantLock();
	private Condition condition;

	public Bank(int n, double initialBalance) {
		// TODO Auto-generated constructor stub
		accounts = new double[n];
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = initialBalance;
		}
		lock = new ReentrantLock();
		condition = lock.newCondition();
	}

	public void transfer(int from, int to, double amount) throws InterruptedException {
		lock.lock();
		try {
			while (accounts[from] < amount)
			wait();
	/*		System.out.println(Thread.currentThread()+"================");*/
			accounts[from] -= amount;
			System.out.printf(" %10.2f from %d to %d", amount, from, to);
			accounts[to] += amount;
			System.out.printf("Total Balance: %10.2fn", getTotalBalance());
			notifyAll();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// TODO: handle finally clause
			lock.unlock();
		}

	}

	public double getTotalBalance() {
		lock.lock();
		try {
			double sum = 0;
			for (double a : accounts) {
				sum += a;
			}
			return sum;

			// TODO Auto-generated method stub
		} finally {
			// TODO: handle finally clause
			lock.unlock();
		}

	}

	public int size() {
		return accounts.length;
	}
}
