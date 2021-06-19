/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanager;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author fes77
 */
public class TestRepository {
    static ArrayList<Department> departmentList;
    static ArrayList<Course> courseList;
    static ArrayList<Professor> professorList;
    
    public TestRepository()
    {
        departmentList = new ArrayList<Department>(Arrays.asList(
                new Department("MATH", "Mathematics"),
                new Department("BIO", "Biology"),
                new Department("CHEM", "Chemistry"),
                new Department("CIS", "Computer & Information Sciences"),
                new Department("MATH", "Mathematics"),
                new Department("PHY", "Physics"),
                new Department("EES", "Earth & Environmental Science")
        ));
        
        Department cisDepartment = new Department("CIS", "Computer & Information Sciences");
        courseList = new ArrayList<>(Arrays.asList(
                new Course(1001, cisDepartment, "Introduction to Academics in Computer Science"),
                new Course(1051, cisDepartment, "Introduction to Problem Solving and Programming in Python"),
                new Course(1057, cisDepartment, "Computer Programming in C"),
                new Course(1068, cisDepartment, "Program Design and Abstraction"),
                new Course(1166, cisDepartment, "Mathematical Concepts in Computing I"),
                new Course(2033, cisDepartment, "Computational Probability and Statistics"),
                new Course(2107, cisDepartment, "Computer Systems and Low-Level Programming"),
                new Course(2109, cisDepartment, "Database Management Systems"),
                new Course(2166, cisDepartment, "Mathematical Concepts in Computing II"),
                new Course(2168, cisDepartment, "Data Structures")
        ));
        
        professorList = new ArrayList<>(Arrays.asList(
                new Professor("Spartak", "Gurgen", departmentList.get(2))));
                new Professor("Arevig", "Gevorg", departmentList.get(3));
                new Professor("Gurgen", "Davit", departmentList.get(2));
                new Professor("Narek", "Ari", departmentList.get(4));
                new Professor("Linzi", "Clare", departmentList.get(5));
                new Professor("Jasmyn", "Buster", departmentList.get(1));
                new Professor("Janella", "Rosamond", departmentList.get(0));
                new Professor("Harleigh", "Genette", departmentList.get(6));
                new Professor("Fred", "Thurstan", departmentList.get(0));
    }
    
    
    public static ArrayList<Department> getDepartments() {
        departmentList = new ArrayList<Department>(Arrays.asList(
                new Department("MATH", "Mathematics"),
                new Department("BIO", "Biology"),
                new Department("CHEM", "Chemistry"),
                new Department("CIS", "Computer & Information Sciences"),
                new Department("MATH", "Mathematics"),
                new Department("PHY", "Physics"),
                new Department("EES", "Earth & Environmental Science")
        ));
        return departmentList;
    }

    public static ArrayList<Course> getCourses() {
        Department cisDepartment = new Department("CIS", "Computer & Information Sciences");
        courseList = new ArrayList<>(Arrays.asList(
                new Course(1001, cisDepartment, "Introduction to Academics in Computer Science"),
                new Course(1051, cisDepartment, "Introduction to Problem Solving and Programming in Python"),
                new Course(1057, cisDepartment, "Computer Programming in C"),
                new Course(1068, cisDepartment, "Program Design and Abstraction"),
                new Course(1166, cisDepartment, "Mathematical Concepts in Computing I"),
                new Course(2033, cisDepartment, "Computational Probability and Statistics"),
                new Course(2107, cisDepartment, "Computer Systems and Low-Level Programming"),
                new Course(2109, cisDepartment, "Database Management Systems"),
                new Course(2166, cisDepartment, "Mathematical Concepts in Computing II"),
                new Course(2168, cisDepartment, "Data Structures")
        ));
        return courseList;
    }

    public static ArrayList<Professor> getProfessors() {
        professorList = new ArrayList<>(Arrays.asList(
                new Professor("Spartak", "Gurgen", departmentList.get(2)),
                new Professor("Arevig", "Gevorg", departmentList.get(3)),
                new Professor("Gurgen", "Davit", departmentList.get(2)),
                new Professor("Narek", "Ari", departmentList.get(4)),
                new Professor("Linzi", "Clare", departmentList.get(5)),
                new Professor("Jasmyn", "Buster", departmentList.get(1)),
                new Professor("Janella", "Rosamond", departmentList.get(0)),
                new Professor("Harleigh", "Genette", departmentList.get(6)),
                new Professor("Fred", "Thurstan", departmentList.get(0))));
        return professorList;
    }
    
    
}
