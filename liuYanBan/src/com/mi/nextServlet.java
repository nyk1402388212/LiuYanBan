package com.mi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.daoImpl;
//�����һҳ����ת����ҳ
public class nextServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");  
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		daoImpl dao = new daoImpl();
		//�鵽���ݿ��ж�������Ϣ
		int a = dao.count();
		int c = 0;// c��ֵ���֮�����ǰҳ
		if((homeServlet.number-1)%5==0){
			c = (homeServlet.number-1)/5+1;
		}else if((homeServlet.number-1)%5!=0){
			c = (homeServlet.number-1)/5+2;
		}
		//�ɷ���
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
			//��ת����ҳ��
			RequestDispatcher rd=req.getRequestDispatcher("home");
			rd.forward(req,resp);
		}else{
		homeServlet.number = c*5+1;
		homeServlet.number2 =++c*5;
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
