/**  
 * Project : Cloud-WIFI   
 *    
 * File generated at : 2018年3月27日-上午10:10:41  
 * 
 * Copyright 2018 Phicomm Co.,Ltd.
 *   
 */
package com.alice.application.subscriber.web.improve;

import java.util.HashSet;
import java.util.Set;

/**  
 *   
 * GetMaxAndMin  说明内容 
 *  
 * TODO 现有问题及需完善的方向  
 *  
 * author: Alice, 2018年3月27日-上午10:10:41, based on @version 1.0.0     
 *  
 */
public class GetMaxAndMin {

	/**  
	 * main(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param args    
	 * @return 
	 * 
	 * @return void  返回值说明  
	 *
	 * @since  1.0.0  (从xx版本开始实现，可选)
	 */
	public void get(String[] args){
		int max = 0,min = 0;
		Set<Integer> setInt = new HashSet<Integer>();
		max = Integer.parseInt(args[0]);
		min = Integer.parseInt(args[0]);
		for(int i=0;i<args.length;i++){
			setInt.add(Integer.parseInt(args[i]));			
		}
		for(int eachInt:setInt){
			if(eachInt>max){
				max = eachInt;
			}
			if(eachInt<min){
				min = eachInt;
			}
			
		}
		System.out.println("max:"+max);
		System.out.println("min:"+min);
	}
	public static void main(String[] args) {
		
		GetMaxAndMin a = new GetMaxAndMin();
		a.get(args);

	}

}
