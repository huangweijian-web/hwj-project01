package org.web.factory;

import org.web.dao.AdmineDao;
import org.web.dao.ComDao;
import org.web.dao.UserInfoDao;
import org.web.daoimpl.AdmineDaoImpl;
import org.web.daoimpl.ComDaoImpl;
import org.web.daoimpl.UserInfoDaoImpl;

public class AdmineFactory {
	
	private static UserInfoDao userInfoDao;
	
	public static UserInfoDao getUserInfoDao() {
		if(userInfoDao == null) {
			userInfoDao = new UserInfoDaoImpl();
		}
		return userInfoDao ;
	}
	
	private static AdmineDao admineDao;
	
	public static AdmineDao getAdmineDao() {
		if(admineDao == null) {
			admineDao = new AdmineDaoImpl();
		}
		return admineDao ;
	}
	
	private static ComDao comDao;
	
	public static ComDao getComDao() {
		if(comDao == null) {
			comDao = new ComDaoImpl();
		}
		return comDao;
		
	}
}
