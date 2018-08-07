package com.liuzx.lock;

import java.util.concurrent.Callable;

public class TicketMangerment_Callable implements Callable<Integer> {

	public  int lastnum;
	public  int salenum;

	public TicketMangerment_Callable(int lastnum,int salenum) {
		// TODO Auto-generated constructor stub
		this.lastnum = lastnum;
		this.salenum = salenum;
	}

	public int saleticket() {

		 return lastnum - salenum;

	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub

		if (lastnum >= salenum) {
			lastnum = this.saleticket();
			System.out.println(Thread.currentThread().getName() + "卖出了" + salenum + "张票，现在剩余票数：" + lastnum);
		} else if (lastnum < salenum && lastnum > 0) {
			System.out.println(Thread.currentThread().getName() + "余票不够，够票数：" + salenum + "现在剩余票数：" + lastnum);
		} else if (lastnum == 0) {
			System.out.println(Thread.currentThread().getName() + "票卖光了！！！！");
		}

		return lastnum;
	}

}
