package com.st.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.crm.mapper.RoleMapper;
import com.st.crm.pojo.SysRole;
import com.st.crm.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public List<SysRole> getAll() {
		
		return roleMapper.selectAll();
	}

	@Override
	public int add(SysRole role) throws Exception {
		
		//1.角色名是否存在
		SysRole sysRole = roleMapper.selectByRole(role.getRole());
		
		int res = 0;
		
		if(sysRole==null) {
			//用户名不存在，添加
			res = roleMapper.insert(role);
			
			if(res>0) {
				return res;
			}else {
				//添加失败
				throw new Exception("添加失败");
			}
			
		}else {
			//用户名存在，提示错误信息
			throw new Exception("用户已经存在");
		}
	}

	@Override
	public int removeById(Integer id) {
		
		return roleMapper.deleteById(id);
	}

	@Override
	public SysRole getById(Integer id) {
		
		return roleMapper.selectById(id);
	}

	@Override
	public int update(SysRole role) {
		
		return roleMapper.update(role);
	}

}
