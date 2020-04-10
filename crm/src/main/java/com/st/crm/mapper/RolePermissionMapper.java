package com.st.crm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RolePermissionMapper {

	/**
	 * 根据角色的id获取权限的id
	 * @param role_id
	 * @return
	 */
	List<Map> selectPermission(Integer role_id);

	/**
	 * 根据角色的id删除角色权限的信息
	 * @param role_id
	 * @return
	 */
	int delete(Integer role_id);

	/**
	 * 批量添加角色权限的信息
	 * @param permission_ids
	 * @param role_id
	 * @return
	 */
	int insert(Integer[] permission_ids, Integer role_id);
}
