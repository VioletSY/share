package com.songyan.share.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.druid.support.json.JSONParser;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.songyan.share.info.SystemInfo;
import com.songyan.share.service.MenuService;

/** 
* @author songyan
* @date 2020年3月22日 
* @desc: 系统主界面
*/
@Controller
public class MainController {
	 
	@Autowired
	private MenuService service;

	/**
	 * 系统主页
	 * @param map
	 * @return
	 */
	@RequestMapping("main")
	public String index(Map<String,Object> map) {
		map.put("sysname", SystemInfo.appName);
		return "main";
	}
	
	/**
	 * 系统首页
	 * @return
	 */
	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	/**
	 * 获取菜单列表
	 * @return
	 */
	@RequestMapping(value="/getMenuListnew")
	@ResponseBody
	public Object getMenuListnew(){
		return new Gson().toJson(service.getMenuListnew());
	}
}
