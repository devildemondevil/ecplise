package Dao;

public interface Dao {
	
	boolean logIn(String username,String password);

	public int register(String username,String pwd);
}
