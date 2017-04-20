package com.tayo2000.ssm.po;

import java.util.List;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
	@NotEmpty(message="用户名必须填")
	private String username;
	@NotEmpty(message="密码必须填")
	private String password;
	@Email(message="检查邮件地址")
	private String email;
	private String roleId;
	private String fNo;
	private int loginState;
	private int loginCount;
	private String  loginTime;
	private List<String> urlList; //可以访问的URL列表
	
	@NotEmpty(message="验证码必须填")
	private String verifycode;  //用户验证码
	
	public String getVerifycode() {
		return verifycode;
	}
	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getfNo() {
		return fNo;
	}
	public void setfNo(String fNo) {
		this.fNo = fNo;
	}
	public int getLoginState() {
		return loginState;
	}
	public void setLoginState(int loginState) {
		this.loginState = loginState;
	}
	public int getLoginCount() {
		return loginCount;
	}
	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}
	
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public List<String> getUrlList() {
		return urlList;
	}
	public void setUrlList(List<String> urlList) {
		this.urlList = urlList;
	}
	public String toString(){
		StringBuffer sb=new StringBuffer("");
		sb.append(username).append("\t");
		sb.append(password).append("\t");
		sb.append(email).append("\t");
		sb.append(roleId).append("\t");
		sb.append(fNo).append("\t");
		sb.append(loginState).append("\t");
		sb.append(loginCount).append("\t");
		sb.append(loginTime).append("\t");
		String str=sb.toString();
		sb.delete(0, sb.length());
		return str;
	}
	
}
