package com.st.crm.pojo;
//权限实体类
public class SysPermission {

	private Integer id;
	private String url;
	private Integer type;
	private String name;
	private String permission;
	private Integer parent;
	//父权限的名字
	private String perTowName;

	public String getPerTowName() {
		return perTowName;
	}
	public void setPerTowName(String perTowName) {
		this.perTowName = perTowName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public Integer getParent() {
		return parent;
	}
	public void setParent(Integer parent) {
		this.parent = parent;
	}
	@Override
	public String toString() {
		return "SysPermission [id=" + id + ", url=" + url + ", type=" + type + ", name=" + name + ", permission="
				+ permission + ", parent=" + parent + "]";
	}

	
}
