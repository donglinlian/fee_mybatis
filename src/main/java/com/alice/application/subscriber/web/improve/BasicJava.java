/**  
 * Project : Cloud-WIFI   
 *    
 * File generated at : 2018年3月18日-下午3:17:23  
 * 
 * Copyright 2018 Phicomm Co.,Ltd.
 *   
 */
package com.alice.application.subscriber.web.improve;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.collections.iterators.EntrySetMapIterator;

/**  
 *   
 * BasicJava  说明内容 
 *  
 * TODO 现有问题及需完善的方向  
 *  
 * author: Alice, 2018年3月18日-下午3:17:23, based on @version 1.0.0     
 *  
 */
public class BasicJava {

	/**  
	 * main(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param args    
	 * 
	 * @return void  返回值说明  
	 *
	 * @since  1.0.0  (从xx版本开始实现，可选)
	 */
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		StringBuilder sbu = new StringBuilder();
		List<String> list1 = new LinkedList<String>();
		List<String> list2 = new ArrayList<String>();
		list2.add("a");
		list2.add("b");
		list2.add("d");
		list2.add("e");
		list2.add("e");
		list2.add("e");
		list2.add("e");
		list2.add("e");
		list2.add("e");
		list2.add("e");
		list2.add("e");
		list2.add("e");
		list2.add("e");
		list2.add(2, "c");
		list2.get(3);
		
		list1.add("a");
		list1.add("b");
		list1.add("d");
		list1.get(2);
		
//		Map<Object,Object> hashMap = new HashMap<Object,Object>();
//		hashMap.put("one", "1111");
//		hashMap.put("two", "2222");
//		hashMap.put("three", "33333");
//		Map<Object,Object> linkedHashMap = new LinkedHashMap<Object,Object>();
		Map<Object,Object> linkedHashMap = new HashMap<Object,Object>();

		linkedHashMap.put("1", "1111");
		linkedHashMap.put("2", "2222");
		linkedHashMap.put("22", "33333");
		linkedHashMap.put("222", "1111");
		linkedHashMap.put("5", "2222");
		linkedHashMap.put("6", "33333");
		linkedHashMap.put("7", "1111");
		linkedHashMap.put("8", "2222");
		linkedHashMap.put("9", "33333");
		linkedHashMap.put("10", "1111");
		linkedHashMap.put("11", "2222");
		linkedHashMap.put("12", "33333");
		linkedHashMap.put("13", "1111");
//		linkedHashMap.put("14", "2222");
//		linkedHashMap.put("15", "33333");
//		linkedHashMap.put("16", "1111");
//		linkedHashMap.put("17", "2222");
//		linkedHashMap.put("18", "33333");
//		linkedHashMap.put("19", "1111");
//		linkedHashMap.put("20", "2222");
//		linkedHashMap.put("21", "33333");
//		linkedHashMap.put("22", "1111");
//		linkedHashMap.put("23", "2222");
//		linkedHashMap.put("24", "33333");
		Set<Entry<Object, Object>> entry = linkedHashMap.entrySet();
		for(Entry<Object, Object> eachEntry:entry){
			String key = (String) eachEntry.getKey();
			String value = (String) eachEntry.getValue();
		}
		Map<Object,Object> concurrentHashMap = new ConcurrentHashMap<Object,Object>();
		Map<Object,Object> treeMap = new TreeMap<Object,Object>();
		String a = "a";
		String b = "a";
		String c = new String("a");
		if(a.equals(b)){System.out.println("a equals b");}
		else System.out.println("a is not equals b");
		if(a==b){System.out.println("a==b");}
		else System.out.println("a is not == b");
		if(a.equals(c)){System.out.println("a equals c");}//equals 是根据value和n判断
		else System.out.println("a is not equals c");
		if(a==c){System.out.println("a == c");}
		else System.out.println("a is not == c");//地址不一样
		
		Thread thread = new Thread("test the thread!");	
		Thread thread1 = new Thread("test the thread!");
		thread.start();
		thread1.setDaemon(true);
		thread1.start();
		
		System.out.println(thread1.isDaemon());
		
	}

}
