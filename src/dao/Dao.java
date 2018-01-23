package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Model;

public class Dao {
	static Connection con=null;
	static Statement st=null;
	static 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://au-cdbr-sl-syd-01.cleardb.net/ibmx_0dd36c62cf754de?user=bdbdcead07e6bb&password=f2c688a3");
			st=con.createStatement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static int insert(String sql) throws SQLException
	{
	
		
		PreparedStatement ps=con.prepareStatement(sql);
		int i=ps.executeUpdate();
		return i;
	}
	
	public static ResultSet select(String sql) throws SQLException
	{
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		return rs;
		
	}
	
	void createTable() throws SQLException
	{
		String sql="create table employee(eid integer primary key,ename varchar(50),age varchar(50),city varchar(50))";
		PreparedStatement ps=con.prepareStatement(sql);
		int i=ps.executeUpdate();
		if(i==0)
		{
			System.out.println("table created");
		}
	}
	


}
