package com.songyan.share.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

/** 
* @author songyan
* @date 2020年3月22日 
* @desc: 
*/
public interface MenuDao {
	
	/**  
	* 查询一级菜单
	*/  
	@Select( "SELECT MKBH AS MGID,MKMC AS MNAME,coalesce(ICON,'icon-cogs') AS MCLASS,URL AS MURL, "
			+ " (CASE WHEN LENGTH(MKBH)=2 THEN '0' ELSE SUBSTR(MKBH,1,LENGTH(MKBH)-2) END) MPARENT "
			+ " FROM SYS_MKB"
			+ " WHERE LENGTH(MKBH)=2 ORDER BY XH,MKBH")
	public List<Map<String, Object>> getYjcdList();
	
	/**  
	* 查询二级菜单
	*/  
	@Select( "SELECT MKBH AS MGID,MKMC AS MNAME,coalesce(ICON,'icon-cogs') AS MCLASS,URL AS MURL, "
			+ " (CASE WHEN LENGTH(MKBH)=2 THEN '0' ELSE SUBSTR(MKBH,1,LENGTH(MKBH)-2) END) MPARENT "
			+ " FROM SYS_MKB T WHERE LENGTH(MKBH)=4 AND SUBSTR(MKBH,1,2)=#{0} ORDER BY XH,MKBH  ")
	public List<Map<String, Object>> getEjcdList(String mkbh);
	
	/**  
	* 查询三级菜单
	*/  
	@Select( "SELECT MKBH AS MGID,MKMC AS MNAME,coalesce(ICON,'icon-cogs') AS MCLASS,URL AS MURL, "
			+ " (CASE WHEN LENGTH(MKBH)=2 THEN '0' ELSE SUBSTR(MKBH,1,LENGTH(MKBH)-2) END) MPARENT "
			+ " FROM SYS_MKB"
			+ " WHERE LENGTH(MKBH)=6 AND SUBSTR(MKBH,1,4)=#{0} ORDER BY XH,MKBH  ")
	public List<Map<String, Object>> getSjcdList(String mkbh);
	
}
