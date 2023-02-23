package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemoClass {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service", "root", "d11cpk1211");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employeepayroll");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getDouble(3) + "  " + rs.getDate(4));

//			int count = stmt.executeUpdate("update employee_payroll set email = 'sample1' where id =1");
//			System.out.println(count);

//			boolean response = stmt.execute("insert into employee_payroll(name,salary,email,start)\r\n"
//					+ "values(\"Sarvesh2\",6100000.0,\"sample4\",'2022-08-22')");
//
//			if (response) {
//				ResultSet rs = stmt.getResultSet();
//				while (rs.next())
//					System.out.println(
//							rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getDouble(3) + "  " + rs.getString(4) + "  " + rs.getDate(5));
//
//			}else {
//				int count = stmt.getUpdateCount();
//				System.out.println(count);
//
//			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
