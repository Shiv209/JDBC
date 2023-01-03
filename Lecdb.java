package Lecture;

import java.sql.*;

public class Lecdb {
    public static void main(String[] args) {
        try {
            //1. loading the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2. Establishing connection with database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "pass1234");
            if (con != null)
                System.out.println("Connection established");
            else
                System.out.println("Connection failed");

            //3. Creating statement to issue SQL queries
            Statement st = con.createStatement();
            String qry = "select * from employee";
            //4. Execute Queries and process result
            ResultSet rs = st.executeQuery(qry);
            //4 processing ResultSet
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }
            //5. close the connection
            con.close();
            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


