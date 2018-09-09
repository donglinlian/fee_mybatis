/**  
 * Project : Cloud-WIFI   
 *    
 * File generated at : 2018年8月1日-下午3:44:33  
 * 
 * Copyright 2018 Phicomm Co.,Ltd.
 *   
 */
package com.alice.application.subscriber.web.improve.thread.daemon;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**  
 *   
 * WriterTask  说明内容 
 *  
 * TODO 现有问题及需完善的方向  
 *  
 * author: linlian.dong, 2018年8月1日-下午3:44:33, based on @version 1.0.0     
 *  
 */
public class WriterTask implements Runnable {
	 
		public WriterTask(Deque<Event> deque) {
			this.deque = deque;
		}
	 
		// 这个为双向队列
		private Deque<Event> deque;
	 
		public Deque<Event> getDeque() {
			return deque;
		}
	 
		public void setDeque(Deque<Event> deque) {
			this.deque = deque;
		}
	 
		@Override
		public void run() {
			for(int i = 0; i < 100; i++) {			
				Event event = new Event();
				event.setDate(new Date());
				event.setEvent("The Thread " + Thread.currentThread().getId() + " has generated a event "+i);
				deque.addFirst(event);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	 
	}

