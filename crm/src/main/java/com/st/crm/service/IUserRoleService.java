package com.st.crm.service;

import java.util.List;

public interface IUserRoleService {

	/**
	 * 根据用户的id获取角色信息
	 * @return
	 */
	List getRole(Integer user_id);

	/**
	 * 根据用户的id，修改角色的信息
	 * @param role_id
	 * @param user_id
	 * @return
	 */
	int updateRole(Integer[] role_ids, Integer user_id);
}
