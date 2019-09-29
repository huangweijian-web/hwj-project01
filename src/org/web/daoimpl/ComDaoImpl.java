package org.web.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.web.dao.ComDao;
import org.web.model.Com;
import org.web.uilt.DBOperation;
import org.web.uilt.DBUtils;

public class ComDaoImpl implements ComDao{
	//������Ʒ
	@Override
	public boolean addcom(Com com) {
		String sql = "insert into com(comName,comType,origin,price) values(?,?,?,?)";
		Object[] values = {com.getComName(),com.getComType(),com.getOrigin(),com.getPrice()};
		int result = DBOperation.update_delete_insert(sql, values);
		return result > 0;
	}
	//��ȡ��Ʒ�б�
	@Override
	public List<Com> getallCom() {
		List<Com> comList = new LinkedList<Com>();
		String sql = "select * from com";
		Object[] values = null;
		ResultSet rs = DBOperation.select(sql, values);
		try {
			while( rs.next()) {
				Com com = new Com();
				com.setComId(rs.getInt("comId"));
				com.setComName(rs.getString("comName"));
				com.setComType(rs.getString("comType"));
				com.setOrigin(rs.getString("origin"));
				com.setPrice(rs.getDouble("price"));	
				comList.add(com);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(null, null, rs);
		}
		return comList;
	}
	//��Ʒ�б��ҳ��ʾ
	@Override
	public List<Com> getComPage(int page, int size) {
		List<Com> comList = new LinkedList<Com>();
		String sql = "select * from com limit ?,?";
		Object[] values = {(page-1)*size,size};
		ResultSet rs = DBOperation.select(sql, values);
		try {
			while(rs.next()) {
				Com com = new Com();
				com.setComId(rs.getInt("comId"));
				com.setComName(rs.getString("comName"));
				com.setComType(rs.getString("comType"));
				com.setOrigin(rs.getString("origin"));
				com.setPrice(rs.getDouble("price"));
				comList.add(com);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(null, null, rs);
		}
		return comList;
	}
	//��ȡ��Ʒ�ܼ�¼��
	@Override
	public int getComCount() {
		int counts = 0;
		String sql = "select count(comId) from com";
		Object[] values = null ;
		ResultSet rs = DBOperation.select(sql, values);
		try {
			if(rs.next()) {
				counts = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(null, null, rs);
		}
		return counts;
	}
	//ɾ����Ʒ
	@Override
	public boolean deletecom(Com com) {
		String sql = "delete from com where comId=?";
		Object[] values = {com.getComId()};
		int result = DBOperation.update_delete_insert(sql, values);
		return result > 0;
	}
	//�޸���Ʒ��Ϣ
	@Override
	public boolean updatecom(Com com) {
		String sql = "update com set comName=?,comType=?,origin=?,price=? where comId=?";
		Object[] values = {com.getComName(),com.getComType(),com.getOrigin(),com.getPrice(),com.getComId()};
		int result = DBOperation.update_delete_insert(sql, values);
		return result > 0;
	}
	//����Id��ȡ��Ʒ��Ϣ
	@Override
	public Com getComByid(int comId) {
		Com com = null;
		String sql = "select *from com where comId=?";
		Object[] values = {comId};
		ResultSet rs = DBOperation.select(sql, values);
		try {
			while(rs.next()) {
				com = new Com();
				com.setComId(rs.getInt("comId"));
				com.setComName(rs.getString("comName"));
				com.setComType(rs.getString("comType"));
				com.setOrigin(rs.getString("origin"));
				com.setPrice(rs.getDouble("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(null, null, rs);
		}
		return com;
	}
}
