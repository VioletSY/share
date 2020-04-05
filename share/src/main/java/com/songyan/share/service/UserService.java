package com.songyan.share.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songyan.share.dao.UserDao;
import com.songyan.share.model.User;
import com.songyan.share.util.PageDataUtil;

/** 
* @author songyan
* @date 2020年3月22日 
* @desc: 
*/
@Service
public class UserService {
	
	@Autowired
	private UserDao dao;

	/**
	 * 获取列表数据
	 * @return
	 */
	public List<User> getList(int page,int limit) {
		List<User> userList = dao.getList(PageDataUtil.getStart(page, limit),limit); 
		return userList;
	}

	/**
	 * 获取用户列表总条数
	 * @return
	 */
	public int getListCount(int page,int limit) {
		return dao.getListCount();
	}

	/**
	 * 获取用户详情
	 * @param id
	 * @return
	 */
	public User get(String id) {
		return dao.get(id);
	}

}
