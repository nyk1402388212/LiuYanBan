package com.mi;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import daoImpl.daoImpl;

/**
 * Servlet implementation class homeServlet
 */
public class homeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
      public static  int number = 1;//number��������ÿҳ�ĵ�һ����¼��α�����
      public static  int number2 = 5;//number��������ÿҳ�����һ������¼��α�����
    /**
     * @see HttpServlet#HttpServlet()
	</head>
	<body >
     */
    public homeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		daoImpl dao = new daoImpl();
		//ͨ�����ݿ��ҳ��ѯ���õ�5������
		List list = dao.select5(number,number2);
		//aΪ���ݿ������������
		int a = dao.count();
		int b = a%5;//bΪ��ҳ��
		//�˴���Ϊ���������ҳ����ͬ
		if (b ==0){
			b=a/5;
			System.out.println("b : "+b);
		}else{
			//���a���ܱ�5��������ҳ����Ҫb+1ҳ2
			b = a/5+1;
			System.out.println("b++ִ����"+b);
		}
		int c = 0;//��ǰҳ
		//��Ϊ�������
		if((number-1)%5==0){
			c = (number-1)/5+1;
		}else if((number-1)%5!=0){
			c = (number-1)/5+2;
		}
		response.setContentType("text/html;charset=UTF-8");  
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");  
			response.getWriter().println("<html>");  
			response.getWriter().println("<head>");
			response.getWriter().println("<meta charset=\"UTF-8\">");     
			response.getWriter().println("<title></title>");     
			response.getWriter().println("</head>");  
			response.getWriter().println("<body>");     
			response.getWriter().println("<div style=\"width: 55%;background-color: #f5f4fa;text-align: center;position: absolute;margin-left: 22.5%;padding-bottom: 15px;\">");  
			response.getWriter().println("<img src=\"img/title.jpg\" />");     
			//���԰�div
			//forѭ������ʴ����԰�
			for(int i =0; i<list.size();i++){
				User user = (User) list.get(i);
			response.getWriter().println("	<div style=\"width: 94%;margin-left: 2%;padding:0 1% 3px;margin-bottom: 1%;background-color: #fff6dd;text-align: left;border: solid 1px #ff9900;\">");  
			response.getWriter().println("<img src=\"img/question.gif\" style=\"margin-left:8px;margin-top: 12px;\" />");     
			response.getWriter().println("<strong style=\"color: #1172c3;\">&nbsp;&nbsp;&nbsp;&nbsp;"+user.getUsername()+"</strong><span style=\"margin-left: 500px;\">"+user.getTime()+"</span><hr/>");  
			response.getWriter().println("	���⣺"+user.getHeadline()+"<br />");     
			response.getWriter().println("<p style=\"text-indent:4em ;\">"+user.getContent()+"</p>");  
			response.getWriter().println("	<div style=\"widows: 94%;padding: 2% 2%;background-color:#f5f4fa;border: solid 1px  #cccccc;\">");     
			/*response.getWriter().println("	<img src=\"img/answer.gif\"/>");  */
			response.getWriter().println("<form action=\"answer\" method=\"get\" >");     
			//���û�лظ�������ʾΪ�����ı���
			if(user.getAnswer()==null){
				//��һ�ַ���
				/*response.getWriter().println("<strong style=\"color: #ff9900;display: block; \"> <img src=\"img/answer.gif\"/> &nbsp;&nbsp;&nbsp;&nbsp;�����Ի�û�˻ظ�...</strong>");     
				response.getWriter().println("	<p style=\"text-indent:4em ;display:inline-block;\">�����Ի�û�˻ظ�...</p> <a href=\"answer\"><input type=\"button\" value=\"�ظ�\" style=\"margin-left: 300px;\"></input></a>");  */
				//�ڶ��ַ���
				response.getWriter().println("<img src=\"img/answer.gif\"/><input type=\"text\" name=\"answerer\"placeholder=\"�û���\" /><br />");
				response.getWriter().println("<input type=\"text\" name=\"answer\" style=\"height: 50px;width: 300px;margin-left: 20px;\" placeholder=\"�ظ�����\" />");
				response.getWriter().println("<input type=\"submit\" value=\"�ظ�\" style=\"margin-left: 20px;\"></input>");  
				int  id = user.getUserid();
				response.getWriter().println("<input type=\"text\" name=\"userid\" value=\""+id+"\"  style=\"display: none;\"/>");  
				System.out.println(id);	
			}else{
			//����лظ�������ʾ
			response.getWriter().println("<strong style=\"color: #ff9900\"><img src=\"img/answer.gif\"/>&nbsp;&nbsp;&nbsp;&nbsp;"+user.getAnswerer()+"</strong>");     
			response.getWriter().println("	<p style=\"text-indent:4em ;\">"+user.getAnswer()+"</p>");  
			}
			response.getWriter().println("</form>");
			response.getWriter().println("</div>");     
			response.getWriter().println("</div>");     
		}//forѭ������
		response.getWriter().println("<form method=\"post\" action=\"skip\">"); //select��form��
		response.getWriter().println("<br />һ��"+a+"����¼ &nbsp;&nbsp;"+c+"/"+b+"ҳ <a href=\"first\" style=\"color: black;text-decoration: none;\">&nbsp;&nbsp;��ҳ</a> &nbsp;&nbsp; &nbsp;&nbsp;<a href=\"prior\" style=\"color: black;text-decoration: none;\">��һҳ</a> &nbsp;&nbsp; &nbsp;&nbsp;<a href=\"next\" style=\"color: black;text-decoration: none;\" >��һҳ</a> &nbsp;&nbsp; &nbsp;&nbsp;<a href=\"last\" style=\"color: black;text-decoration: none;\">βҳ</a> &nbsp;&nbsp; &nbsp;&nbsp;");     
		response.getWriter().println("��<select name = \"skip\" >");  
		//������ҳ����ѭ�����select�����б��ÿһ������
		for(int i = 1;i<=b;i++){
			if(i == c){
				response.getWriter().println("  <option selected value =\""+i+"\">"+i+"</option>"); 
			}else{
			response.getWriter().println("  <option  value =\""+i+"\">"+i+"</option>");  
			}
		}
			response.getWriter().println("</select>");     
			response.getWriter().println("ҳ <input type=\"submit\" value=\"��ת\" /></form><br /><br />");  
			
		//	<!--��������div-->
		response.getWriter().println("	<div style=\"text-align: left;width: 96%;margin-left: 2%;background-color: #f5f4fa;border: solid 1px #7dbfdb;\">");     
		response.getWriter().println("<p style=\" background-color: #7dbfdb;padding-left: 20px;margin-top: 0px;\" ><img src=\"img/liuyan.gif\"> ��Ҫ���� </p>");  
		response.getWriter().println("<form action=\"add\" method=\"post\" style=\"margin-left: 3%;\">");     
		response.getWriter().println("	�ǳƣ�<input type=\"text\" name=\"name\" style=\"width: 200px;\"/> ���䣺<input type=\"text\" style=\"width: 200px;\" name=\"email\"/><br />");  
		response.getWriter().println("	���⣺<input type=\"text\" style=\"width: 350px;\" name=\"headline\" /><br />");     
		response.getWriter().println("���ԣ�<textarea rows=\"5\" cols=\"65\" name=\"content\" style=\"vertical-align:top;\"></textarea><br />");  
		response.getWriter().println("��֤�룺<input type=\"text\" name=\"name\" /><br />");     
		response.getWriter().println("<input type=\"submit\" value=\"�ύ\"style=\" margin-left: 48%;\"/><br /><br />");  
		response.getWriter().println("1.�û��������Խ����������������ҳе�һ���򷢱���������ľ��׺����Σ�<br />");     
		response.getWriter().println("	2.��վ������Ա��Ȩ�ڲ�֪ͨ�û��������ɾ�������Ϲ涨��������Ϣ������֤�ݣ�<br />");  
		response.getWriter().println("3.��͹۵�����������������ѯ���ᳫ�������£��ž�á������������Ȳ�������Ϊ");     
		response.getWriter().println("</form>");  
		response.getWriter().println("	</div>");     
		response.getWriter().println("</div>");  
		response.getWriter().println("<body>");     
		response.getWriter().println("</html>");  
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
