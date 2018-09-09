/**  
 * Project : Cloud-WIFI   
 *    
 * File generated at : 2018年4月10日-下午7:56:41  
 * 
 * Copyright 2018 Phicomm Co.,Ltd.
 *   
 */
package com.alice.application.subscriber.web.improve.thread;

/**  
 *   
 * Thread1  说明内容 
 *  
 * TODO 现有问题及需完善的方向  
 *  
 * author: linlian.dong, 2018年4月10日-下午7:56:41, based on @version 1.0.0     
 *  
 */
public class Thread1 extends Thread {
	private static String name;

	public Thread1(String name) {
		super(name);
	}
	public void run(){
		System.out.println("time=" + System.currentTimeMillis() + " ,线程 " + this.getName()+" start...");
        long now = System.currentTimeMillis();
        while (System.currentTimeMillis() - now < 5000) {
            // 为了避免Thread.sleep()而需要捕获InterruptedException而带来的理解上的困惑,
            // 此处用这种方法空转3秒
        }
	}

	public static void main(String[] args) throws InterruptedException {
		Thread1 thread = new Thread1("aaa");
		System.out.println("1 Thread state is :"+thread.isAlive());
		thread.start();
		System.out.println("2 Thread state is :"+thread.isAlive());
		System.out.println("3 Thread state is :"+thread.getState());
		System.out.println("4 Thread state is :"+thread.isAlive());
//		thread.wait();
		System.out.println("5 Thread state is :"+thread.getState());
		Thread1.sleep(2000);
		System.out.println("6 Thread state is :"+thread.isAlive());
		System.out.println("7 Thread state is :"+thread.getState());
		thread.wait();
		System.out.println("8 Thread state is :"+thread.isAlive());
		System.out.println("9 Thread state is :"+thread.getState());
	}
}
