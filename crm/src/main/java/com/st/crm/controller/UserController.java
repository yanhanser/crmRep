package com.st.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.st.crm.pojo.LayUIResponse;
import com.st.crm.pojo.User;
import com.st.crm.service.IUserRoleService;
import com.st.crm.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;
	@Autowired
	private IUserRoleService userRoleService;
	
	//实现主页面的转接口(登录后的主界面)
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	//登录页面的转接口
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login() {
		
		return "login";
		
	}
	//实现用户的登录
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public ModelAndView login(User user1,HttpSession session) {
		//1.获取参数
		//2.调用service层
		User loginUser = userService.login(user1);
		
		ModelAndView mv = new ModelAndView();
		
		if(loginUser!=null) {
			//登录成功
			//写入将用户信息写入session中
			session.setAttribute("user", loginUser);
			//跳转到主页中,重定向
			mv.setViewName("redirect:index");
		}else {
			//登录失败
			//提示错误信息
			mv.addObject("error","账号或密码错误!");
			mv.setViewName("login");
		}
		
		return mv;
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		//清除session
		session.removeAttribute("user");
		
		return "redirect:login";
	}
	
	//修改用户资料
	
	//用户管理的主页面转接口
	@RequestMapping(value = "/user/index",method = RequestMethod.GET)
	public String userindex() {
		return "user/index";
	}
	
	//用户管理的主页(用户列表)
	@RequestMapping(value = "/user/list",method = RequestMethod.POST)
	@ResponseBody
	public LayUIResponse userIndex(Integer page,Integer limit) {
		//1.获取参数
		//2.调用service层
		PageInfo pageInfo = userService.getAll(page,limit);
		
		LayUIResponse response = new LayUIResponse();
		
		response.setCount(pageInfo.getTotal());
		
		response.setData(pageInfo.getList());
		
		return response;
	}
	
	//用户角色编辑的转接口
	@RequestMapping(value = "/user/role/edit",method = RequestMethod.GET) 
	public ModelAndView roleEdit(Integer id) { 
		//1.获取参数
		//2.调用service层 
		//获取用户信息
		User user = userService.getById(id);
		  
		ModelAndView mv = new ModelAndView();
		  
		mv.addObject("userRole", user);
		  
		mv.setViewName("user/role");
		  
		return mv;
	}
	  
	  //根据用户的id获取用户的角色
	  @RequestMapping(value = "user/role/get",method = RequestMethod.POST)
	  @ResponseBody
	  public List getRole(Integer id) {
		  //1.获取参数
		  //2.调用service层
		 List roles =  userRoleService.getRole(id);
		 
		 return roles;
	  }
	  
	 //根据用户的id进行修改角色的信息
	  @RequestMapping(value = "/user/role/update",method = RequestMethod.POST)
	  @ResponseBody
	  public Map updateRole(@RequestParam("role_id[]")Integer[] role_ids,Integer user_id) {
		  //1.获取参数
		  //2.调用service层
		  int res = userRoleService.updateRole(role_ids,user_id);
		  
		  HashMap<String, Object> map = new HashMap<String,Object>();
		  
		  map.put("res", res);
		  
		  return map;
	
	  }
	  
	  //添加用户转接口
	  @RequestMapping(value = "/user/add",method = RequestMethod.GET)
	  public String addUser() {
		  return "user/add";
	  }
	  
	  //根据用户的id,修改用户的状态
	  @RequestMapping(value = "/user/updateStatus",method = RequestMethod.POST)
	  @ResponseBody
	  public Map updateStatus(Integer id,Integer status) {
		  //1.获取参数
		  //2.调用service层
		  int res = userService.updateStatus(id,status);
		  
		  HashMap<String, Object> map = new HashMap<String,Object>();
		  
		  map.put("res", res);
		  
		  return map;
		  
	  }
	  
	  //添加用户
	  @RequestMapping(value = "/user/add",method = RequestMethod.POST)
	  @ResponseBody
	  public LayUIResponse addUser(User user,String password2) {
		  //1.获取参数
		  //2.调用service层
		  
		LayUIResponse response = new LayUIResponse();
		
		int res = 0;
		
		try{
			res = userService.addUser(user,password2);
			
		} catch (Exception e) {
			
			response.setMsg(e.getMessage());
			
		}
		response.setCode(res);
		  
		return response;
		  
	  }
	  
	  //修改用户页面转接口(根据用户的id进行修改)
	  @RequestMapping(value = "/user/update",method = RequestMethod.GET)
	  public ModelAndView updateUser(Integer id) {
		  //1.获取参数
		  //2.调用service层
		  User user = userService.getById(id);
		  
		  ModelAndView mv = new ModelAndView();
		  
		  mv.addObject("userById", user);
		  
		  mv.setViewName("user/edit");
		  
		  return mv;
	  }
	  
	  //修改用户的信息
	  @RequestMapping(value = "/user/update",method = RequestMethod.POST)
	  @ResponseBody
	  public Map updateUser(User user) {
		  //1.获取参数
		  //2.调用service层
		  int res = userService.updateUser(user);
		  
		  HashMap<String, Object> map = new HashMap<String,Object>();
		  
		  map.put("res", res);
		  
		  return map;
	  }
	  
	  //根据用户id删除用户
	  @RequestMapping(value = "/user/delete",method = RequestMethod.POST)
	  @ResponseBody
	  public Map remove(Integer id) {
		  //1.获取参数
		  //2.调用service层
		  int res = userService.removeById(id);
		  
		  HashMap<String, Object> map = new HashMap<String,Object>();
		  
		  map.put("res", res);
		  
		  return map;
	  }
	
	
}
