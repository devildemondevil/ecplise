package Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Map.Entry;

public class DBOper {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;


	public Connection getConn(String server, String dbname, String user,
			String pwd) throws ClassNotFoundException, SQLException,
			InstantiationException, IllegalAccessException {
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://" + server + ":3306/" + dbname + "?user="+user+"&password="+pwd;

		Class.forName(DRIVER);
		
		conn = DriverManager.getConnection(URL);
		System.out.print(conn);
		return conn; 
	}

	
	public void closeAll() {
		
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ִ��SQL��䣬���Խ��в�ѯ
	 */
	public ResultSet executeQuery(String preparedSql, String[] param) {
		
		try {
			
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					
					pstmt.setString(i + 1, param[i]); 
				}
			}
			
			
			rs = pstmt.executeQuery(); 
			return rs;
		} catch (SQLException e) {
			
			e.printStackTrace(); 
		}
		return rs;
	}

	public int executeUpdate(String preparedSql, String[] param) {

		int num = 0;

		try {
			 
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					 
					pstmt.setString(i + 1, param[i]);
				}
			}
			
			num = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			
			e.printStackTrace(); 
		} 
		return num;
	}
	public static void main(String[] args) {
		Properties p = System.getProperties();
	   for(Entry<Object, Object> e:p.entrySet()){
		   System.out.println(e.getKey()+"= "+e.getValue());
	   }
	}
}