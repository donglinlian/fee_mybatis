/**  
 * Project : Cloud-WIFI   
 *    
 * File generated at : 2018年8月1日-下午3:41:03  
 * 
 * Copyright 2018 Phicomm Co.,Ltd.
 *   
 */
package com.alice.application.subscriber.web.improve.thread.daemon;

import java.util.Date;
import java.util.Deque;


/**  
 *   
 * CleanerTask  说明内容 
 *  
 * TODO 现有问题及需完善的方向  
 *  
 * author: linlian.dong, 2018年8月1日-下午3:41:03, based on @version 1.0.0     
 *  
 */
public class CleanerTask extends Thread {
	 
		private Deque<Event> deque;
	 
		public CleanerTask(Deque<Event> deque) {
			this.deque = deque;
			//设置为守护进程
			setDaemon(true);
		}
		
		@Override
		public void run() {
			while(true) {
				Date date = new Date();
				clean(date);
			}
		}
	 
		private void clean(Date date) {
			long difference = 0;
			boolean delete = false;
			
			if(deque.size() == 0) {
				return;
			}
			
			do {
				Event e = deque.getLast();
				difference = date.getTime() - e.getDate().getTime();
				if(difference > 10000) {
					System.out.println("cleaner " + e.getEvent());
					deque.removeLast();
					delete = true;
				}
			}while(difference > 10000);
			
			if(delete) {
				System.out.println("cleaner : the size of the deque " + deque.size());
			}
		}
	 
		public Deque<Event> getDeque() {
			return deque;
		}
	 
		public void setDeque(Deque<Event> deque) {
			this.deque = deque;
		}
		
		
	}
