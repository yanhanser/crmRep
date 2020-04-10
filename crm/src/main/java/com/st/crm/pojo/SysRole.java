package com.st.crm.pojo;

import java.util.List;

//角色的实体类
public class SysRole {

	private Integer id;
	private String role;
	private String dscb;
	
	//角色后面紧跟权限
	//权限
	private List<SysPermission> permissions;

	public List<SysPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<SysPermission> permissions) {
		this.permissions = permissions;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDscb() {
		return dscb;
	}

	public void setDscb(String dscb) {
		this.dscb = dscb;
	}

	

}
