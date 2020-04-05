package com.songyan.share.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* @author songyan
* @date 2020年4月5日 
* @desc 社区
*/
@Controller
@RequestMapping("community")
public class CommunityController {
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("index")
	public String index(){
		return "community/jie/index";
	}
	
	/**
	 * 文章详情
	 * @return
	 */
	@RequestMapping("articleDetail")
	public String articleDetail(){
		return "community/jie/detail";
	}
	
	/**
	 * 发表新帖
	 * @return
	 * user/index.html#collection
	 */
	@RequestMapping("publishNew")
	public String publishNew(){
		return "community/jie/add";
	}
	
	/**
	 * 用户主页
	 * @return
	 */
	@RequestMapping("userHome")
	public String userHome(){
		return "community/user/home";
	}
	
	
	
}
