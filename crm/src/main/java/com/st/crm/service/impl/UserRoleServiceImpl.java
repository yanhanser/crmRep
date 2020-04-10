package com.st.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.crm.mapper.UserRoleMapper;
import com.st.crm.service.IUserRoleService;

@Service
public class UserRoleServiceImpl implements IUserRoleService {

	@Autowired
	private UserRoleMapper userRoleMapper;
	
	@Override
	public List getRole(Integer user_id) {
		
		return userRoleMapper.selectRole(user_id);
	}

	@Override
	public int updateRole(Integer[] role_ids, Integer user_id) {
		//1.根据用户的id，将该用户的所有角色信息
		int res = userRoleMapper.deleteRole(user_id);
		
		//2.根据用户的id添加角色的信息
			
		res = userRoleMapper.insertRole(role_ids,user_id);
		
		return res;
	}

}
