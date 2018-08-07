package com.liuzx.lock;

public class UnsynBankchBankTest {

	public static final int NACCOUNTS = 10;
	public static final double INITIAL_BALANCE = 1000;

	public static void main(String[] args) throws InterruptedException {
		Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
		int i;
		for (i = 0; i < NACCOUNTS; i++) {
			TransferRunable r = new TransferRunable(b, i, INITIAL_BALANCE*2);
			Thread thread = new Thread(r,"thr1");	
			Thread thread1 = new Thread(r,"thr2");
			Thread thread2 = new Thread(r,"thr3");
			thread.start();
			thread1.start();
			thread2.start();
		}
	}

}
