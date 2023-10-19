package Dao;

import java.sql.SQLException;

public abstract interface Dao {
	public static  int a=0;
	
	public abstract boolean logIn(String username,String password);

	public int register(String username,String pwd);
	public int update(String username,String pwd,String newpwd);

	public int delete(String username,String pwd);
}
