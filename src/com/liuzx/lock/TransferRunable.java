package com.liuzx.lock;

public class TransferRunable implements Runnable {
	private Bank bank;
	private int fromAccount;
	private double maxAccount;
	private int Delay = 10;

	public TransferRunable(Bank b, int from, double max) {
		// TODO Auto-generated constructor stub
		this.bank = b;
		this.fromAccount = from;
		this.maxAccount = max;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		int toAccount = (int) (bank.size() * Math.random());
		double amount = maxAccount * Math.random();
		try {
			bank.transfer(fromAccount, toAccount, amount);
			System.out.println(Thread.currentThread().getName());
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			 Thread.sleep((int) (Delay * Math.random()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
