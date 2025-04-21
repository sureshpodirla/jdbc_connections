package javaproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class database {
	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306";
	private static final String username="root";
	private static final String password="root";
	private static PreparedStatement pmst;
	private static Connection conn;
			
public static void main(String[]args) {
	
	try {
		Scanner src=new Scanner(System.in);
		System.out.println("Enter database name to create:");  
        String dbName = src.nextLine();
		Class.forName(driver);
		conn=DriverManager.getConnection(url,username,password);
		String Sql="create database "+dbName;
	    pmst=conn.prepareStatement(Sql);
		int i= pmst.executeUpdate();
		if(i>0) {
			System.out.println("db is created");
		}
		else {
			System.out.println("db is not created");
		}
		pmst.close();
	    conn.close();
	    src.close();
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}
}

	
	
	
	
	
	
}
