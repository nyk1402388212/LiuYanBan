package com.mi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mi.homeServlet;
//�����ҳ����ת����ҳ
public class firstServlet extends HttpServlet {

	@Override
	public  void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");  
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		//��ת����ҳ��Ҫ��number���1 ��number2���5
		homeServlet.number = 1;
		homeServlet.number2 = 5;
		//��ӵ����ݿ�ɹ�֮����ת����ҳ��
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
