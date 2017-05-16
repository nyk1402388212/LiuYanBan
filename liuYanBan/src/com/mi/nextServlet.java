package com.mi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.daoImpl;
//点击下一页，跳转到此页
public class nextServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");  
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		daoImpl dao = new daoImpl();
		//查到数据库有多少条信息
		int a = dao.count();
		int c = 0;// c赋值完成之后代表当前页
		if((homeServlet.number-1)%5==0){
			c = (homeServlet.number-1)/5+1;
		}else if((homeServlet.number-1)%5!=0){
			c = (homeServlet.number-1)/5+2;
		}
		//旧方法
		/*if(homeServlet.number2>=a){
			RequestDispatcher rd=req.getRequestDispatcher("home");
			rd.forward(req,resp);
		}else{
		homeServlet.number = homeServlet.number +5;
		homeServlet.number2 = homeServlet.number2 +5;
		RequestDispatcher rd=req.getRequestDispatcher("home");
		rd.forward(req,resp);
		}*/
		if(homeServlet.number2>=a){
			//跳转到主页面
			RequestDispatcher rd=req.getRequestDispatcher("home");
			rd.forward(req,resp);
		}else{
		homeServlet.number = c*5+1;
		homeServlet.number2 =++c*5;
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
