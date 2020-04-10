package com.st.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.st.crm.mapper.UserMapper;
import com.st.crm.pojo.User;
import com.st.crm.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User login(User user) {
		//调用service层
		return userMapper.select(user);
	}

	@Override
	public PageInfo getAll(Integer page,Integer limit) {
		
		PageHelper.startPage(page, limit);
		
		List<User> users = userMapper.selectAll();
		
		PageInfo pageInfo = new PageInfo(users);
		
		return pageInfo;
	}

	@Override
	public User getById(Integer id) {
		
		return userMapper.selectById(id);
	}

	@Override
	public int updateStatus(Integer id, Integer status) {
		
		return userMapper.updateById(id,status);
	}

	@Override
	public int addUser(User user, String password2) throws Exception {
		//1.进行判断
		//用户是否已经存在
		User olderUser = userMapper.selectByName(user.getUsername());
		
		if(olderUser!=null) {
			throw new Exception("用户已存在");
		} 
		
		int res = 0;
		
		if(user.getPassword().equals(password2)){
			//用户不存在
			//密码是否一致
			//一致，进行添加用户
			res = userMapper.insert(user);
		}else {
			
			throw new Exception("密码不一致");
			
		}
		
		return res;
	}

	@Override
	public int updateUser(User user) {
		
		return userMapper.updateUser(user);
	}

	@Override
	public int removeById(Integer id) {
		
		return userMapper.deleteById(id);
	}

}
