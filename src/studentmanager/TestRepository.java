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
    private ArrayList<Department> departmentList;
    private ArrayList<Course> courseList;
    private ArrayList<Professor> professorList;
    
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
                new Course(cisDepartment, 1001, "Introduction to Academics in Computer Science"),
                new Course(cisDepartment, 1051, "Introduction to Problem Solving and Programming in Python"),
                new Course(cisDepartment, 1057, "Computer Programming in C"),
                new Course(cisDepartment, 1068, "Program Design and Abstraction"),
                new Course(cisDepartment, 1166, "Mathematical Concepts in Computing I"),
                new Course(cisDepartment, 2033, "Computational Probability and Statistics"),
                new Course(cisDepartment, 2107, "Computer Systems and Low-Level Programming"),
                new Course(cisDepartment, 2109, "Database Management Systems"),
                new Course(cisDepartment, 2166, "Mathematical Concepts in Computing II"),
                new Course(cisDepartment, 2168, "Data Structures")
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

    public ArrayList<Department> getDepartment() {
        return departmentList;
    }

    public ArrayList<Course> getCourse() {
        return courseList;
    }

    public ArrayList<Professor> getProfessor() {
        return professorList;
    }
    
    public void addDepartment(Department dept)
    {
        departmentList.add(dept);
    }
    
    public void addCourse(Course course)
    {
        courseList.add(course);
    }
    
    public void addProfessor(Professor prof)
    {
        professorList.add(prof);
    }
    
    public static ArrayList<Department> getDepartments() {
        return new ArrayList<Department>(Arrays.asList(
                new Department("MATH", "Mathematics"),
                new Department("BIO", "Biology"),
                new Department("CHEM", "Chemistry"),
                new Department("CIS", "Computer & Information Sciences"),
                new Department("MATH", "Mathematics"),
                new Department("PHY", "Physics"),
                new Department("EES", "Earth & Environmental Science")
        ));
    }

    public static ArrayList<Course> getCourses() {
        Department cisDepartment = new Department("CIS", "Computer & Information Sciences");
        return new ArrayList<>(Arrays.asList(
                new Course(cisDepartment, 1001, "Introduction to Academics in Computer Science"),
                new Course(cisDepartment, 1051, "Introduction to Problem Solving and Programming in Python"),
                new Course(cisDepartment, 1057, "Computer Programming in C"),
                new Course(cisDepartment, 1068, "Program Design and Abstraction"),
                new Course(cisDepartment, 1166, "Mathematical Concepts in Computing I"),
                new Course(cisDepartment, 2033, "Computational Probability and Statistics"),
                new Course(cisDepartment, 2107, "Computer Systems and Low-Level Programming"),
                new Course(cisDepartment, 2109, "Database Management Systems"),
                new Course(cisDepartment, 2166, "Mathematical Concepts in Computing II"),
                new Course(cisDepartment, 2168, "Data Structures")
        ));
    }

    public static ArrayList<Professor> getProfessors() {
        Department cisDepartment = new Department("CIS", "Computer & Information Sciences");
        return new ArrayList<>(Arrays.asList(
                new Professor("Spartak", "Gurgen", cisDepartment),
                new Professor("Arevig", "Gevorg", cisDepartment),
                new Professor("Gurgen", "Davit", cisDepartment),
                new Professor("Narek", "Ari", cisDepartment),
                new Professor("Linzi", "Clare", cisDepartment),
                new Professor("Jasmyn", "Buster", cisDepartment),
                new Professor("Janella", "Rosamond", cisDepartment),
                new Professor("Harleigh", "Genette", cisDepartment),
                new Professor("Fred", "Thurstan", cisDepartment)));
    }
    
    
}
