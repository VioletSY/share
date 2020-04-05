package com.songyan.share.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.songyan.share.model.ReturnObj;
import com.songyan.share.service.ArticleService;

/** 
* @author songyan
* @date 2020年4月5日 
* @desc: 文章管理
*/
@Controller
@RequestMapping("article")
public class ArticleController {
	
	@Autowired
	private ArticleService service;

	/**
	 * 列表界面
	 * @return
	 */
	@RequestMapping("list")
	public String userList(){
		return "article/articleList";
	}
	
	/**
	 * 详情界面
	 * @return
	 */
	@RequestMapping("toDetail")
	public String toDetail(){
		return "article/articleDetail";
	}
	
	/**
	 * 我发表的帖
	 * @return
	 */
	@RequestMapping("myPublish")
	public String myPublish(){
		return "community/user/index";
	}

	/**
	 * 我收藏的帖
	 * @return
	 * user/index.html#collection
	 */
	@RequestMapping("myCollection")
	public String myCollection(){
		return "community/user/index";
	}
	
	
	/**
	 * 获取列表数据
	 * @return
	 */
	@RequestMapping("getList")
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
