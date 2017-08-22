package databaseTest;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.lang.Class.forName;

public class DBConnect {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public DBConnect(){
        try {
            forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?autoReconnect=true&useSSL=false","root", "Prince991$");

            st = con.createStatement();

        }catch (Exception ex){
            System.out.println("Error: "+ex);
        }
    }

    public void getData(){
        try {

            String query = "select * from employees";
            rs = st.executeQuery(query);
            System.out.println("Record from Database");
            while(rs.next()){
                String ID = rs.getString("employee_ID");
                String Name = rs.getString("employee_Name");
                String DOB = rs.getString("employee_DOB");
                String Phone = rs.getString("employee_PHONE");
                System.out.println("ID: "+ID+" "+"Name: "+Name+" DOB: "+DOB+" Phone: "+Phone);

            }

        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
