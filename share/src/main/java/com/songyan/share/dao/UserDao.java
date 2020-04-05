package com.songyan.share.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.songyan.share.model.Permissions;
import com.songyan.share.model.Role;
import com.songyan.share.model.User;

/** 
* @author songyan
* @date 2020年3月22日 
* @desc: 
*/
public interface UserDao {

	/**
	 * 检索列表
	 * @param start
	 * @param limit
	 * @return
	 */
	@Select("select id,username,name,num,sex,tel,headimage from sys_user limit #{start},#{limit}")
	List<User> getList(@Param("start") int start, @Param("limit") int limit);

	/**
	 * 检索符合条件的用户数量
	 * @return
	 */
	@Select("select count(1) from sys_user")
	int getListCount();

	/**
	 * 获取用户的详细信息
	 * @param id 用户id
	 * @return
	 */
	@Select("select a.id,a.name,b.user_id userId from sys_user a left join sys_link_user_role b on a.id = b.user_id where a.id = #{id} GROUP BY a.id,a.name ")
	@Results({ @Result(id = true, column = "id", property = "id") ,
			@Result(id = true, column = "id", property = "id") ,
			@Result(column = "username", property = "userName") ,
			@Result(column = "name", property = "name"),
			@Result(column = "num", property = "num") ,
			@Result(column = "sex", property = "sex") ,
			@Result(column = "tel", property = "tel") ,
			@Result(column = "headimage", property = "headImage") ,
			@Result(property="roles",many=@Many(select="selByUserId"),column="{userId=userId}")})
	User get(String id);

	/**
	 * 获取用户的详细信息
	 * @param userName
	 * @return
	 */
	@Select("select a.id,a.username,b.user_id userId,a.password from sys_user a left join sys_link_user_role b on a.id = b.user_id where a.username = #{userName} GROUP BY a.id,a.name ")
	@Results({ @Result(id = true, column = "id", property = "id") ,
			@Result(id = true, column = "id", property = "id") ,
			@Result(column = "username", property = "userName") ,
			@Result(column = "name", property = "name"),
			@Result(column = "num", property = "num") ,
			@Result(column = "sex", property = "sex") ,
			@Result(column = "tel", property = "tel") ,
			@Result(column = "headimage", property = "headImage") ,
			@Result(property="roles",many=@Many(select="selByUserId"),column="{userId=userId}")})
	User getByUserName(String userName);
	
	/**
	 * 根据用户id获取用户的角色集合
	 * @param map
	 * @return
	 */
	@Select("select d.id,d.code,d.name,d.num from  sys_link_user_role b left join sys_role d on b.role_id = d.id where b.user_id = #{userId} ")
	@Results({ @Result(id = true, column = "id", property = "id") ,
		@Result(id = true, column = "id", property = "id") ,
		@Result(column = "code", property = "code") ,
		@Result(property="permissions",many=@Many(select="selByRoleId"),column="{roleId=id}")})
	Set<Role> selByUserId(Map<String,Object> map);
	
	/**
	 * 根据用角色的id获取角色对应的权限集合
	 * @param map
	 * @return
	 */
	@Select("select b.id,b.code,b.name,b.num from  sys_link_role_permission a left join sys_permission b on a.permission_id = b.id where a.role_id = #{roleId}")
	Set<Permissions> selByRoleId(Map<String,Object> map);

}
