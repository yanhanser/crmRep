package com.st.crm.service;

import java.util.List;

public interface IRolePermissionService {

	/**
	 * 根据角色的id获取权限的id
	 * @param role_id
	 * @return
	 */
	List getPermission(Integer role_id);

	/**
	 * 根据角色的id修改权限的id
	 * @param permission_id
	 * @param role_id
	 * @return
	 * @throws Exception 
	 */
	int updatePermission(Integer[] permission_ids, Integer role_id) throws Exception;
}
