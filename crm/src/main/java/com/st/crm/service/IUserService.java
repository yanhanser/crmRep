package com.st.crm.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.st.crm.pojo.User;

public interface IUserService {

	/**
	 * 获取用户的登录信息
	 * @param user
	 * @return
	 */
	User login(User user);

	/**
	 * 获取所有的用户信息
	 * @return
	 */
	PageInfo getAll(Integer page,Integer limit);

	/**
	 * 根据用户id获取用户的信息
	 * @param id
	 * @return
	 */
	User getById(Integer id);

	/**
	 * 根据用户的id修改用户的状态信息
	 * @param id
	 * @param status
	 * @return
	 */
	int updateStatus(Integer id, Integer status);

	/**
	 * 添加用户的信息
	 * @param user
	 * @param password2
	 * @return
	 * @throws Exception 
	 */
	int addUser(User user, String password2) throws Exception;

	/**
	 * 根据用户的id更新用户信息
	 * @param user
	 * @return
	 */
	int updateUser(User user);

	/**
	 * 根据用户的id删除用户
	 * @param id
	 * @return
	 */
	int removeById(Integer id);
}
