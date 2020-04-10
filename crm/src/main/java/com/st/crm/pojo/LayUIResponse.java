package com.st.crm.pojo;

import java.util.HashMap;
import java.util.Map;

public class LayUIResponse {

	//设置默认值
	private Integer code=0;
	private String msg="";
	private Long count=0L;
	private Object data;
	
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	//在写一个setData，保证每次使用的时候可以直接使用不需要再次创建
	public void setData(String key,String value) {
		//如果data是空的需要创建一个
		if(this.data == null) {
			//说明没有需要创建一个新的
			this.data = new HashMap<String,String>();
		}
		//将data中的key和value都添加到map集合中
		((Map)this.data).put(key, value);
	}
	
	
}
