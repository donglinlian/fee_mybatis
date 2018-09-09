/**  
 * Project : Cloud-WIFI   
 *    
 * File generated at : 2018年4月26日-下午6:31:15  
 * 
 * Copyright 2018 Phicomm Co.,Ltd.
 *   
 */
package com.alice.application.subscriber.web.improve.outofmemory;

import java.util.ArrayList;
import java.util.List;

/**  
 *   
 * HeapOOM  说明内容 
 *  
 * TODO 现有问题及需完善的方向  
 *  
 * author: linlian.dong, 2018年4月26日-下午6:31:15, based on @version 1.0.0   
 * VM Args：-Xms2m -Xmx2m -XX:+HeapDumpOnOutOfMemoryError  
 *  
 */

public class HeapOOM {

	static class OOMObject {
	}

	public static void main(String[] args) {
		int j  =0;
		List<OOMObject> list = new ArrayList<OOMObject>();
		while (true) {
			System.out.println(j++);
			list.add(new OOMObject());
		System.out.println("size : " + j);  
        Runtime runtime = Runtime.getRuntime(); 
	    System.out.printf("maxMemory : %.2fM\n", runtime.maxMemory()*1.0/1024/1024);  
		System.out.printf("totalMemory : %.2fM\n", runtime.totalMemory()*1.0/1024/1024);  
		System.out.printf("freeMemory : %.2fM\n", runtime.freeMemory()*1.0/1024/1024);
		}
		
//		long arr[] = {};   
//	    for (int i=1; i<=10000000; i*=2) {  
//	        arr = new long[i];
//	        System.out.println("size : " + i);  
//	        Runtime runtime = Runtime.getRuntime(); 
//		    System.out.printf("maxMemory : %.2fM\n", runtime.maxMemory()*1.0/1024/1024);  
//			System.out.printf("totalMemory : %.2fM\n", runtime.totalMemory()*1.0/1024/1024);  
//			System.out.printf("freeMemory : %.2fM\n", runtime.freeMemory()*1.0/1024/1024); 
//	    }  
	    
	}
}

