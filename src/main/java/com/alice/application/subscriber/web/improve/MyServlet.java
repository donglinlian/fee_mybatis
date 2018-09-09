/**  
 * Project : Cloud-WIFI   
 *    
 * File generated at : 2018年5月17日-下午2:10:15  
 * 
 * Copyright 2018 Phicomm Co.,Ltd.
 *   
 */
package com.alice.application.subscriber.web.improve;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**  
 *   
 * MyServlet  说明内容 
 *  
 * TODO 现有问题及需完善的方向  
 *  
 * author: linlian.dong, 2018年5月17日-下午2:10:15, based on @version 1.0.0     
 *  
 */
public class MyServlet extends HttpServlet{
	/**serialVersionUID :字段描述                          */  
	
	private static final long serialVersionUID = 1L;
	int index = 0;
	/**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        if(request.getSession().getAttribute("count") == null){
            request.getSession().setAttribute("count", 0);
            response.getWriter().write(0+"");
        }else{
            int a = Integer.parseInt(request.getSession().getAttribute("count").toString());
            request.getSession().setAttribute("count", ++a);
            response.getWriter().write(a+"");
        }

        Cookie[] cookies = request.getCookies();
        StringBuffer sb = new StringBuffer();
        if(cookies!=null){
            for(Cookie cookie : cookies){
                sb.append(cookie.getName()+":"+cookie.getValue()+",");
            }
            sb.deleteCharAt(sb.length()-1);
        }

        System.out.println("[第"+(++index)+"次访问]from client request, cookies:" + sb);
        System.out.println("[第"+(index)+"次访问]from server response, header-Set-Cookie:" + response.getHeader("Set-Cookie"));;
    }

}
