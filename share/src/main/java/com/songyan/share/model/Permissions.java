package com.songyan.share.model;

/**
 * @author songyan
 * @date 2020年3月19日
 * @desc: 权限类
 */
public class Permissions {
	private String id;
	private String name;
	private String code;
	private int num;
	public Permissions() {
	}
	public Permissions(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
