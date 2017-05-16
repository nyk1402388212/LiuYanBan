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
//点击回复按钮，跳转到此页
public class answerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");  
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String a = req.getParameter("userid");//拿到数据库中的userid;
		int id = Integer.parseInt(a);
		String answerer = req.getParameter("answerer");//拿到回复者
		String answer = req.getParameter("answer");//拿到回复内容
		daoImpl dao = new daoImpl();
		dao.answer(id, answerer, answer);//调用数据库的方法，加入到数据库
		//添加到数据库成功之后，跳转到主页面
		RequestDispatcher rd=req.getRequestDispatcher("home");
		rd.forward(req,resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

}
