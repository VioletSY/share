package com.songyan.share.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.songyan.share.model.User;

/** 
* @author songyan
* @date 2020年3月22日 
* @desc: 
*/
public interface UserDao {

	@Select("select id,username,name,usernumber,sex,tel,headimage from user limit #{start},#{start}")
	List<User> getList(@Param("start")int start,@Param("limit")int limit);

	@Select("select count(1) from user")
	int getListCount();

}
