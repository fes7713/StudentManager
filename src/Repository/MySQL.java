/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

/**
 *
 * @author fes77
 */
public enum MySQL {
    STUDENT,
    COURSE,
    COURSELIST,
    PROFESSOR,
    DEPARTMENT,
    
//    Student Table Attributes
    TU_ID,
    STUDENT_FIRST_NAME,
    STUDENT_LAST_NAME,
    MAJOR,
    
//    Department Table Attributes
    DEPARTMENT_ID,
    DEPARTMENT_NAME,
    
//    Course Details Table Attributes
    COURSE_ID,
    SEMESTER_TAKEN,
    START_TIME,
    END_TIME,
    DAYS,
    COURSE_TITLE,
    
//    Professor Table Attributes
    PROFESSOR_ID,
    PROFESSOR_FIRST_NAME,
    PROFESSOR_LAST_NAME,
    
    
    
    
}
