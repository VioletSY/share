package com.songyan.share.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/** 
* @author songyan
* @date 2020年4月5日 
* @desc: 
*/
public class PasswordUtil {
	
	/**
	 * 密码加密
	 * @param username 
	 * @return
	 */
	public static String encryption(String pwd, String username) {
		//加密方式
        String hashAlgorithmName = "MD5";
        //加密次数
        int hashInteractions = 1024;
        //盐值 
        ByteSource salt = ByteSource.Util.bytes(username);
        return new SimpleHash(hashAlgorithmName, pwd, salt, hashInteractions).toHex();
	}

}
