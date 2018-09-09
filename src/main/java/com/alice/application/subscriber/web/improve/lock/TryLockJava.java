/**  
 * Project : Cloud-WIFI   
 *    
 * File generated at : 2018年3月21日-上午10:23:36  
 * 
 * Copyright 2018 Phicomm Co.,Ltd.
 *   
 */
package com.alice.application.subscriber.web.improve.lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**  
 *   
 * LockJava 了解lock
 *  
 * TODO 现有问题及需完善的方向  
 *  
 * author: Alice, 2018年3月21日-上午10:23:36, based on @version 1.0.0     
 *  
 */
public class TryLockJava {
	
	 private ArrayList<Integer> arrayList = new ArrayList<Integer>();
	 Lock lock = new ReentrantLock();  // 注意这个地方:lock被声明为局部变量
	    public static void main(String[] args) {
	        final TryLockJava test = new TryLockJava();

	        new Thread("A") {
	            public void run() {
	                test.insert(Thread.currentThread());
	            };
	        }.start();

	        new Thread("B"){
	        	public void run(){
	        		test.insert(Thread.currentThread());
	        	}
	        }.start();
	    }
	    
	    public void insert(Thread thread) {
	    	//如果采用Lock，必须主动去释放锁，并且在发生异常时，不会自动释放锁 
	       if(lock.tryLock()){ 
	        try {
	            System.out.println("线程" + thread.getName() + "得到了锁...");
	            for (int i = 0; i < 5; i++) {
	                arrayList.add(i);
	            }
	        } catch (Exception e) {

	        } finally {
	            System.out.println("线程" + thread.getName() + "释放了锁...");
	            lock.unlock();
	        }
	    }
	    
	    else {
	    	System.out.println("线程" + thread.getName() + "获取锁失败");
	    }
	       
	 }

}
