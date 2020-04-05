package com.songyan.share.controller;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.songyan.share.info.SystemInfo;
import com.songyan.share.model.ReturnCode;
import com.songyan.share.model.ReturnObj;
import com.songyan.share.model.User;

/**
 * @author songyan
 * @date 2020年3月19日
 * @desc: 登录
 */
@Controller
public class LoginController {

	/**
	 * 跳转至登录界面
	 * @return
	 */
	@RequestMapping("login")
	public String test(Map<String,Object> map) {
		map.put("sysname", SystemInfo.appName);
		return "login";
	}

	/**
	 * 登录
	 * @param user
	 * @return
	 */
	@RequestMapping("/doLogin")
	@ResponseBody
	public Object doLogin(@RequestBody User user) {
		// 添加用户认证信息
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUserName(), user.getPassword());
		try {
			// 进行验证，这里可以捕获异常，然后返回对应信息
			subject.login(usernamePasswordToken);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return new ReturnObj("账号或密码错误！", ReturnCode.ERROR_CODE);
		}
		return new ReturnObj("登录成功");
	}

	/**
	 * 
	 * @return
	 */
	@RequiresRoles("admin")
	@RequiresPermissions("add")
	@RequestMapping("/index22")
	public String index() {
		return "index!";
	}
}
