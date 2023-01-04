package Lecture;

import java.sql.*;

public class TestDb {
    static final String DB_URL = "jdbc:mysql://localhost:3306/Employee";
    static final String USER = "root";
    static final String PASS = "pass1234";

    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM employee;");
        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println("querying SELECT * FROM employee");
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue);
                //System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println();
        }
    }
}
