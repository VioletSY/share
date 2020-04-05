package com.songyan.share.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.songyan.share.dao.UserDao;
import com.songyan.share.model.User;
import com.songyan.share.service.LoginService;

/** 
* @author songyan
* @date 2020年3月19日 
* @desc: 
*/
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private UserDao dao;

	/**
	 * 通过用户名获取用户信息
	 */
    @Override
    public User getUserByName(String userName) {
        return dao.getByUserName(userName);
    }

}
