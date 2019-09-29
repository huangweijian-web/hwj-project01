package org.web.uilt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	//��ȡ����
	public static Connection getConnection() {
		Connection con = null ;
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manage", "root", "root") ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con ;
	}
	
	//�ر�
	public static void close(Connection con,Statement stmt,ResultSet rs) {
		try {
	     	if ( rs != null ) {
				rs.close();
				rs = null ; //�رպ����ͷ�rs
		     }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if ( stmt != null ) {
					stmt.close();
					stmt = null ;//�رպ����ͷ�
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if ( con != null ) {
						con.close();
						con = null ;//�رպ����ͷ�
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
