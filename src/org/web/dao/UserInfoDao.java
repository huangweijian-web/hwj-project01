package org.web.dao;

import java.util.List;

import org.web.model.UserInfo;

public interface UserInfoDao {
	/**
	 * �û�ע��
	 * @param userInfo ��װ��ע�����Ϣ���������û��������롢�ֻ���
	 * @return
	 */
	public boolean register(UserInfo userinfo);
	
	/**
	 * �û���¼
	 * @param userInfo ��װ�˵�¼��Ϣ�������û���������
	 * @return
	 */
	public UserInfo login(UserInfo userinfo);
	
	/**
	 * �û��޸��Լ���Ϣ
	 * @param userInfo ��װ����Ҫ�޸ĵ��û���Ϣ
	 * @return
	 */
	public boolean update(UserInfo userInfo);
	
	/**
	 * ��ȡ�����û��б�
	 * @return 
	 */
	public List<UserInfo> getallUsers();
	
	/**
	 * �����û�Id��ȡ�û���Ϣ
	 * @param userId
	 * @return
	 */
	public UserInfo getUserInfoByid(int userId);
	
}
