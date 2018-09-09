/**  
 * Project : Cloud-WIFI   
 *    
 * File generated at : 2018年3月21日-下午1:20:36  
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
 * Lock  
 *  
 * TODO ReentrantLock，可重入锁
 *  
 * author: Alice, 2018年3月21日-下午1:20:36, based on @version 1.0.0     
 *  
 */
public class LockJava {
	 private ArrayList<Integer> arrayList = new ArrayList<Integer>();
	 Lock lock = new ReentrantLock();  // 注意这个地方:lock被声明为局部变量
	    public static void main(String[] args) {
	        final LockJava test = new LockJava();

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
	    	lock.lock();
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

}
