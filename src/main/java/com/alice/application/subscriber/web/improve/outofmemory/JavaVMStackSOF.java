/**  
 * Project : Cloud-WIFI   
 *    
 * File generated at : 2018年4月27日-下午6:53:12  
 * 
 * Copyright 2018 Phicomm Co.,Ltd.
 *   
 */
package com.alice.application.subscriber.web.improve.outofmemory;

/**  
 *   
 * JavaVMStackSOF  说明内容 
 *  
 * TODO 现有问题及需完善的方向  
 *  
 * author: linlian.dong, 2018年4月27日-下午6:53:12, based on @version 1.0.0     
 *  
 */
/**
 * VM Args：-Xss128k
 * @author zzm
 */
public class JavaVMStackSOF {

	private int stackLength = 1;

	public void stackLeak() {
		stackLength++;
		stackLeak();
	}

	public static void main(String[] args) throws Throwable {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack length:" + oom.stackLength);
			throw e;
		}
	}
}
