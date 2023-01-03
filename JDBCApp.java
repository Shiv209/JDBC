package Lecture;

public class JDBCApp {
    public static void main(String[] args) {
        try {
            DBOperations ops = new DBOperations();
            ops.CRUDOps();
        } catch (Exception e) {
        }
    }
}
