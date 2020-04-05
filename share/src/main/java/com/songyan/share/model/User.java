package com.songyan.share.model;

import java.util.Set;

/**
 * @author songyan
 * @date 2020年3月19日
 * @desc: 用户
 */
public class User {
	private String userName;
	private String userNumber;
	private String id;
	private String tel;
	private String sex;
	private String headImage;
	private String password;
	private String name;
	private Set<Role> roles;

	public User() {
	}

	public User(String id, String userName, String password, Set<Role> roles) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.roles = roles;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Role> getRoleSet() {
		return roles;
	}

	public void setRoleSet(Set<Role> roles) {
		this.roles = roles;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
