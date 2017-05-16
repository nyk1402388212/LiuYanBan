package com.mi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mi.homeServlet;

import daoImpl.daoImpl;
//点击尾页，跳转到此页
public class lastServlet  extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");  
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		//查到数据库有多少条信息
		daoImpl dao = new daoImpl();
		int a = dao.count();
		int b = a%5;
		
		if(b==0){
			homeServlet.number = a-4;
			homeServlet.number2 = a;
			//跳转到主页面
			RequestDispatcher rd=req.getRequestDispatcher("home");
			rd.forward(req,resp);
		}else{
			homeServlet.number = a-b+1;
			homeServlet.number2 = a+4;
			//跳转到主页面
			RequestDispatcher rd=req.getRequestDispatcher("home");
			rd.forward(req,resp);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	
}
