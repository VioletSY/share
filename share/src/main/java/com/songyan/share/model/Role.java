package com.songyan.share.model;

import java.util.Set;

/**
 * @author songyan
 * @date 2020年3月19日
 * @desc: 角色类
 */
public class Role {
	private String id;
	private String roleName;
	private Set<Permissions> permissions;

	public Role(String id, String roleName, Set<Permissions> permissions) {
		this.id = id;
		this.roleName = roleName;
		this.permissions = permissions;
	}

	public Role() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<Permissions> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permissions> permissions) {
		this.permissions = permissions;
	}

}
