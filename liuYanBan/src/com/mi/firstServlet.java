package com.mi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mi.homeServlet;
//点击首页，跳转到此页
public class firstServlet extends HttpServlet {

	@Override
	public  void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");  
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		//跳转到首页需要将number变成1 ，number2变成5
		homeServlet.number = 1;
		homeServlet.number2 = 5;
		//添加到数据库成功之后，跳转到主页面
		RequestDispatcher rd=req.getRequestDispatcher("home");
		rd.forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

	public static void main(){
	}
	
}
