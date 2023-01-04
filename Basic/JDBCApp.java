package Lecture;

public class JDBCApp {
    public static void main(String[] args) {
        try {
            DBOperations2 ops = new DBOperations2();
            ops.CRUDOps();
        } catch (Exception e) {
        }
    }
}
