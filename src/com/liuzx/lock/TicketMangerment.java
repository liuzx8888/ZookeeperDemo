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
			System.out.println(Thread.currentThread().getName() + "������" + salenum + "��Ʊ������ʣ��Ʊ����" + lastnum);
		}
		else if (lastnum < salenum && lastnum>0) {
			System.out.println(Thread.currentThread().getName() +"��Ʊ��������Ʊ����"+salenum+"����ʣ��Ʊ����" + lastnum);
		}else if(lastnum==0) {
			System.out.println(Thread.currentThread().getName() +"Ʊ�����ˣ�������" );	
		}
		
	}

}
