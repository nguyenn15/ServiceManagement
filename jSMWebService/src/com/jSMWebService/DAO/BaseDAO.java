package com.jSMWebService.DAO;

import org.sql2o.Sql2o;

/**
 * This is the base DAO for all DAO classes
 * this contains the sql2o object which is used create connection to mysql
 * @author segroup1
 *
 */
public class BaseDAO {
	// configuaration information for connection to mysql server
	private static String Conn="jdbc:mysql://localhost:3306/jsmwebservice?useSSL=false";
	private static String Username="root";
	private static String Password="123456";
	// connection object 
	protected static Sql2o sql2o;
		
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			sql2o = new Sql2o(Conn,Username, Password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public BaseDAO() {
		
		
	}
}
