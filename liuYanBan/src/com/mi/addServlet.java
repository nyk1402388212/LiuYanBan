package com.mi;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.daoImpl;
//网页下方我要留言，点击提交跳转至此页
public class addServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//拿到用户输入的值
		resp.setContentType("text/html;charset=UTF-8");  
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String headline = req.getParameter("headline");
		String content = req.getParameter("content");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String time = df.format(new Date());
		//全部添加到数据库中
		daoImpl dao = new daoImpl();
		int a = dao.add(name, email, headline, content, time);
		System.out.println("add a的值为"+a);
		//添加到数据库成功之后，跳转到主页面
		RequestDispatcher rd=req.getRequestDispatcher("home");
		rd.forward(req,resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req ,resp);
	}

}
