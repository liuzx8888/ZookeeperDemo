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
			System.out.println(Thread.currentThread().getName() + "������" + salenum + "��Ʊ������ʣ��Ʊ����" + lastnum);
		} else if (lastnum < salenum && lastnum > 0) {
			System.out.println(Thread.currentThread().getName() + "��Ʊ��������Ʊ����" + salenum + "����ʣ��Ʊ����" + lastnum);
		} else if (lastnum == 0) {
			System.out.println(Thread.currentThread().getName() + "Ʊ�����ˣ�������");
		}

		return lastnum;
	}

}
