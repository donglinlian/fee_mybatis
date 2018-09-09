/**  
 * Project : Cloud-WIFI   
 *    
 * File generated at : 2018年3月20日-上午8:52:25  
 * 
 * Copyright 2018 Phicomm Co.,Ltd.
 *   
 */
package com.alice.application.subscriber.web.improve;

/**  
 *   
 * InitClassOrder2  说明内容 
 *  
 * TODO 现有问题及需完善的方向  
 *  
 * author: Alice, 2018年3月20日-上午8:52:25, based on @version 1.0.0     
 *  
 */
public class InitClassOrder2 {
	
    public static void main(String[] args) {
        Son son = new Son();
    }
}

	class Grandpa {
	    public Grandpa() {
	        System.out.println("this is grandpa.");
	    }

	    public Grandpa(int age) {
	        System.out.println("grandpa is " + age + " years old.");
	    }

	    private Height height = new Height(1.5f);

	    public static Gender gender = new Gender(true, "grandpa");
	    
	    public static void staticMethod(){
	    	System.out.println("this is staticMethod in grandpa");
	    }
	    {
	    	System.out.println("this is ordernary code block in grandpa");
	    }
	     static 
	    {
	    	System.out.println("this is static code block in grandpa");
	    }
	    public void ordernaryMethod(){
	    	System.out.println("this is ordernaryMethod in grandpa");
	    }
	    
	}

	class Father extends Grandpa {

	    public Father() {
	        System.out.println("this is father.");
	    }

	    public Father(int age) {
	        System.out.println("father is " + age + " years old.");
	    }

	    private Height height = new Height(1.6f);

	    public static Gender gender = new Gender(true, "father");
	    
	    public void ordernaryMethods(){
	    	System.out.println("this is a ordernary method in father class!");
	    }
	}

	class Son extends Father {

	    public Son() {
	        super(50);
	        System.out.println("this is son.");
	    }

	    public Son(int age) {
	        System.out.println("son is " + age + " years old.");
	    }

	    private Height height = new Height(1.8f);

	    public static Gender gender = new Gender(true, "son");
	    
	    public void ordernaryMethod(){
	    	System.out.println("this is ordernaryMethod in son");
	    }
	}

	class Height {
	    public Height(float height) {
	        System.out.println("initializing height " + height + " meters.");
	    }
	}

	class Gender {
	    public Gender(boolean isMale) {
	        if (isMale) {
	            System.out.println("this is a male.");
	        } else {
	            System.out.println("this is a female.");
	        }
	    }

	    public Gender(boolean isMale, String identify) {
	        if (isMale) {
	            System.out.println(identify + " is a male.");
	        } else {
	            System.out.println(identify + " is a female.");
	        }
	    }
  }