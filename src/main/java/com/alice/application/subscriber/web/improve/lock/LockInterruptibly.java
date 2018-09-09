/**  
 * Project : Cloud-WIFI   
 *    
 * File generated at : 2018年3月21日-下午1:43:13  
 * 
 * Copyright 2018 Phicomm Co.,Ltd.
 *   
 */
package com.alice.application.subscriber.web.improve.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**  
 *   
 * LockInterupttly  说明内容 
 *  
 * TODO 现有问题及需完善的方向  
 *  
 * author: Alice, 2018年3月21日-下午1:43:13, based on @version 1.0.0     
 *  
 */
public class LockInterruptibly {
	    private Lock lock = new ReentrantLock();   
	    public static void main(String[] args)  {
	    	LockInterruptibly test = new LockInterruptibly();
	        MyThread2 thread1 = new MyThread2(test,"A");
	        MyThread2 thread2 = new MyThread2(test,"B");
	        thread1.start();
	        thread2.start();

	        try {
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        thread1.interrupt();
	    }  

	    public void insert(Thread thread) throws InterruptedException{
	        //注意，如果需要正确中断等待锁的线程，必须将获取锁放在外面，然后将 InterruptedException 抛出
	        lock.lockInterruptibly(); //此处改为lock（）,会一直等待锁，则interrupte（）方法不生效
	        try {  
	            System.out.println("time=" + System.currentTimeMillis() + " ,线程 " + thread.getName()+"得到了锁...");
	            long startTime = System.currentTimeMillis();
	            for(    ;     ; ) {              // 耗时操作
	                if(System.currentTimeMillis() - startTime >= 10000)
	                    break;
	                //插入数据
	            }
	        }finally {
	            lock.unlock();
	            System.out.println("time=" + System.currentTimeMillis() + " ,线程 " +thread.getName()+"释放了锁");
	        } 
	        System.out.println("time=" + System.currentTimeMillis() + " ,线程 " +thread.getName()+"  over");
	    }
	}

	class MyThread2 extends Thread {
	    private LockInterruptibly test = null;
	    public MyThread2(LockInterruptibly test,String name) {
	        super(name);	     
	        this.test = test;
	    }

	    @Override
	    public void run() {
	        try {
	            test.insert(Thread.currentThread());
	        } catch (InterruptedException e) {
	            System.out.println("time=" + System.currentTimeMillis() + " ,线程 " +Thread.currentThread().getName() + "被中断...");
	        }
	  }
}
