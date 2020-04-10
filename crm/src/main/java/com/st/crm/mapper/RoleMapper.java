package com.st.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.st.crm.pojo.SysRole;

@Mapper
public interface RoleMapper {

	/**
	 * 查询所有的角色信息
	 * @return
	 */
	List<SysRole> selectAll();

	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	int insert(SysRole role);

	/**
	 * 根据角色名查找角色信息
	 * @param role
	 * @return
	 */
	SysRole selectByRole(String role);

	/**
	 * 根据角色的id删除角色的信息
	 * @param id
	 * @return
	 */
	int deleteById(Integer id);

	/**
	 * 根据角色id查询角色信息
	 * @param id
	 * @return
	 */
	SysRole selectById(Integer id);

	/**
	 * 根据角色id修改角色的信息
	 * @param role
	 * @return
	 */
	int update(SysRole role);
}
