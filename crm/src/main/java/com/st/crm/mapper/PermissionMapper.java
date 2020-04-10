package com.st.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.st.crm.pojo.SysPermission;
import com.st.crm.pojo.User;
@Mapper
public interface PermissionMapper {

	/**
	 * 获取所有的一级权限信息
	 * @return
	 */
	List<SysPermission> selectAll();

	/**
	 * 添加权限信息
	 * @param permission
	 * @return
	 */
	int insert(SysPermission permission);

	/**
	 * 查询所有的权限信息
	 * @return
	 */
	List<SysPermission> select();

	/**
	 * 根据权限的id查询权限的信息
	 * @param id
	 * @return
	 */
	SysPermission selectById(Integer id);

	/**
	 * 根据父权限的id查询父权限的权限信息
	 * @param parent
	 * @param id 
	 * @return
	 */
	SysPermission selectByParent(Integer parent, Integer id);

	/**
	 * 根据权限的id进行修改权限的信息
	 * @param permission
	 * @return
	 */
	int update(SysPermission permission);

	/**
	 * 根据权限的id，删除权限的信息
	 * @param id
	 * @return
	 */
	int delete(Integer id);

}
