package com.liuzx.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * �۲��������thread-0�õ�����������������thread-1���Ի�ȡ��������ò���������Ա��жϵȴ�
 * @author
 *
 */
public class MyInterruptibly {
	 private Lock lock = new ReentrantLock();  
	 
	    public static void main(String[] args)  {
	    	MyInterruptibly test = new MyInterruptibly();
	        MyThread thread0 = new MyThread(test);
	        MyThread thread1 = new MyThread(test);
	        thread0.start();
	        thread1.start();
	         
	        try {
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        thread1.interrupt();
	        System.out.println("=====================");
	    }  
	     
	    public void insert(Thread thread) throws InterruptedException{
	        lock.lockInterruptibly();   //ע�⣬�����Ҫ��ȷ�жϵȴ������̣߳����뽫��ȡ���������棬Ȼ��InterruptedException�׳�
	        try {  
	            System.out.println(thread.getName()+"�õ�����");
	            long startTime = System.currentTimeMillis();
	            for(    ;     ;) {
	                if(System.currentTimeMillis() - startTime >= 10000)
	                    break;
	                //��������
	            }
	        }
	        finally {
	            System.out.println(Thread.currentThread().getName()+"ִ��finally");
	            lock.unlock();
	            System.out.println(thread.getName()+"�ͷ�����");
	        }  
	    }
	}
	 
	class MyThread extends Thread {
	    private MyInterruptibly test = null;
	    public MyThread(MyInterruptibly test) {
	        this.test = test;
	    }
	    @Override
	    public void run() {
	         
	        try {
	            test.insert(Thread.currentThread());
	        } catch (Exception e) {
	            System.out.println(Thread.currentThread().getName()+"���ж�");
	        }
	    }

}
