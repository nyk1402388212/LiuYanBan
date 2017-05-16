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
//����ظ���ť����ת����ҳ
public class answerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");  
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String a = req.getParameter("userid");//�õ����ݿ��е�userid;
		int id = Integer.parseInt(a);
		String answerer = req.getParameter("answerer");//�õ��ظ���
		String answer = req.getParameter("answer");//�õ��ظ�����
		daoImpl dao = new daoImpl();
		dao.answer(id, answerer, answer);//�������ݿ�ķ��������뵽���ݿ�
		//��ӵ����ݿ�ɹ�֮����ת����ҳ��
		RequestDispatcher rd=req.getRequestDispatcher("home");
		rd.forward(req,resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

}
