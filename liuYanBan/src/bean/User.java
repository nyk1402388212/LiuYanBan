package bean;

import java.util.Date;

public class User {

	private int userid;
	private String username;
	private String email;
	private String headline;
	private String content;
	private String time;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	private String answerer;
	private String answer;
	
	
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAnswerer() {
		return answerer;
	}
	public void setAnswerer(String answerer) {
		this.answerer = answerer;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public User(int userid, String username, String email, String headline, String content, String time,
			String answerer, String answer) {
		super();
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.headline = headline;
		this.content = content;
		this.time = time;
		this.answerer = answerer;
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", email=" + email + ", headline=" + headline
				+ ", content=" + content + ", time=" + time + ", answerer=" + answerer + ", answer=" + answer + "]";
	}

	public User(){};
	
	
	
}
