package Lecture;

import java.sql.*;

public class DBOperations2 {
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
        st = con.createStatement();
//        String query = "insert into student values(111, 'ABC', 9.2), (101, 'XYZ', 8.7),(199,'PQR', 7.7)";
//        int x = st.executeUpdate(query);
//        if (x > 0) {
//            System.out.println("Insertion of records is successful");
//        }
        ResultSet rs = st.executeQuery("select * from student");
        System.out.println("SID\tSNAME\tCGPA");
        System.out.println("--------------------");
        while (rs.next()) {
            System.out.println(rs.getInt("sid") + "\t" + rs.getString(2) + "\t" + rs.getDouble("cgpa"));
        }

        con.close();
    }
}