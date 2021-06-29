/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanager.Repository;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import studentmanager.EntryForm.MySQLInitForm;
import studentmanager.JavaClasses.Course;
import studentmanager.JavaClasses.Department;
import studentmanager.JavaClasses.Professor;
import studentmanager.JavaClasses.Semester;
import studentmanager.JavaClasses.Student;

/**
 *
 * @author fes77
 */
public class Repository {

    static String MYSQLURL; //change project name to w/e is on your device
    static String USER;
    static String PASS; // change password if needed.
    static Connection con;

    public static boolean connect(String MySQLURL, String User, String Pass) {
        MYSQLURL = MySQLURL;
        USER = User;
        PASS = Pass;
        con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No mysql driver");
        }

        try {
            con = DriverManager.getConnection(MYSQLURL, USER, PASS);
            if (con != null) {
                System.out.println("Database connection is successful!");
                return true;
            } else {
                System.out.println("Connection not successful. You messed up!");
                return false;
            }
        } catch (SQLException e) {
            int errorCode = e.getErrorCode();
            String errorMessage = e.getMessage();
            JOptionPane.showMessageDialog(null, "Error Code + " + errorCode + " : " + errorMessage);
            return false;
        }
    }

    public static boolean isConnected() {
        if (con != null) {
            return true;
        }
        return false;
    }

    public static String getDatabaseName() {
        String[] arr = MYSQLURL.split("/");
        return arr[arr.length - 1];
    }

    public static ResultSet query(String query) throws SQLException {
        if (con == null) {
            System.out.println("No connection");
            return null;
        }

        String[] querySeparated = query.split(";");
        Statement st = con.createStatement();
        return st.executeQuery(querySeparated[querySeparated.length - 1]);
    }

    public static void SQLDDL(String sql) throws SQLException {
        if (con == null) {
            System.out.println("No connection");
            return;
        }
        String[] sqlSeparated = sql.split(";");
        Statement st = con.createStatement();
        for (int i = 0; i < sqlSeparated.length; i++) {
            st.executeUpdate(sqlSeparated[i]);
        }
    }

    public static List<String> findAllTables() {
        List<String> tables = new ArrayList();

        try {
            DatabaseMetaData md = con.getMetaData();
            Statement st = con.createStatement();
            String[] types = {"TABLE"};
            ResultSet rs = md.getTables(null, null, "%", types);
            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME");
                try {
                    st.executeQuery("SELECT * FROM " + tableName + ";");
                    tables.add(rs.getString("TABLE_NAME"));
                } catch (SQLException e) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tables;
    }

    // Search courses by professor id or student id.
    // When searching by professor id, it gives courses that specified professor is teaching
    // When searching by student id, it gives courses that specified student is taking
    public static List<Course> findCoursesByID(MySQL tableType, int id) throws SQLException {
        if (!tableType.equals(MySQL.PROFESSOR) && !tableType.equals(MySQL.STUDENT)) {
            System.out.println("Select tableType from either Professor or Student");
        }

        List<Course> courseList = new ArrayList<>();

        String query;
        if (tableType.equals(MySQL.STUDENT)) {
            query = "SELECT Department_ID,  Course_ID \n"
                    + "FROM student_course_list \n"
                    + "WHERE TU_ID = " + String.valueOf(id) + "\n"
                    + "ORDER BY Department_ID, Course_ID;";
        } else {
            query = "SELECT Department_ID,  Course_ID \n"
                    + "FROM course_details \n"
                    + "WHERE Professor_ID = " + String.valueOf(id) + "\n"
                    + "ORDER BY Department_ID, Course_ID;";
        }

        ResultSet rs = query(query);
        ResultSetMetaData rsmd = rs.getMetaData();
        int nCols = rsmd.getColumnCount();

        while (rs.next()) {
            Course course = new Course();
            for (int i = 1; i <= nCols; i++) {
                MySQL attr = MySQL.valueOf(rsmd.getColumnName(i).toUpperCase());
                course.set(attr, rs.getObject(rsmd.getColumnName(i)));
            }
            courseList.add(course);
        }
        return courseList;
    }

    public static List<Student> findAllStudents() throws SQLException {
        ResultSet rs = query("SELECT * FROM Students");

        ResultSetMetaData rsmd = rs.getMetaData();
        int nCols = rsmd.getColumnCount();

        List<Student> studentList = new ArrayList<>();
        while (rs.next()) {
            Student stu = new Student();
            for (int i = 1; i <= nCols; i++) {
                MySQL attr = MySQL.valueOf(rsmd.getColumnName(i).toUpperCase());
                stu.set(attr, rs.getObject(rsmd.getColumnName(i)));
            }
            stu.setCourseTaking(Repository.findCoursesByID(MySQL.STUDENT, stu.getTU_id()));
            studentList.add(stu);
        }
        return studentList;
    }

    public static List<Course> findAllCourses() throws SQLException {
        ResultSet rs = query("SELECT * FROM course_details");
        ResultSetMetaData rsmd = rs.getMetaData();
        int nCols = rsmd.getColumnCount();

        List<Course> courseList = new ArrayList<>();
        while (rs.next()) {
            Course course = new Course();
            for (int i = 1; i <= nCols; i++) {
                MySQL attr = MySQL.valueOf(rsmd.getColumnName(i).toUpperCase());
                course.set(attr, rs.getObject(rsmd.getColumnName(i)));
            }
            courseList.add(course);
        }
        return courseList;
    }

    public static List<Department> findAllDepartments() throws SQLException {
        ResultSet rs = query("SELECT * FROM Department");
        ResultSetMetaData rsmd = rs.getMetaData();
        int nCols = rsmd.getColumnCount();

        List<Department> departmentList = new ArrayList<>();
        while (rs.next()) {
            Department dept = new Department();
            for (int i = 1; i <= nCols; i++) {
                MySQL attr = MySQL.valueOf(rsmd.getColumnName(i).toUpperCase());
                dept.set(attr, rs.getObject(rsmd.getColumnName(i)));
            }
            departmentList.add(dept);
        }
        return departmentList;
    }

    public static List<Professor> findAllProfessors() throws SQLException {
        ResultSet rs = query("SELECT * FROM professor_table");
        ResultSetMetaData rsmd = rs.getMetaData();
        int nCols = rsmd.getColumnCount();

        List<Professor> professorList = new ArrayList<>();
        while (rs.next()) {
            Professor prof = new Professor();
            for (int i = 1; i <= nCols; i++) {
                MySQL attr = MySQL.valueOf(rsmd.getColumnName(i).toUpperCase());
                prof.set(attr, rs.getObject(rsmd.getColumnName(i)));
            }
            professorList.add(prof);
        }
        return professorList;
    }

    public static List<Semester> findAllSemesters() throws SQLException {
        ResultSet rs = query("SELECT * FROM semesters");
        ResultSetMetaData rsmd = rs.getMetaData();
        int nCols = rsmd.getColumnCount();

        List<Semester> semesterList = new ArrayList<>();
        while (rs.next()) {
            Semester semester = new Semester();
            for (int i = 1; i <= nCols; i++) {
                MySQL attr = MySQL.valueOf(rsmd.getColumnName(i).toUpperCase());
                semester.set(attr, rs.getObject(rsmd.getColumnName(i)));
            }
            semesterList.add(semester);
        }
        return semesterList;
    }

    public static boolean dropAllTables() {
        if (con == null) {
            System.out.println("No connection");
            return false;
        }
        try {
            Statement st = con.createStatement();
            List<String> tableNames = findAllTables();
            for (int i = 0; i < tableNames.size(); i++) {
                try {
                    st.executeUpdate("Drop Table " + tableNames.get(i) + ";");
                } catch (SQLException e) {
                    tableNames.add(tableNames.get(i));
                }
            }
            return true;
        } catch (SQLException e) {
            int errorCode = e.getErrorCode();
            String errorMessage = e.getMessage();
            JOptionPane.showMessageDialog(null, "Error Code + " + errorCode + " : " + errorMessage);
            return false;
        }
    }

    public static String getTableCreationCode() {
        return tableCreationCode;
    }

    static String tableCreationCode = "CREATE TABLE Department\n"
            + "(\n"
            + "	Department_ID varchar(255),\n"
            + "    Department_Name varchar(255),\n"
            + "    PRIMARY KEY (Department_ID, Department_Name)\n"
            + ");\n"
            + "\n"
            + "CREATE TABLE Professor_Table\n"
            + "(\n"
            + "	Professor_ID int NOT NULL PRIMARY KEY,\n"
            + "    Professor_First_Name varchar(255) NOT NULL,\n"
            + "    Professor_Last_Name varchar(255) NOT NULL,\n"
            + "    Department_ID varchar(255) NOT NULL,\n"
            + "	FOREIGN KEY (Department_ID) REFERENCES Department(Department_ID) \n"
            + "    ON UPDATE CASCADE ON DELETE CASCADE\n"
            + ");\n"
            + "\n"
            + "CREATE TABLE Semesters\n"
            + "(\n"
            + "	Season varchar(255),\n"
            + "	Year INT,\n"
            + "    PRIMARY KEY (Season, Year)\n"
            + ");\n"
            + "\n"
            + "CREATE TABLE Course_Details\n"
            + "(\n"
            + "	Department_ID varchar(255),\n"
            + "    Course_ID int,\n"
            + "    \n"
            + "    -- Added\n"
            + "    Season varchar(255),\n"
            + "    Year INT,\n"
            + "    --\n"
            + "    Start_Time Time,\n"
            + "	End_Time Time,\n"
            + "	Days varchar(7),\n"
            + "    Course_Title varchar(255),\n"
            + "    Professor_ID int,\n"
            + "    PRIMARY KEY (Department_ID, Course_ID),\n"
            + "    \n"
            + "    -- Added\n"
            + "    FOREIGN KEY (Department_ID) REFERENCES Department(Department_ID)\n"
            + "    ON UPDATE CASCADE ON DELETE CASCADE,\n"
            + "    FOREIGN KEY (Season, Year) REFERENCES Semesters(Season, Year),\n"
            + "    --\n"
            + "    FOREIGN KEY (Professor_ID) REFERENCES Professor_Table(Professor_ID) \n"
            + "    ON UPDATE CASCADE ON DELETE CASCADE\n"
            + ");\n"
            + "\n"
            + "CREATE TABLE Students \n"
            + "(\n"
            + "	TU_ID INT NOT NULL PRIMARY KEY,\n"
            + "    Student_First_Name varchar(255),\n"
            + "    Student_Last_Name varchar(255),\n"
            + "    Major varchar(255)\n"
            + ");\n"
            + "\n"
            + "CREATE TABLE Student_Course_List\n"
            + "(\n"
            + "	TU_ID int NOT NULL,\n"
            + "    \n"
            + "    -- Added\n"
            + "    Department_ID varchar(255),\n"
            + "    --\n"
            + "    Course_ID int,\n"
            + "    PRIMARY KEY (TU_ID, Department_ID, Course_ID),\n"
            + "	FOREIGN KEY (TU_ID) REFERENCES Students(TU_ID)\n"
            + "    ON UPDATE CASCADE ON DELETE CASCADE,\n"
            + "    -- Added\n"
            + "    FOREIGN KEY (Department_ID) REFERENCES Department(Department_ID)\n"
            + "    ON UPDATE CASCADE ON DELETE CASCADE\n"
            + "    --\n"
            + ");";

    public static String getDataInsertionCode()
    {
        return dataInsertionCode;
    }
    
    static String dataInsertionCode = "INSERT INTO Department\n"
            + "VALUES 	('CIS', 'Computer and Information Sciences'), \n"
            + "		('ACCT', 'Accounting'),\n"
            + "		('ARTU', 'Art'),\n"
            + "        ('ASST', 'Asian Studies'),\n"
            + "        ('ECON', 'Economics'),\n"
            + "        ('ENG', 'English'),\n"
            + "        ('JPNS', 'Japanese'),\n"
            + "        ('PSY', 'Psychology');\n"
            + "        \n"
            + "INSERT INTO Professor_Table\n"
            + "VALUES  (123456789, 'Damon', 'Boyd', 'ECON'),\n"
            + "		(234567890, 'Jason', 'King', 'ENG'),\n"
            + "        (345678901, 'Tony', 'Kang', 'CIS'),\n"
            + "        (456789012, 'Reika', 'Hashimoto', 'CIS');\n"
            + "\n"
            + "INSERT INTO Semesters\n"
            + "VALUES	(\"FALL\", 2018),\n"
            + "		(\"SPRING\", 2019),\n"
            + "		(\"SUMMER\", 2019),\n"
            + "		(\"FALL\", 2019),\n"
            + "		(\"SPRING\", 2020),\n"
            + "		(\"SUMMER\", 2020),\n"
            + "		(\"FALL\", 2020),\n"
            + "		(\"SPRING\", 2021);\n"
            + "        \n"
            + "INSERT INTO Course_Details\n"
            + "VALUES	('ECON', 0858, 'FALL', 2020, '10:00:00', '11:15:00', \"MWF\", 'The American Economy', '123456789'),\n"
            + "		('ENG' , 0701, 'FALL', 2020, '12:00:00', '13:15:00', \"MWF\", 'Intro to Academic Discourse', 234567890),\n"
            + "        ('CIS', 2109, 'FALL', 2020, '08:00:00', '09:15:00', \"MWF\", 'Database Management Systems', 345678901),\n"
            + "        ('CIS', 2168, 'FALL', 2020, '17:00:00', '18:15:00', \"MWF\", 'Data Structures', 456789012),\n"
            + "        ('CIS', 1057, 'FALL', 2020, '17:00:00', '18:15:00', \"MWF\", 'Computer Programming in C', 456789012),\n"
            + "        ('CIS', 1051, 'FALL', 2020, '17:00:00', '18:15:00', \"MWF\", 'Introduction to Problem Solving and Programming in Python', 456789012),\n"
            + "		('JPNS', 1001, 'FALL', 2020, '13:00:00', '15:00:00', \"MWF\", 'Japanese Elements I', 456789012)\n"
            + "		;\n"
            + "        \n"
            + "INSERT INTO Students\n"
            + "VALUES 	(915909999, 'Curtis', 'Rumph', 'Information Technology'),\n"
            + "		(912345678, 'Silly', 'Wabbit', 'Economics'),\n"
            + "		(923456789, 'Daisuke', 'Oku', 'English'),\n"
            + "		(934567890, 'Chaki', 'Aki', 'Information Technology');\n"
            + "\n"
            + "INSERT INTO Student_Course_List\n"
            + "VALUES 	(915909999, 'ECON', '0858'),\n"
            + "		(915909999, 'CIS','1051'),\n"
            + "		(915909999, 'CIS', '1057'),\n"
            + "		(915909999, 'CIS','1068'),\n"
            + "        (912345678, 'CIS', '2109'),\n"
            + "		(912345678, 'CIS','2168'),\n"
            + "		(923456789, 'ENG', '0701'),\n"
            + "		(923456789, 'ECON','0858'),\n"
            + "        (923456789, 'JPNS','1001'),\n"
            + "		(934567890, 'ENG', '0701'),\n"
            + "		(934567890, 'CIS','2168');\n"
            + "       \n"
            + "\n"
            + "COMMIT;";

}
