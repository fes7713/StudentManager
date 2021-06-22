import java.sql.*;
public class ConnectToDatabase {
      static final String MYSQLURL ="jdbc:mysql://localhost:3306/Lab02"; //change project name to w/e is on your device
      static final String USER= "root";
      static final String PASS= "PASSWORD"; // change password if needed.
      public static void main(String[] args){
      Connection con = null;
      try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(MYSQLURL, USER, PASS);
        if (con != null){
            System.out.println("Database connection is successful!");
            }
         else {
            System.out.println("Connection not successful. You messed up!");
            
            }
        } catch (Exception e) {
            e.printStackTrace();
            }
        }
}