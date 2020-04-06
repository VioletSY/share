package com.songyan.share.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/**
 * @author songyan
 * @date 2020年3月19日
 * @desc: 用户
 */
public class User {
	private String userName;
	private String num;
	private String id;
	private String tel;
	private String sex;
	private String headImage;
	private String password;
	private String name;
	private Date createTime;
	private Date updateTime;
	private String createTimeStr;
	private Set<Role> roles;

	public User() {
	}

	public User(String id, String userName, String password, Set<Role> roles) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.roles = roles;
	}
	
	public String getCreateTimeStr() {
		if(this.createTime !=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			createTimeStr = sdf.format(createTime) ;
		}
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
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

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

}
