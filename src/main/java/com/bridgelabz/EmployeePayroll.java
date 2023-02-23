package com.bridgelabz;

import java.sql.*;
import java.util.Arrays;

public class EmployeePayroll {

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service", "root", "d11cpk1211");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from employeepayroll");
            while(rs.next()){
                System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : "+ rs.getDouble(3) + " : "+ rs.getDate(4));
            }

            int count = stmt.executeUpdate("update employeepayroll set name = 'palle' where id = 1");
            System.out.println(count);

            boolean response = stmt.execute("insert into employeepayroll(name, salary, start)\r\n"
            + "values(\"Kiran\",23450,\"2021-12-05\")");
            System.out.println(response);
            if (response) {
                ResultSet rs1 = stmt.getResultSet();
                System.out.println(rs1.getInt(1) + " : " + rs1.getString(2) + " : " + rs1.getDouble(3) + " : "+ rs1.getDate(4));
            }
            else{
                int coun = stmt.getUpdateCount();
                System.out.println(coun);
            }
            ResultSet rs2 = stmt.executeQuery("select * from employeepayroll");
            while (rs2.next()){
                System.out.println(rs2.getInt(1)+" : "+rs2.getString(2) +" : "+rs2.getDouble(3) + " : "+ rs2.getDate(4));
            }

            String[] departmentName = new String[50];
            ResultSet st = stmt.executeQuery("select * from employee_department");
            int index = 0;
            while (st.next()){
                departmentName[index++] = st.getString(2);
            }
            for(int i = 0; i < index; i++){
                System.out.println(departmentName[i]);
            }
            con.close();

        }catch(Exception e){
            System.out.println(e);

        }
    }
}
