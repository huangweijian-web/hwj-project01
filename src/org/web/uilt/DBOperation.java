package org.web.uilt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOperation {
	
	public static int  update_delete_insert(String sql,Object[] values) {
		int result = 0 ;
		//JDBC 1-2
		Connection con = DBUtils.getConnection() ;
		//JDBC 3 ׼������
		PreparedStatement pstmt = null ;
		try {
			pstmt = con.prepareStatement(sql) ;
			//JDBC 4 �ԣ���ֵ
			if ( values != null ) {
				for(int i=0;i<values.length;i++) {
					pstmt.setObject(i+1, values[i]);
				}
			}
			//JDBC 5 ִ��SQL���
			System.out.println(pstmt.toString()) ;
			result = pstmt.executeUpdate() ;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//6 �ر�
			DBUtils.close(con, pstmt, null);
		}
	 
		return result ;
	}
	
	public static ResultSet select(String sql,Object[] values) {
		      ResultSet rs = null ;
		      //JDBC 1-2
				Connection con = DBUtils.getConnection() ;
				//JDBC 3 ׼������
				PreparedStatement pstmt = null ;
				try {
					pstmt = con.prepareStatement(sql) ;
					//JDBC 4 �ԣ���ֵ
					if ( values != null ) {
						for(int i=0;i<values.length;i++) {
							pstmt.setObject(i+1, values[i]);
						}
					}
					//JDBC 5 ִ��SQL���
					System.out.println(pstmt.toString()) ;
					rs  = pstmt.executeQuery() ;
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					//6 �ر�
					DBUtils.close(null, null, null);
				}
		   return rs ;
	}

}
