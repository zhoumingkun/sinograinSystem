package com.toughguy.sinograin.dto;

import com.toughguy.sinograin.util.JsonUtil;

/**
 * 用户基本信息（前台）
 * 
 * */
public class UserDTO {
	
	private String userName;  //用户名
	private String phone;  //电话
	private String email;  //邮箱
	private int libraryId; //库id
	
	private String libraryName; //库名

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	
	@Override
	public String toString() {
		return JsonUtil.objectToJson(this);
	}
	
}
