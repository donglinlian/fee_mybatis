/**  
 * Project : Cloud-WIFI   
 *    
 * File generated at : 2018年8月16日-下午3:12:12  
 * 
 * Copyright 2018 Phicomm Co.,Ltd.
 *   
 */
package com.alice.application.subscriber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alice.application.subscriber.mapper.LoginMapper;
import com.alice.application.subscriber.model.Admin;

/**  
 *   
 * LoginService  说明内容 
 *  
 * TODO 现有问题及需完善的方向  
 *  
 * author: linlian.dong, 2018年8月16日-下午3:12:12, based on @version 1.0.0     
 *  
 */
@Service
public class LoginService {
   @Autowired
   LoginMapper loginMapper;
	
	/**  
	 * checkIsAdmin(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param username
	 * @param password
	 * @return    
	 * 
	 * @return boolean  返回值说明  
	 *
	 * @since  1.0.0  (从xx版本开始实现，可选)
	*/
	public boolean checkIsAdmin(String username, String password) {
		Admin loginAccount = new Admin();
		loginAccount.setUsername(username);
		loginAccount.setPassword(password);
		Admin admin = loginMapper.checkIsAdmin(loginAccount);
		if(admin!=null){
			return true;
		}
		return false;
	}

}
