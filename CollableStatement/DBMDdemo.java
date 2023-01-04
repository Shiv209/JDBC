package CollableStatement;


import Lecture.DBConnection;

import java.sql.*;

public class DBMDdemo {
    DBConnection dbcon;
    Connection con;
    DatabaseMetaData dbmd;
    ResultSet rs;

    public void test() throws Exception {
        dbcon = new DBConnection();
        con = dbcon.getConnection();
        if (con != null) {
            System.out.println("Connection established");
        }
        dbmd = con.getMetaData();
        String dbName = dbmd.getDatabaseProductName(); //
        String dbVersion = dbmd.getDatabaseProductVersion();
        String driverName = dbmd.getDriverName();

        System.out.println("DB Name: " + dbName);
        System.out.println("DB Version: " + dbVersion);
        System.out.println("Driver Name: " + driverName);

        rs = dbmd.getTables(null, null, null, new String[]{"TABLE"});
        while (rs.next()) {
            String tableName = rs.getString("TABLE_NAME");
            System.out.println(tableName);
        }
        con.close();
    }
}
