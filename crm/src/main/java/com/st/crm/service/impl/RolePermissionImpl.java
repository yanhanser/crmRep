package com.st.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.crm.mapper.RolePermissionMapper;
import com.st.crm.service.IRolePermissionService;

@Service
public class RolePermissionImpl implements IRolePermissionService {

	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	
	@Override
	public List getPermission(Integer role_id) {
		
		return rolePermissionMapper.selectPermission(role_id);
	}

	@Override
	public int updatePermission(Integer[] permission_ids, Integer role_id) throws Exception {
		//1.根据角色id查询权限id
		List permissionList = rolePermissionMapper.selectPermission(role_id);
		if(permissionList.size()==0) {
			try {
				
				int res = rolePermissionMapper.insert(permission_ids,role_id);
				
				if(res>0) {
					//添加成功
					return res;
				}else {
					//添加失败
					throw new Exception("添加失败");
				}
			} catch (Exception e) {
				
				throw new Exception("添加失败");
			}
			
		}else {
			try {
				//有权限
				//2.根据角色id删除所有的权限
				int res = rolePermissionMapper.delete(role_id);
				
				if(res>0) {
					//删除成功
					//2.根据角色id批量添加权限id
					res = rolePermissionMapper.insert(permission_ids,role_id);
					
					if (res>0) {
						//添加成功
						return res;
					}else {
						//添加失败
						throw new Exception("添加失败");
					}
		
				}else {
					//删除失败
					throw new Exception("删除权限失败");
				}
			} catch (Exception e) {
					throw new Exception("添加失败");
			}
		}
		
	
	}

}
