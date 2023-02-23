package com.bridgelabz;

import java.sql.*;

public class PayRollDBService {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service", "root", "d11cpk1211");
            PreparedStatement stmt = con.prepareStatement("select * from employeepayroll where id =? and salary =?");
            stmt.setInt(1, 1);
            stmt.setDouble(2, 25000);
            boolean response = stmt.execute();
            if (response) {
                ResultSet rs = stmt.getResultSet();
                while (rs.next())
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getDouble(3) + "  " + rs.getDate(4));

            } else {
                int count = stmt.getUpdateCount();
                System.out.println(count);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

