package com.songyan.share.dao;

import java.util.List;

import com.songyan.share.model.User;

/** 
* @author songyan
* @date 2020年4月5日 
* @desc: 文章
*/
public interface ArticleDao {

	List<User> getList(int start, int limit);
 
	int getListCount();

	User get(String id);

}
