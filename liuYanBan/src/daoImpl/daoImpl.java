package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.User;
import util.Util;

public class daoImpl {
	Util util = Util.getInstance();
	Connection conn = null;
	PreparedStatement st;
    ResultSet rs;
    //查询所有信息
   	public List selectAll(){
   		List list= new ArrayList();
   		User user = null;
   		String sql = "SELECT * FROM  LEAVEWORD";
   		conn = util.getConnection();
   		try {
   			st = conn.prepareStatement(sql);
   			rs = st.executeQuery();
   			while(rs.next()){
   				user = new User();
   				user.setUserid(rs.getInt("userid"));
   				user.setUsername(rs.getString("username"));
   				user.setEmail(rs.getString("email"));
   				user.setHeadline(rs.getString("headline"));
   				user.setContent(rs.getString("content"));
   				user.setTime(rs.getString("time"));
   				user.setAnswerer(rs.getString("answerer"));
   				user.setAnswer(rs.getString("answer"));
   				list.add(user);
   			}
   			return list;
   		} catch (SQLException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
   			return list;
   	}
	//分页查询，a,b用于定义查询信息的序号，查询a到b之间的信息
   	public List select5(int a, int b){
   		List list= new ArrayList();
   		User user = null;
   		//String sql = "SELECT * FROM (SELECT ROWNUM RN,E.* FROM (SELECT * FROM LEAVEWORD)E)WHERE RN BETWEEN "+a+" AND "+b+"";
   		//String sql ="SELECT * FROM (SELECT ROWNUM RN,E.* FROM (SELECT * FROM LEAVEWORD)E)WHERE RN BETWEEN 1 AND 5";
   		//此sql语句用到了伪列，根据userid到序输出，可实现最后写的留言在最前面显示
   		String sql = "SELECT * FROM (SELECT ROWNUM RN,E.* FROM (SELECT * FROM LEAVEWORD  ORDER BY USERID DESC )E)WHERE RN BETWEEN "+a+" AND "+b+"";
   		conn = util.getConnection();
   		try {
   			st = conn.prepareStatement(sql);
   			rs = st.executeQuery();
   			while(rs.next()){
   				user = new User();
   				user.setUserid(rs.getInt("userid"));
   				user.setUsername(rs.getString("username"));
   				user.setEmail(rs.getString("email"));
   				user.setHeadline(rs.getString("headline"));
   				user.setContent(rs.getString("content"));
   				user.setTime(rs.getString("time"));
   				user.setAnswerer(rs.getString("answerer"));
   				user.setAnswer(rs.getString("answer"));
   				list.add(user);
   			}
   			return list;
   		} catch (SQLException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
   			return list;
   	}
   	//添加信息
   	public int add(String name,String email,String headline ,String content,String time){
   		int a = 0;
   		conn = util.getConnection();
   		//我数据库中最后两个字段为回复者和回复内容，所以这里没有写，为空
   		String sql = "INSERT INTO LEAVEWORD VALUES(LIUYANID.NEXTVAL,?,?,?,?,?,'','')";
   		try {
			st = conn.prepareStatement(sql);
			st.setString(1,name);
			st.setString(2,email);
			st.setString(3,headline);
			st.setString(4,content);
			st.setString(5,time);
			a = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
   		return a ;
   	}
   	
   	//查询数据库一共有多少条信息
   	public int count(){
   		int a = 0;
   		conn = util.getConnection();
   		String sql = "select COUNT(*) FROM LEAVEWORD";
   		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				a = rs.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
   		return a ;
   	}
   	//回复功能，通过userid找到在哪条信息里插入
   	public  int answer(int id ,String answerer,String answer){
   		int a = 0;
   		conn = util.getConnection();
   		String sql = "UPDATE LEAVEWORD SET ANSWERER = ?, ANSWER = ? WHERE USERID = ?";
   		try {
			st = conn.prepareStatement(sql);
			st.setString(1,answerer);
			st.setString(2,answer);
			st.setInt(3,id);
			a = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		return a ;
   	}
   	

   	//此main方法为测试以上方法是否可以正常使用
   	public static void main(String [] args){
   		daoImpl a= new daoImpl();
   	/*	List list = a.selectAll();
   		System.out.println(list.get(0).toString());*/
   		//a.add("李四", "123.com", "标题", "内容", "2015-10-25   15:25:36");
   		 int b = a.answer(31, "31", "313131");
   		 System.out.println("b"+b);
   		List list =a.selectAll();
   		for(int i = 0; i<list.size();i++){
   			System.out.println(list.get(i).toString());
   		}
   		
   		//System.out.println(list.get(1).toString());
   		//System.out.println(a.count());
   		
   	}

}
