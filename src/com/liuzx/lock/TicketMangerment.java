package com.liuzx.lock;

public class TicketMangerment implements Runnable {

	public static int lastnum;
	public static int salenum;

	public TicketMangerment(int salenum) {
		// TODO Auto-generated constructor stub
		this.salenum = salenum;
	}

	public int saleticket() {
		
			return lastnum - salenum;
	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		if (lastnum >= salenum) {
			lastnum=this.saleticket();
			System.out.println(Thread.currentThread().getName() + "卖出了" + salenum + "张票，现在剩余票数：" + lastnum);
		}
		else if (lastnum < salenum && lastnum>0) {
			System.out.println(Thread.currentThread().getName() +"余票不够，够票数："+salenum+"现在剩余票数：" + lastnum);
		}else if(lastnum==0) {
			System.out.println(Thread.currentThread().getName() +"票卖光了！！！！" );	
		}
		
	}

}
