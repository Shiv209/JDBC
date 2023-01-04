package CollableStatement;

/*
DELIMITER //
CREATE PROCEDURE get_student_cgpa (IN sid INTEGER, OUT cgpa DECIMAL(10, 2))
BEGIN
  SELECT cgpa FROM student WHERE sid = sid;
END
//
*/

import Lecture.DBConnection;

import java.sql.*;

public class CSdemo {
    DBConnection dbcon;
    Connection con;
    CallableStatement cst;

    public void test() throws Exception {
        dbcon = new DBConnection();
        con = dbcon.getConnection();
        if (con != null) {
            System.out.println("Connection established");
        }
        // prepare call
        String qcall = "{CALL get_student_cgpa(?,?)}";
        cst = con.prepareCall(qcall);
        // set parameter IN and OUT
        cst.setInt(1, 100); // IN - assigning
        cst.registerOutParameter(2, Types.DECIMAL); // register the OUT parameter
        // execute callable statement
        cst.execute(); // callable statements
        // retrieve out param
        double cgpa = cst.getDouble(2);
        System.out.println("CGPA: " + cgpa);

        con.close();
        cst.close();
    }
}
