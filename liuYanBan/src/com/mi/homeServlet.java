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
	
      public static  int number = 1;//number用来保存每页的第一条记录的伪列序号
      public static  int number2 = 5;//number用来保存每页的最后一条条记录的伪列序号
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
		//通过数据库分页查询，拿到5条数据
		List list = dao.select5(number,number2);
		//a为数据库的数据总条数
		int a = dao.count();
		int b = a%5;//b为总页数
		//此处分为两种情况，页数不同
		if (b ==0){
			b=a/5;
			System.out.println("b : "+b);
		}else{
			//如果a不能被5整除，则页数需要b+1页2
			b = a/5+1;
			System.out.println("b++执行了"+b);
		}
		int c = 0;//当前页
		//分为两种情况
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
			//留言板div
			//for循环输出问答留言板
			for(int i =0; i<list.size();i++){
				User user = (User) list.get(i);
			response.getWriter().println("	<div style=\"width: 94%;margin-left: 2%;padding:0 1% 3px;margin-bottom: 1%;background-color: #fff6dd;text-align: left;border: solid 1px #ff9900;\">");  
			response.getWriter().println("<img src=\"img/question.gif\" style=\"margin-left:8px;margin-top: 12px;\" />");     
			response.getWriter().println("<strong style=\"color: #1172c3;\">&nbsp;&nbsp;&nbsp;&nbsp;"+user.getUsername()+"</strong><span style=\"margin-left: 500px;\">"+user.getTime()+"</span><hr/>");  
			response.getWriter().println("	标题："+user.getHeadline()+"<br />");     
			response.getWriter().println("<p style=\"text-indent:4em ;\">"+user.getContent()+"</p>");  
			response.getWriter().println("	<div style=\"widows: 94%;padding: 2% 2%;background-color:#f5f4fa;border: solid 1px  #cccccc;\">");     
			/*response.getWriter().println("	<img src=\"img/answer.gif\"/>");  */
			response.getWriter().println("<form action=\"answer\" method=\"get\" >");     
			//如果没有回复，则显示为两个文本框
			if(user.getAnswer()==null){
				//第一种方案
				/*response.getWriter().println("<strong style=\"color: #ff9900;display: block; \"> <img src=\"img/answer.gif\"/> &nbsp;&nbsp;&nbsp;&nbsp;此留言还没人回复...</strong>");     
				response.getWriter().println("	<p style=\"text-indent:4em ;display:inline-block;\">此留言还没人回复...</p> <a href=\"answer\"><input type=\"button\" value=\"回复\" style=\"margin-left: 300px;\"></input></a>");  */
				//第二种方案
				response.getWriter().println("<img src=\"img/answer.gif\"/><input type=\"text\" name=\"answerer\"placeholder=\"用户名\" /><br />");
				response.getWriter().println("<input type=\"text\" name=\"answer\" style=\"height: 50px;width: 300px;margin-left: 20px;\" placeholder=\"回复内容\" />");
				response.getWriter().println("<input type=\"submit\" value=\"回复\" style=\"margin-left: 20px;\"></input>");  
				int  id = user.getUserid();
				response.getWriter().println("<input type=\"text\" name=\"userid\" value=\""+id+"\"  style=\"display: none;\"/>");  
				System.out.println(id);	
			}else{
			//如果有回复，则显示
			response.getWriter().println("<strong style=\"color: #ff9900\"><img src=\"img/answer.gif\"/>&nbsp;&nbsp;&nbsp;&nbsp;"+user.getAnswerer()+"</strong>");     
			response.getWriter().println("	<p style=\"text-indent:4em ;\">"+user.getAnswer()+"</p>");  
			}
			response.getWriter().println("</form>");
			response.getWriter().println("</div>");     
			response.getWriter().println("</div>");     
		}//for循环结束
		response.getWriter().println("<form method=\"post\" action=\"skip\">"); //select的form表单
		response.getWriter().println("<br />一共"+a+"条记录 &nbsp;&nbsp;"+c+"/"+b+"页 <a href=\"first\" style=\"color: black;text-decoration: none;\">&nbsp;&nbsp;首页</a> &nbsp;&nbsp; &nbsp;&nbsp;<a href=\"prior\" style=\"color: black;text-decoration: none;\">上一页</a> &nbsp;&nbsp; &nbsp;&nbsp;<a href=\"next\" style=\"color: black;text-decoration: none;\" >下一页</a> &nbsp;&nbsp; &nbsp;&nbsp;<a href=\"last\" style=\"color: black;text-decoration: none;\">尾页</a> &nbsp;&nbsp; &nbsp;&nbsp;");     
		response.getWriter().println("第<select name = \"skip\" >");  
		//根据总页数来循环输出select下拉列表的每一行内容
		for(int i = 1;i<=b;i++){
			if(i == c){
				response.getWriter().println("  <option selected value =\""+i+"\">"+i+"</option>"); 
			}else{
			response.getWriter().println("  <option  value =\""+i+"\">"+i+"</option>");  
			}
		}
			response.getWriter().println("</select>");     
			response.getWriter().println("页 <input type=\"submit\" value=\"跳转\" /></form><br /><br />");  
			
		//	<!--留言内容div-->
		response.getWriter().println("	<div style=\"text-align: left;width: 96%;margin-left: 2%;background-color: #f5f4fa;border: solid 1px #7dbfdb;\">");     
		response.getWriter().println("<p style=\" background-color: #7dbfdb;padding-left: 20px;margin-top: 0px;\" ><img src=\"img/liuyan.gif\"> 我要留言 </p>");  
		response.getWriter().println("<form action=\"add\" method=\"post\" style=\"margin-left: 3%;\">");     
		response.getWriter().println("	昵称：<input type=\"text\" name=\"name\" style=\"width: 200px;\"/> 邮箱：<input type=\"text\" style=\"width: 200px;\" name=\"email\"/><br />");  
		response.getWriter().println("	标题：<input type=\"text\" style=\"width: 350px;\" name=\"headline\" /><br />");     
		response.getWriter().println("留言：<textarea rows=\"5\" cols=\"65\" name=\"content\" style=\"vertical-align:top;\"></textarea><br />");  
		response.getWriter().println("验证码：<input type=\"text\" name=\"name\" /><br />");     
		response.getWriter().println("<input type=\"submit\" value=\"提交\"style=\" margin-left: 48%;\"/><br /><br />");  
		response.getWriter().println("1.用户发表留言仅代表个人意见，并且承担一切因发表内容引起的纠纷和责任；<br />");     
		response.getWriter().println("	2.本站管理人员有权在不通知用户的情况下删除不符合规定的留言信息或留作证据；<br />");  
		response.getWriter().println("3.请客观的评价您所看到的咨询，提倡就事论事，杜绝谩骂和人生攻击等不文明行为");     
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
