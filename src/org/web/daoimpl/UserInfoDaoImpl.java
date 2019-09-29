package org.web.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.web.dao.UserInfoDao;
import org.web.model.UserInfo;
import org.web.uilt.DBOperation;
import org.web.uilt.DBUtils;


public class UserInfoDaoImpl implements UserInfoDao{

	
	//用户注册
	@Override
	public boolean register(UserInfo userinfo) {
		String sql = "insert into userinfo(userName,userPass) values(?,?)";
		Object[] values= {userinfo.getUserName(),userinfo.getUserPass(),};
		int result = DBOperation.update_delete_insert(sql, values);
		return result > 0;
	}

	//用户登录
	@Override
	public UserInfo login(UserInfo userinfo) {
		UserInfo us = null;
		String sql = "select * from userinfo where userName=? and userPass=?";
		Object[] values = {userinfo.getUserName(),userinfo.getUserPass()};
		ResultSet rs = DBOperation.select(sql, values);
		try {
			if(rs.next()) {
				us = new UserInfo();
				us.setUserId(rs.getInt("userId"));
				us.setUserName(rs.getString("userName"));
				us.setUserPass(rs.getString("userPass"));
				us.setMobilePhone(rs.getString("mobilePhone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(null, null, rs);
		}
		return us;
	}
	//用户修改自己信息
	@Override
	public boolean update(UserInfo userInfo) {
		String sql = "update userinfo set userName=?,userPass=?,mobilePhone=? where userId=?";
		Object[] values = {userInfo.getUserName(),userInfo.getUserPass(),
							userInfo.getMobilePhone(),userInfo.getUserId()};
		int result = DBOperation.update_delete_insert(sql, values);
		return result > 0;
	}
	//获取用户列表信息
	@Override
	public List<UserInfo> getallUsers() {
		List<UserInfo> userInfoList = new LinkedList<UserInfo>();
		String sql = "select * from userInfo";
		Object[] values = null;
		ResultSet rs = DBOperation.select(sql, values);
		try {
			while(rs.next()) {
				UserInfo userInfo = new UserInfo();
				userInfo.setUserId(rs.getInt("userId"));
				userInfo.setUserName(rs.getString("userName"));
				userInfo.setUserPass(rs.getString("userPass"));
				userInfo.setMobilePhone(rs.getString("mobilePhone"));
				userInfoList.add(userInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(null, null, rs);
		}
		return userInfoList;
	}
	
	//根据用户Id获取用户信息
	@Override
	public UserInfo getUserInfoByid(int userId) {
		UserInfo userInfo= null;
		String sql = "select * from userinfo where userId=?";
		Object[] values = {userId};
		ResultSet rs = DBOperation.select(sql, values);
		try {
			while(rs.next()) {
				userInfo = new UserInfo();
				userInfo.setUserId(rs.getInt("userId"));
				userInfo.setUserName(rs.getString("userName"));
				userInfo.setUserPass(rs.getString("userPass"));
				userInfo.setMobilePhone(rs.getString("mobilePhone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(null, null, rs);
		}
		return userInfo;
	}


}
