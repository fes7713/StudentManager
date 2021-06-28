/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author fes77
 */
public class Repository {
    
    static String MYSQLURL; //change project name to w/e is on your device
    static String USER;
    static String PASS; // change password if needed.
    static Connection con;

    public Repository(String MySQLURL, String User, String Pass) {
        this.MYSQLURL = MySQLURL;
        USER = User;
        PASS = Pass;
        connect();
    }

    public void connect()
    {
        con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(MYSQLURL, USER, PASS);
            if (con != null) {
                System.out.println("Database connection is successful!");
            } else {
                System.out.println("Connection not successful. You messed up!");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void testQuery(String query)
    {
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Course_Details");
            ResultSetMetaData rsmd = rs.getMetaData();
            for(int i = 1; i <= rsmd.getColumnCount(); i++)
            {
                System.out.println(rsmd.getColumnName(i));
            }
           
            while (rs.next()) {
                String Department_ID = rs.getString("Department_ID");
                int Course_ID = rs.getInt("Course_ID");
                String Semester_Taken = rs.getString("Semester_Taken");
                LocalTime Start_Time = rs.getTime("Start_Time").toLocalTime();
                LocalTime End_Time = rs.getTime("End_Time").toLocalTime();
                String Days = rs.getString("Days");
                String Course_Title = rs.getString("Course_Title");
                int Professor_ID = rs.getInt("Professor_ID");
                
                
                // print the results
                System.out.format("%s, %s, %s, %s, %s, %s, %s, %s\n", Department_ID, Course_ID, Semester_Taken, Start_Time, End_Time, Days, Course_Title, Professor_ID);
            }
            st.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
//    public List<Student> findAllStudents()
//    {
//        if(con != null)
//        {
//            try{
//                String query = "SELECT * FROM Students";
//                Statement st = con.createStatement();
//                ResultSet rs = st.executeQuery(query);
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//        }
//        else{
//            System.out.println("No connection");
//        }
//    }
    
    public static void main(String[] args) 
    {
        Repository repo = new Repository("jdbc:mysql://localhost:3306/practice", "root", "PASS");
        
        String query = "SELECT * FROM Course_Details";
        repo.testQuery(query);
    }
}
