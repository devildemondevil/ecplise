package Dao.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.Dao;
import Util.DBOper;

public class DaoImpl implements Dao {

	public boolean logIn(String username, String password) {
		// TODO Auto-generated method stub

		String sql = "select * from jiangjiang where  username=?  and password=?";
		DBOper dboper = new DBOper();
//		String server, String dbname, String user,String pwd
		try {


			dboper.getConn("localhost", "jiangjiang", "root", "123456");
			ResultSet rs = dboper.executeQuery(sql, new String[]{username, password});
			System.out.println("1234");
			if (rs.next()) {
				System.out.println("123");
				return true;
			} else {

				return false;
			}

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dboper.closeAll();

		}
		return false;
	}

	public int register(String username,String pwd){
		String sql = "insert into jiangjiang values(?,?,now())";
		DBOper dboper = new DBOper();

		try {
			dboper.getConn("localhost", "jiangjiang", "root", "123456");




			int re=dboper.executeUpdate(sql,new String[]{username,pwd});
			if (re>0){
				return re;
			}else {
				return 0;
			}


		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}finally {
			dboper.closeAll();
		}
	}

	@Override
	public int update(String username, String pwd, String newpwd)  {

		String sql="update jiangjiang set password = ? , time=now()  where username = ? and password = ?";
		DBOper dbOper=new DBOper();
		try {

			dbOper.getConn("localhost", "jiangjiang", "root", "123456");

			int result= dbOper.executeUpdate(sql,new String[]{newpwd,username,pwd});

			dbOper.closeAll();

			return result;

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}


	}

	@Override
	public int delete(String username, String pwd) {

		String sql = "delete from jiangjiang where username=? and password=?";
		DBOper dboper = new DBOper();

		try {



			dboper.getConn("localhost", "jiangjiang", "root", "123456");

			return dboper.executeUpdate(sql,new String[]{username,pwd});



		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}finally {
			dboper.closeAll();
		}


	}


}