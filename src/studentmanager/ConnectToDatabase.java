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
//
//If anyone having trouble connecting mysql, try this
//1) Make sure MYSQLURL is correct  
//jdbc:mysql://localhost:3306/Lab02
//jdbc:mysql://localhost:port number/Schema name (Its called database name inside -> it confused me for 15 mins)
//2) Check port number if you have changed it before.
//3) Make sure you put jar file class path to ur project.
//Go to ur project setting and add mysql connector .jar
//Not module path, class path
//4) Check your password
//5) You may find error in thr first line import java.sql.*; but its nothing.