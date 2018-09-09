/**  
 * Project : Cloud-WIFI   
 *    
 * File generated at : 2018年3月20日-上午8:46:33  
 * 
 * Copyright 2018 Phicomm Co.,Ltd.
 *   
 */
package com.alice.application.subscriber.web.improve;


/**  
 *   
 * InitClassOrder  说明内容 
 *  
 * TODO 现有问题及需完善的方向  
 *  
 * author: Alice, 2018年3月20日-上午8:46:33, based on @version 1.0.0     
 *  
 */
public class InitClassOrder {
	
	    public static void main(String[] args) {
	        Son1 son = new Son1();
	    }
	}

	class Son1 {

	    public Son1() {
	        System.out.println("this is son.");
	    }

	    public Son1(int age) {
	        System.out.println("son is " + age + " years old.");
	    }
	    
	    private Height height = new Height(1.8f);
	    
	    public static Gender gender = new Gender(true);
	}

	class Height1 {
	    public Height1(float height) {
	        System.out.println("initializing height " + height + " meters.");
	    }
	}

	class Gender1 {
	    public Gender1(boolean isMale) {
	        if (isMale) {
	            System.out.println("this is a male.");
	        } else {
	            System.out.println("this is a female.");
	        }
	    }
	

}
