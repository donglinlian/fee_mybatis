/**  
 * Project : Cloud-WIFI   
 *    
 * File generated at : 2018年8月1日-下午3:27:55  
 * 
 * Copyright 2018 Phicomm Co.,Ltd.
 *   
 */
package com.alice.application.subscriber.web.improve.thread.daemon;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * DeamonTest 说明内容
 * 
 * TODO 现有问题及需完善的方向
 * 
 * author: linlian.dong, 2018年8月1日-下午3:27:55, based on @version 1.0.0
 * 
 */
class TestRunnable implements Runnable {

	public void run() {

		try {

			Thread.sleep(1000);// 守护线程阻塞1秒后运行

			File f = new File("daemon.txt");

			FileOutputStream os = new FileOutputStream(f, true);

			os.write("test".getBytes());

		}

		catch (IOException e1) {

			e1.printStackTrace();

		}

		catch (InterruptedException e2) {

			e2.printStackTrace();

		}

	}

}

public class DeamonTest {

	public static void main(String[] args) throws InterruptedException

	{
		Runnable tr = new TestRunnable();

		Thread thread = new Thread(tr);

		thread.setDaemon(true); // 设置守护线程

		thread.start(); // 开始执行分进程

	}

}
