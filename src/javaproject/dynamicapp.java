
package javaproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class dynamicapp {
	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String username="root";
	private static final String password="root";
	private static Connection conn;
	private static PreparedStatement pmst;
	public static void main(String[] args) {
		int choice;
		do {
			Scanner src=new Scanner(System.in);
			System.out.println("choose your choice");
			DisplayMenu();
			choice=Integer.parseInt(src.next());
			switch(choice) {
			case 1:
				createdatabase();
				break;
			case 2:
				dropdatabase();
				break;
			case 3:
				DataInsertion();
				break;
			case 4:
				deletebymail();
				break;
			case 5:
				updatedata();
				break;
			case 6:
				getbymail();
				break;
			case 7:
				getall();
				break;
			case 8:
				System.exit(0);
				break;
			}
		}while (choice>0);
	}
	

	private static void exit() {
		// TODO Auto-generated method stub
		
	}

	private static void getall() {
		try {
			Scanner src=new Scanner(System.in);
			Class.forName(driver);
			System.out.println("enter database name");
			String url="jdbc:mysql://localhost:3306/"+src.next();
			conn=DriverManager.getConnection(url,username,password);
			System.out.println("enter table name");
			String sql="select * from "+sc.next();
			pmst=conn.prepareStatement(driver);
			ResultSet rs=pmst.executeQuery();
			while(rs.next()){
				System.out.println("order id:"+rs.getLong("order_id"));
				System.out.println("order name:"+rs.getString("order_name"));
				System.out.println("order pincode:"+rs.getInt("order_pincode"));
				System.out.println("order id:"+rs.getString("order_address"));
						
					
						
			}
;
			pmst.close();
			conn.close();
		}   catch (Exception e) {
			e.printStackTrace();
				
		  
		}
		// TODO Auto-generated method stub
		
	}

	private static void getbymail() {
		try {
			Scanner src=new Scanner(System.in);
			Class.forName(driver);
			System.out.println("Enter database name:"); 
			String url="jdbc:mysql://localhost:3306/"+src.next();
			conn=DriverManager.getConnection(url,username,password);
			System.out.println("enter database table name");
			String sql="select*from"+sc.next()+"where order_id=?";
			pmst=conn.prepareStatement(sql);
			System.out.println("enter order id");
			pmst.setLong(1, src.nextLong());
			ResultSet rs=pmst.executeQuery();
			while(rs.next()){
				System.out.println("order id:"+rs.getLong("order_id"));
				System.out.println("order name:"+rs.getString("order_name"));
				System.out.println("order pincode:"+rs.getInt("order_pincode"));
				System.out.println("order id:"+rs.getString("order_address"));
						
		// TODO Auto-generated method stub
		
	}

	private static void updatedata() {
		try {
			Scanner src=new Scanner(System.in);
			Class.forName(driver);
			System.out.println("Enter database name:"); 
			String url="jdbc:mysql://localhost:3306/"+src.next();
			conn=DriverManager.getConnection(url,username,password);
			System.out.println("enter database table name");
			String sql="update"+src.next()+"set order_name=?,order_pincode=?,order_address=?,where order_id=?";
			pmst=conn.prepareStatement(Sql);
			System.out.println("enter order name");
			pmst.setString(1, src.next());
			System.out.println("enter order pincode");
			pmst.setInt(2, src.nextInt());
			System.out.println("enter order address");
			pmst.setString(3, src.next());
			System.out.println("enter order id");
			pmst.setLong(4, src.nextLong());
			int i= pmst.executeUpdate();
			if(i>0) {
				System.out.println("Database updateds successfully");
			}else {
				System.out.println("database not updated");
			}
			conn.close();
			pmst.close();
		} catch (Exception e) {
			e.printStackTrace();
		
		}	
	}

	private static void deletebymail() {

		try {
			Scanner src=new Scanner(System.in);
			Class.forName(driver);
			System.out.println("Enter database name:"); 
			String url="jdbc:mysql://localhost:3306/"+src.next();
			conn=DriverManager.getConnection(url,username,password);
			System.out.println("enter database table name");
			String sql="delete from"+src.next()+"where order_id=?";
			pmst=conn.prepareStatement(Sql);
			System.out.println("enter order id");
			pmst.setLong(1, src.nextLong());
			int i= pmst.executeUpdate();
			if(i>0) {
				System.out.println("database deleted successfully");
			}else {
				System.out.println("database not deleted");
			}
			conn.close();
			pmst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
		
		private static void DataInsertion() {
	
		try {
			Scanner src = new Scanner(System.in);
			Class.forName(driver);
			System.out.println("Enter database name:");  
			String url="jdbc:mysql://localhost:3306/"+src.next();
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("enter database table name");
			String Sql="insert into"+src.next()+"(order_id,order_pincode,order_address)values(?,?,?,?)";
			pmst=conn.prepareStatement(Sql);
			System.out.println("enter order id");
			pmst.setLong(1,src.nextLong());
			System.out.println("enter order name");
			pmst.setString(2,src.next());
			System.out.println("enter order pincode");
			pmst.setInt(3,src.nextInt());
			System.out.println("enter order address");
			pmst.setString(4,src.next());
			int i= pmst.executeUpdate();
			if(i>0) {
				System.out.println("database inserted successfully");
			}else {
					System.out.println(" database not inserted");
			}
		    conn.close();
			pmst.close();
   	}       catch (Exception e) {
		    e.printStackTrace();
	        
	}
			
	}
		
	private static void dropdatabase() {

		try {
			Class.forName(driver);
			String url="jdbc:mysql://localhost:3306/";
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("Enter database name:");  
			Scanner src=new Scanner(System.in);
			String Sql="drop database "+src.next();
			pmst=conn.prepareStatement(Sql);
			int i= pmst.executeUpdate();
	        if(i==0) {
				System.out.println("database dropped successfully");
	        }else {
				System.out.println("oops database not dropped...!");
			}
			conn.close();
			pmst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println();
		}
			// TODO Auto-generated method stub
		    
	}

	private static void createdatabase() {
		try {
			Class.forName(driver);
			String url="jdbc:mysql://localhost:3306/";
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("Enter database name");
			Scanner src=new Scanner(System.in);
			String sql="create database "+src.next();
			pmst= conn.prepareStatement(sql);
			int i=pmst.executeUpdate();
			if(i>0) {
				System.out.println("database created successfully");
			}else {
				System.out.println("database not created");
			}
			conn.close();
			pmst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}
	private static void DisplayMenu() {
			
		System.out.println("\t1.create database");
		System.out.println("\t2.drop database");
		System.out.println("\t3.data insertion");
		System.out.println("\t4.delete by mail");
		System.out.println("\t5.update data");
		System.out.println("\t6.get by mail");
		System.out.println("\t7.get all");
		System.out.println("\t8.exit");
	}

}
