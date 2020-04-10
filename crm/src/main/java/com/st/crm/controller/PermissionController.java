package com.st.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.st.crm.pojo.LayUIResponse;
import com.st.crm.pojo.SysPermission;
import com.st.crm.pojo.User;
import com.st.crm.service.IPermissionService;
//权限的管理
@Controller
@RequestMapping("/permission")
public class PermissionController {

	@Autowired
	private IPermissionService permissionService;
	
	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public String add() {
		return "permission/add";
	}
	
	//添加权限
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseBody
	public Map add(SysPermission permission) {
		//获取参数
		//2.调用service层
		int res = permissionService.add(permission);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("res", res);
		
		return map;
		
	}

	//获取所有的一级菜单
	@RequestMapping("/getAll")
	@ResponseBody
	public List getAll() {
		//调用service层
		List<SysPermission> permissions = permissionService.getAll();
		
		return permissions;
	}
	
	//权限主页的转接口
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public String index() {
		return "permission/index";
	}
	
	//查询权限的全部信息
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	@ResponseBody
	public LayUIResponse indexList(Integer page,Integer limit) {
		//1.调用service层
		PageInfo pageInfo = permissionService.get(page,limit);
		
		LayUIResponse response = new LayUIResponse();
		
		response.setCount(pageInfo.getTotal());
		
		response.setData(pageInfo.getList());
		
		return response;
	}
	
	//权限修改页面的转接口
	@RequestMapping(value = "/update",method = RequestMethod.GET)
	public ModelAndView update(Integer id) {
		//1.获取参数
		//2.调用service层
		SysPermission permission = permissionService.getById(id);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("permission", permission);
		
		mv.setViewName("permission/edit");
		
		return mv;
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@ResponseBody
	public Map update(SysPermission permission) {
		//1.获取参数
		//2.调用service层
		int res = permissionService.update(permission);
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		map.put("res", res);
		 
		return map;
	}
	
	//删除权限
	@RequestMapping("/remove")
	@ResponseBody
	public Map remove(Integer id) {
		//1.获取参数
		//2.调用service层
		int res = permissionService.remove(id);
		
		HashMap<String, Object> map = new HashMap<String,Object>();
		
		map.put("res", res);
		
		return map;
		
	}
	
}
