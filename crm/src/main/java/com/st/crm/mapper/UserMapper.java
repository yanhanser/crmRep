package com.st.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.st.crm.pojo.User;

@Mapper
public interface UserMapper {

	/**
	 * 通过用户的账号和密码查询用户信息
	 * @param user
	 * @return
	 */
	User select(User user);

	/**
	 * 查询所有的用户信息
	 * @return
	 */
	List<User> selectAll();

	/**
	 * 通过用户的id查询用户的信息
	 * @param id
	 * @return
	 */
	User selectById(Integer id);

	/**
	 * 根据用户的id修改用户的状态信息
	 * @param id
	 * @param status
	 * @return
	 */
	int updateById(Integer id, Integer status);

	/**
	 * 根据用户的名字进行查询
	 * @param username
	 * @return
	 */
	User selectByName(String username);

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	int insert(User user);

	/**
	 * 根据用户的id修改用户的信息
	 * @param user
	 * @return
	 */
	int updateUser(User user);

	/**
	 * 根据用户的id进行删除用户
	 * @param id
	 * @return
	 */
	int deleteById(Integer id);
}
