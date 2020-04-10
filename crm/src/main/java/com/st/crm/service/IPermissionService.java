package com.st.crm.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.st.crm.pojo.SysPermission;
import com.st.crm.pojo.User;

public interface IPermissionService {

	/**
	 * 获取所有的一级权限信息
	 * @return
	 */
	List<SysPermission> getAll();

	/**
	 * 添加权限信息
	 * @param permission
	 * @return
	 */
	int add(SysPermission permission);

	/**
	 * 获取所有的权限信息
	 * @param limit 
	 * @param page 
	 * @param limit 
	 * @param page 
	 * @return
	 */
	PageInfo get(Integer page, Integer limit);

	/**
	 * 根据id获取权限的信息
	 * @param id
	 * @return
	 */
	SysPermission getById(Integer id);

	/**
	 * 根据权限的id修改权限的信息
	 * @param permission
	 * @return
	 */
	int update(SysPermission permission);

	/**
	 *根据权限的id移除权限的信息
	 * @param id
	 * @return
	 */
	int remove(Integer id);
	
}
