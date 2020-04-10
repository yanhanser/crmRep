package com.st.crm.service;

import java.util.List;

import com.st.crm.pojo.SysRole;

public interface IRoleService {

	/**
	 * 获取所有的角色信息
	 * @return
	 */
	List<SysRole> getAll();

	/**
	 * 添加角色信息
	 * @param role
	 * @return
	 * @throws Exception 
	 */
	int add(SysRole role) throws Exception;

	/**
	 * 根据角色的id移除角色的信息
	 * @param id
	 * @return
	 */
	int removeById(Integer id);

	/**
	 * 根据角色id获取角色信息
	 * @param id
	 * @return
	 */
	SysRole getById(Integer id);

	/**
	 * 根据角色的id修改角色信息
	 * @param role
	 * @return
	 */
	int update(SysRole role);
}
