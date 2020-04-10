package com.st.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.st.crm.pojo.LayUIResponse;
import com.st.crm.pojo.SysRole;
import com.st.crm.service.IRolePermissionService;
import com.st.crm.service.IRoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private IRoleService roleService;
	@Autowired
	private IRolePermissionService rolePermissionService;
	
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public String index() {
		return "role/index";
	}
	//获取所有的角色
	@RequestMapping(value = "/index",method = RequestMethod.POST)
	@ResponseBody
	public LayUIResponse indexList() {
		//1.获取参数
		//2.调用service
		List<SysRole> roles = roleService.getAll();
		
		LayUIResponse response = new LayUIResponse();
		
		response.setData(roles);
		
		return response;
	}
	
	  //添加角色页面转接口
	  @RequestMapping(value = "/add",method = RequestMethod.GET)
	  public String add() {
		  return  "role/add";
	  }
	  
	  //添加角色
	  @RequestMapping(value = "/add",method = RequestMethod.POST)
	  @ResponseBody
	  public LayUIResponse add(SysRole role) {
		  
		  LayUIResponse response = new LayUIResponse();
		  
		  //1.获取参数
		  //2.调用service层
		  int res = 0;
		try {
			
			res = roleService.add(role);
			
		} catch (Exception e) {
			
			response.setMsg(e.getMessage());
			
		}
		response.setCode(res);
		  
		  return response;
	  }
	
	  //删除角色信息
	  @RequestMapping(value = "/delete",method = RequestMethod.POST)
	  @ResponseBody
	  public Map remove(Integer id) {
		  //1.获取参数
		  //2.调用service层
		  int res = roleService.removeById(id);
		  
		  HashMap<String, Object> map = new HashMap<String,Object>();
		  
		  map.put("res", res);
		  
		  return map;

	  }
	  
	  //角色编辑页面转换
	  @RequestMapping(value = "/update",method = RequestMethod.GET)
	  public ModelAndView updateRole(Integer id) {
		  //1.获取参数
		  //2.调用service层
		   SysRole role = roleService.getById(id);
		   
		   ModelAndView mv = new ModelAndView();
		   
		   mv.addObject("role", role);
		   
		   mv.setViewName("role/edit");
		   
		   return mv;
		  
	  }
	  
	  //角色编辑
	  @RequestMapping(value = "/update",method = RequestMethod.POST)
	  @ResponseBody
	  public Map updateRole(SysRole role) {
		  //1.获取参数
		  //2.调用service层
		  int res= roleService.update(role);
		  
		  HashMap<String, Object> map = new HashMap<String,Object>();
		  
		  map.put("res", res);
		  
		  return map;
	  }
	  //设置角色权限页面
	  @RequestMapping(value = "/permission/edit",method = RequestMethod.GET)
	  public ModelAndView permissionEdit(Integer id) {
		  //1.获取参数
		  //2.调用service层(根据角色的id,获取角色的信息)
		  SysRole role = roleService.getById(id);
		  
		  ModelAndView mv = new ModelAndView();
		  
		  mv.addObject("role", role);
		  
		  mv.setViewName("role/permission");
		  
		  return mv;
	  }
	  
	  //根据角色的id获取该角色的所有权限
	  @RequestMapping(value = "/permission/get",method = RequestMethod.POST)
	  @ResponseBody
	  public List getPermission(Integer id) {
		  //1.获取参数(角色的id)
		  //2.调用service层(sys_role_permission)
		  List permissions = rolePermissionService.getPermission(id);
		  
		  return permissions;
	  }
	  
	  //修改角色权限
	  @RequestMapping(value = "/permission/update",method = RequestMethod.POST)
	  @ResponseBody
	  public LayUIResponse updatePermission (@RequestParam("permission_id[]")Integer[] permission_ids,Integer role_id) {
		  
		  LayUIResponse response = new LayUIResponse();
		  //1.获取参数
		  //2.调用service层
		  int res = 0;
		  try {
			res = rolePermissionService.updatePermission(permission_ids,role_id);
		} catch (Exception e) {
			response.setMsg(e.getMessage());
		}
		  response.setCode(res);
		  
		  return response;
	  }
	  
	  
	
}
