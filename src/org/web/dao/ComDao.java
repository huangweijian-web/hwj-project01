package org.web.dao;

import java.util.List;

import org.web.model.Com;

public interface ComDao {
	/**
	 * 新增商品
	 * @param com
	 * @return
	 */
	public boolean addcom(Com com);
	/**
	 * 获取商品列表
	 * @return
	 */
	public List<Com> getallCom();
	/**
	 * 分页
	 * @param page
	 * @param size
	 * @return
	 */
	public List<Com> getComPage(int page,int size);
	/**
	 * 获取总记录数
	 * @return
	 */
	public int getComCount();
	/**
	 * 删除商品
	 * @param com
	 * @return
	 */
	public boolean deletecom(Com com);
	/**
	 * 修改商品信息
	 * @param com
	 * @return
	 */
	public boolean updatecom(Com com);
	/**
	 * 根据Id获取商品信息
	 * @param comId
	 * @return
	 */
	public Com getComByid(int comId);
}
