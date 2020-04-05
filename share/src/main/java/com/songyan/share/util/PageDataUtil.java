package com.songyan.share.util;

/** 
* @author songyan
* @date 2020年3月22日 
* @desc 分页计算工具类
*/
public class PageDataUtil {

	/**
	 * 获取开始的页码
	 * @param page
	 * @param limit
	 * @return
	 */
	public static int getStart(int page,int limit){
		return (page-1)*limit;
	}
	
}
