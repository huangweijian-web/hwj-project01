package org.web.dao;

import java.util.List;

import org.web.model.UserInfo;

public interface UserInfoDao {
	/**
	 * 用户注册
	 * @param userInfo 封装了注册的信息，包括了用户名、密码、手机号
	 * @return
	 */
	public boolean register(UserInfo userinfo);
	
	/**
	 * 用户登录
	 * @param userInfo 封装了登录信息，包括用户名、密码
	 * @return
	 */
	public UserInfo login(UserInfo userinfo);
	
	/**
	 * 用户修改自己信息
	 * @param userInfo 封装了需要修改的用户信息
	 * @return
	 */
	public boolean update(UserInfo userInfo);
	
	/**
	 * 获取所有用户列表
	 * @return 
	 */
	public List<UserInfo> getallUsers();
	
	/**
	 * 根据用户Id获取用户信息
	 * @param userId
	 * @return
	 */
	public UserInfo getUserInfoByid(int userId);
	
}
