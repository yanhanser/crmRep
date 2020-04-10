package com.st.crm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleMapper {

	/**
	 * 根据用户id查询角色信息
	 * 这里的返回值类型使用map类型进行接收即可
	 * @return
	 */
	List<Map> selectRole(Integer user_id);

	/**
	 * 根据用户的id删除所有的角色信息
	 * @param user_id
	 * @return
	 */
	int deleteRole(Integer user_id);

	/**
	 * 根据用户的id添加角色信息
	 * @param user_id 
	 * @param role_ids
	 * @return
	 */
	int insertRole(Integer[] role_ids, Integer user_id);
}
