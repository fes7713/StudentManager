/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanager;

import studentmanager.EntryForm.CourseEntry;
import studentmanager.EntryForm.DepartmentEntry;
import studentmanager.EntryForm.StudentEntry;
import studentmanager.JavaClasses.Student;
import studentmanager.JavaClasses.Department;
import studentmanager.JavaClasses.Course;

/**
 *
 * @author fes77
 */
public class StudentManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Testing course Entry
        DepartmentEntry departmentEntry = new DepartmentEntry();
        Department department = departmentEntry.exec();
         System.out.println(department);
         
        // Testing course Entry
        CourseEntry courseEntry = new CourseEntry();
        Course course = courseEntry.exec();
         System.out.println(course.toFullString());
       
         // Testing Student Entry
        StudentEntry studentEntry = new StudentEntry();
        Student student = studentEntry.exec();
        System.out.println(student);
    }
    
    
    
}
