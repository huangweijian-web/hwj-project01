package org.web.dao;

import java.util.List;

import org.web.model.Com;

public interface ComDao {
	/**
	 * ������Ʒ
	 * @param com
	 * @return
	 */
	public boolean addcom(Com com);
	/**
	 * ��ȡ��Ʒ�б�
	 * @return
	 */
	public List<Com> getallCom();
	/**
	 * ��ҳ
	 * @param page
	 * @param size
	 * @return
	 */
	public List<Com> getComPage(int page,int size);
	/**
	 * ��ȡ�ܼ�¼��
	 * @return
	 */
	public int getComCount();
	/**
	 * ɾ����Ʒ
	 * @param com
	 * @return
	 */
	public boolean deletecom(Com com);
	/**
	 * �޸���Ʒ��Ϣ
	 * @param com
	 * @return
	 */
	public boolean updatecom(Com com);
	/**
	 * ����Id��ȡ��Ʒ��Ϣ
	 * @param comId
	 * @return
	 */
	public Com getComByid(int comId);
}
