package com.mi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mi.homeServlet;

import daoImpl.daoImpl;
//���βҳ����ת����ҳ
public class lastServlet  extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");  
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		//�鵽���ݿ��ж�������Ϣ
		daoImpl dao = new daoImpl();
		int a = dao.count();
		int b = a%5;
		
		if(b==0){
			homeServlet.number = a-4;
			homeServlet.number2 = a;
			//��ת����ҳ��
			RequestDispatcher rd=req.getRequestDispatcher("home");
			rd.forward(req,resp);
		}else{
			homeServlet.number = a-b+1;
			homeServlet.number2 = a+4;
			//��ת����ҳ��
			RequestDispatcher rd=req.getRequestDispatcher("home");
			rd.forward(req,resp);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	
}
