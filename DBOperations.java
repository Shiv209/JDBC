package Lecture;

import java.sql.*;

public class DBOperations {
    DBConnection dbcon;
    Connection con;
    Statement st;
    ResultSet rs;

    public void CRUDOps() throws Exception {
        dbcon = new DBConnection();
        con = dbcon.getConnection();
        if (con != null) {
            System.out.println("Connection established");
        }
        String query = "create table student(sid int(11), sname  varchar(30), cgpa float)";
        st = con.createStatement();
        int x = st.executeUpdate(query);
        if (x == 0)
            System.out.println("Table Created!");
        con.close();
    }
}

