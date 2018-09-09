/**  
 * Project : Cloud-WIFI   
 *    
 * File generated at : 2018年3月21日-上午10:54:49  
 * 
 * Copyright 2018 Phicomm Co.,Ltd.
 *   
 */
package com.alice.application.subscriber.web.improve.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**  
 *   
 * LockInterruptibly  说明内容 
 *  
 * TODO 现有问题及需完善的方向  
 *  
 * author: Alice, 2018年3月21日-上午10:54:49, based on @version 1.0.0     
 *  
 */
public class TryLockWithCondition {
	    private Lock lock = new ReentrantLock();   
	    public static void main(String[] args)  {
	    	TryLockWithCondition test = new TryLockWithCondition();
	        MyThread thread1 = new MyThread(test,"A");
	        MyThread thread2 = new MyThread(test,"B");
	        thread1.start();
	        thread2.start();

	        try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        thread2.interrupt();//线程B已经获得锁了，执行该句子不可以中断，未获得，可以中断
	    }  

	    public void insert(Thread thread) throws InterruptedException{
	        if(lock.tryLock(6, TimeUnit.SECONDS)){
	            try {
	                System.out.println("time=" + System.currentTimeMillis() + " ,线程 " + thread.getName()+"得到了锁...");
	                long now = System.currentTimeMillis();
	                while (System.currentTimeMillis() - now < 5000) {
	                    // 为了避免Thread.sleep()而需要捕获InterruptedException而带来的理解上的困惑,
	                    // 此处用这种方法空转3秒
	                }
	            }finally{
	            	System.out.println("time=" + System.currentTimeMillis() + " ,线程 " + thread.getName()+"释放锁");
	                lock.unlock();
	            }
	        }else {
	            System.out.println("线程 " + thread.getName()+"放弃了对锁的获取...");
	        }
	    }
	}

	class MyThread extends Thread {
	    private TryLockWithCondition test = null;

	    public MyThread(TryLockWithCondition test,String name) {
	        super(name);
	        this.test = test;
	    }

	    @Override
	    public void run() {
	        try {
	            test.insert(Thread.currentThread());
	        } catch (InterruptedException e) {
	            System.out.println("time=" + System.currentTimeMillis() + " ,线程 " + Thread.currentThread().getName() + "被中断...");
	        }
	    }
	}
