package com.st.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.st.crm.mapper.PermissionMapper;
import com.st.crm.pojo.SysPermission;
import com.st.crm.pojo.User;
import com.st.crm.service.IPermissionService;

@Service
public class PermissionServiceImpl implements IPermissionService{

	@Autowired
	private PermissionMapper permissionMapper;
	
	@Override
	public List<SysPermission> getAll() {
		
		return permissionMapper.selectAll();
	}

	@Override
	public int add(SysPermission permission) {
		
		return permissionMapper.insert(permission);
	}

	//获取所有的权限信息
	@Override
	public PageInfo get(Integer page,Integer limit) {
		
		if(page!=null && limit!=null) {
			
			PageHelper.startPage(page, limit);
		}
		
		List<SysPermission> permissions = permissionMapper.select();
		
		PageInfo pageInfo = new PageInfo(permissions);
		
		return pageInfo;
	}

	@Override
	public SysPermission getById(Integer id) {
		
		SysPermission permission = permissionMapper.selectById(id);
		
		return permission;
	}

	@Override
	public int update(SysPermission permission) {
		
		int res = permissionMapper.update(permission);
		
		return res;
	}

	@Override
	public int remove(Integer id) {
		
		return permissionMapper.delete(id);
	}
	
}
