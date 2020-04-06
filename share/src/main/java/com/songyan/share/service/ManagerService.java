package com.songyan.share.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songyan.share.dao.UserDao;
import com.songyan.share.model.User;
import com.songyan.share.util.PageDataUtil;

/** 
* @author songyan
* @date 2020年4月6日 
* @desc: 
*/
@Service 
public class ManagerService {
	
	@Autowired
	private UserDao dao;

	/**
	 * 获取列表数据
	 * @return
	 */
	public List<User> getManagerList(int page,int limit) {
		List<User> managerList = dao.getManagerList(PageDataUtil.getStart(page, limit),limit); 
		return managerList;
	}

	/**
	 * 获取列表总条数
	 * @return
	 */
	public int getManagerListCount(int page,int limit) {
		return dao.getManagerListCount();
	}
	

}
