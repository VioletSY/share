package com.songyan.share.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.songyan.share.model.ReturnObj;
import com.songyan.share.service.UserService;

/** 
* @author songyan
* @date 2020年3月22日 
* @desc: 
*/
@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService service;

	/**
	 * 用户列表界面
	 * @return
	 */
	@RequestMapping("userList")
	public String userList(){
		return "user/userList";
	}
	
	/**
	 * 添加新用户
	 * @return
	 */
	@RequestMapping("addUser")
	public String addUser(){
		return "user/addUser";
	}
	
	/**
	 * 获取用户列表数据
	 * @return
	 */
	@RequestMapping("getUserList")
	@ResponseBody
	public ReturnObj getUserList(int page,int limit) {
		return new ReturnObj(service.getList(page,limit),service.getListCount(page,limit),0);
	}
	
	/**
	 * 获取详细数据
	 * @return
	 */
	@RequestMapping("get")
	@ResponseBody
	public ReturnObj get(String id) {
		return new ReturnObj(service.get(id));
	}
	
}
