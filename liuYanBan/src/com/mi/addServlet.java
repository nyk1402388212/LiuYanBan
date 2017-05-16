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
//��ҳ�·���Ҫ���ԣ�����ύ��ת����ҳ
public class addServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�õ��û������ֵ
		resp.setContentType("text/html;charset=UTF-8");  
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String headline = req.getParameter("headline");
		String content = req.getParameter("content");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		String time = df.format(new Date());
		//ȫ����ӵ����ݿ���
		daoImpl dao = new daoImpl();
		int a = dao.add(name, email, headline, content, time);
		System.out.println("add a��ֵΪ"+a);
		//��ӵ����ݿ�ɹ�֮����ת����ҳ��
		RequestDispatcher rd=req.getRequestDispatcher("home");
		rd.forward(req,resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req ,resp);
	}

}
