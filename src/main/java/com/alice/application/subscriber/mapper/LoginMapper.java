/**  
 * Project : Cloud-WIFI   
 *    
 * File generated at : 2018年8月16日-下午3:13:39  
 * 
 * Copyright 2018 Phicomm Co.,Ltd.
 *   
 */
package com.alice.application.subscriber.mapper;

import com.alice.application.subscriber.model.Admin;

/**  
 *   
 * LoginMapper  说明内容 
 *  
 * TODO 现有问题及需完善的方向  
 *  
 * author: linlian.dong, 2018年8月16日-下午3:13:39, based on @version 1.0.0     
 *  
 */

public interface LoginMapper {

	/**  
	 * checkIsAdmin(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param username
	 * @param password    
	 * 
	 * @return void  返回值说明  
	 *
	 * @since  1.0.0  (从xx版本开始实现，可选)
	*/
	Admin checkIsAdmin(String username, String password);

	/**  
	 * checkIsAdmin(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param loginAccount
	 * @return    
	 * 
	 * @return Admin  返回值说明  
	 *
	 * @since  1.0.0  (从xx版本开始实现，可选)
	*/
	Admin checkIsAdmin(Admin loginAccount);

}
