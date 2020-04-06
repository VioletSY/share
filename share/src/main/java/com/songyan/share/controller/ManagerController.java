package com.songyan.share.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.songyan.share.model.ReturnObj;
import com.songyan.share.service.ManagerService;

/** 
* @author songyan
* @date 2020年4月6日 
* @desc: 
*/
@Controller
@RequestMapping("manager")
public class ManagerController {
	
	@Autowired
	private ManagerService service;

	/**
	 * 列表界面
	 * @return
	 */
	@RequestMapping("managerList")
	public String managerList(){
		return "manager/managerList";
	}
	
	/**
	 * 获取列表数据
	 * @return
	 */
	@RequestMapping("getList")
	@ResponseBody
	public ReturnObj getList(int page,int limit) {
		return new ReturnObj(service.getManagerList(page,limit),service.getManagerListCount(page,limit),0);
	}

}
