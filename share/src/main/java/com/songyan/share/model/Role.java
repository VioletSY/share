package com.songyan.share.model;

import java.util.Set;

/**
 * @author songyan
 * @date 2020年3月19日
 * @desc: 角色类
 */
public class Role {
	private String id;
	private String name;
	private String code;
	private int num;
	private Set<Permissions> permissions;
	
	public Role(String id, String name, Set<Permissions> permissions) {
		this.id = id;
		this.name = name;
		this.permissions = permissions;
	}

	public Role() {
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

	public Set<Permissions> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permissions> permissions) {
		this.permissions = permissions;
	}

}
