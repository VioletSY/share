package com.songyan.share.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* @author songyan
* @date 2020年4月5日 
* @desc: 
*/
@Controller
@RequestMapping("personalCenter")
public class PersonalCenterController {

	/**
	 * 基本设置
	 * @return
	 */
	@RequestMapping("base")
	public String base(){
		return "personalCenter/set";
	}
	
	/**
	 * 我的消息
	 * @return
	 */
	@RequestMapping("myMessage")
	public String myMessage(){
		return "personalCenter/message";
	}
	
	/**
	 * 我的主页
	 * @return
	 */
	@RequestMapping("myHome")
	public String myHome(){
		return "community/user/home";
	}
	
}
