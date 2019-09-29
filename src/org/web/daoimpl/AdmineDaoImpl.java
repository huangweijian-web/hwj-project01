package org.web.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.web.dao.AdmineDao;
import org.web.model.Admine;
import org.web.uilt.DBOperation;
import org.web.uilt.DBUtils;


public class AdmineDaoImpl implements AdmineDao{

	@Override
	public Admine login(Admine admine) {
		Admine ad = null ;
		String sql = "select * from admine where admineName=? and adminePass=?";
		Object[] values = {admine.getAdmineName(),admine.getAdminePass()};
		ResultSet rs = DBOperation.select(sql, values);
		try {
			if(rs.next()) {
				ad = new Admine();
				ad.setAdmineId(rs.getInt("admineId"));
				ad.setAdmineName(rs.getString("admineName"));
				ad.setAdminePass(rs.getString("adminePass"));		
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}finally {
				DBUtils.close(null, null, rs);
		}
		return ad;
	}
}
