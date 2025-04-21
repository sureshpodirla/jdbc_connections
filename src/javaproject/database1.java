package javaproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class database1 {
	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/dbName";
	private static final String username="root";
	private static final String password="root";
	private static PreparedStatement pmst;
	private static Connection conn;
public static void main(String[] args) {
	try {
		Scanner sc=new Scanner(System.in);
		Class.forName(driver);
		conn= DriverManager.getConnection(url,username,password);
		String sql="insert into login(Loginid,loginmail,loginpassword) values(?,?,?)";
		pmst=conn.prepareStatement(sql);
		System.out.println("enter login id");
		pmst.setString(1, sc.nextLine());
		System.out.println("enter login email");
		pmst.setString(2,sc.nextLine());
		System.out.println("enter login password");
		pmst.setString(3, sc.nextLine());
		
		pmst=conn.prepareStatement(driver);
		int i=pmst.executeUpdate();
		if(i>0) {
			System.out.println("Data inserted");
		}
		else {
			System.out.println("Data isn't inserted");
		}
		pmst.close();
		conn.close();
		sc.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
