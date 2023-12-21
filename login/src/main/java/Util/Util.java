package Util;

import java.sql.*;

public class Util {
    private static final String uname = "root";
    private static final String upwd = "123456";
    private static final String url = "jdbc:mysql://192.168.0.113:3306/jiangjiang";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url,uname,upwd);
    }

    public static void release(ResultSet rls, PreparedStatement pst, Connection con)
    {
        try {
            if(rls!=null) {
                rls.close();
            }
            if(pst!=null){
                pst.close();
            }
            if(con!=null){
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	
}