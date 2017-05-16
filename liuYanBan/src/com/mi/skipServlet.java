package com.mi;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//点击跳转 ，跳转到此页
public class skipServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");  
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		//获取下拉列表中的值
		String skip = req.getParameter("skip");
		int num = Integer.parseInt(skip);//转化为int
		homeServlet.number = num*5-4;
		homeServlet.number2 = num*5;
		//跳转到主页面
		RequestDispatcher rd=req.getRequestDispatcher("home");
		rd.forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

	
}
