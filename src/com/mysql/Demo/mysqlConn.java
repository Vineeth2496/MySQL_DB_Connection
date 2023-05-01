package com.mysql.Demo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class mysqlConn {

	public static void main(String[] args) {
	
	try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "vine96");
		System.out.println(con);
		
		PreparedStatement pst=con.prepareStatement("insert into link1 values(?,?,?,?)");
		
		InputStreamReader ii=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(ii);
		System.out.println("Enter Id:");
		Integer id=Integer.parseInt(br.readLine());
		System.out.println("Enter Name:");
		String name=br.readLine();
		System.out.println("Enter Salary:");
		Float salary=Float.parseFloat(br.readLine());
		System.out.println("Enter Profession:");
		String profession=br.readLine();
		
		pst.setInt(1, id);
		pst.setString(2, name);
		pst.setFloat(3, salary);
		pst.setString(4, profession);
		
		int i=pst.executeUpdate();
		
		System.out.println("Record Updated Sucessfully :"+i);
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}

}
