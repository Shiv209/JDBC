package CollableStatement;

import Lecture.DBConnection;

import java.io.BufferedReader;
import java.sql.*;
public class RSMDdemo {
    DBConnection dbcon;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    ResultSetMetaData rsmd;

    public void test() throws Exception {
        dbcon = new DBConnection();
        con = dbcon.getConnection();
        if (con != null) {
            System.out.println("Connection established");
        }
        pst = con.prepareStatement("select * from student");
        rs = pst.executeQuery();
        // getting metadata
        rsmd = rs.getMetaData();
        System.out.println("No of coulmns: " + rsmd.getColumnCount());

        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.print(rsmd.getColumnName(i) + "(");
            System.out.print(rsmd.getColumnTypeName(i) + ")\t");
        }
        System.out.println();

        while (rs.next()) {
            System.out.println(rs.getInt(1) + "\t\t " + rs.getString(2) + "\t\t " + rs.getDouble(3));
        }
        con.close();
    }
}
