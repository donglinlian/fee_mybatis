/**  
 * Project : Cloud-WIFI   
 *    
 * File generated at : 2018年8月1日-下午3:42:52  
 * 
 * Copyright 2018 Phicomm Co.,Ltd.
 *   
 */
package com.alice.application.subscriber.web.improve.thread.daemon;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;

/**  
 *   
 * Event  说明内容 
 *  
 * TODO 现有问题及需完善的方向  
 *  
 * author: linlian.dong, 2018年8月1日-下午3:42:52, based on @version 1.0.0     
 *  
 */
public class Event {
	 
		private Date date;
		private String event;
	 
		public Date getDate() {
			return date;
		}
	 
		public void setDate(Date date) {
			this.date = date;
		}
	 
		public String getEvent() {
			return event;
		}
	 
		public void setEvent(String event) {
			this.event = event;
		}
		
		
		public static void main(String[] args) {
			Deque<Event> deque = new ArrayDeque<Event>();
			WriterTask writer = new WriterTask(deque);
			for(int i = 0; i < 3; i++) {
				Thread thread = new Thread(writer);
				thread.start();
			}
			CleanerTask cleaner = new CleanerTask(deque);
			cleaner.start();
		}
	}

