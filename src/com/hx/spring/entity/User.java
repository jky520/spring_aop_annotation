package com.hx.spring.entity;
/**
 * @author @DT人 2017年7月13日 上午11:46:57
 *
 */
public class User {
	/*
	 * 主键id
	 */
	private Integer id;
	/*
	 * 用户名
	 */
	private String userName;
	/*
	 * 密码
	 */
	private String passWord;
	/*
	 * 昵称
	 */
	private String nickName;
	/*
	 * 邮箱
	 */
	private String email;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", nickName=" + nickName
				+ ", email=" + email + "]";
	}
	
}
