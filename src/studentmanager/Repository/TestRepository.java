// INSTRUCTION :
//      ****This is Test Repository Class****

// Use this to test your form until MySQL team makes database for this project.
// There are two type of methods in this class
// 1) Static methods with default values, which returns the same sets of values
//      == this does not provide add option.
// 2) Class methods with default values, where you can change inside data in runtime
//      == this provides add option so if you implement add option use this.

// Use static method for the first testing and later change it to class method.

// How to call methods.
// Static methods
//      TestRepository.getProfessors()
// Class methods
//      TestRepository repo = new TestRepository()
//      List<Course> courses = repo.getCourse

// No "s" in class methods


package studentmanager.Repository;

import studentmanager.JavaClasses.Department;
import studentmanager.JavaClasses.Course;
import studentmanager.JavaClasses.Semester;
import studentmanager.JavaClasses.Professor;
import studentmanager.JavaClasses.Season;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author fes77
 */
public class TestRepository {
    private ArrayList<Department> departmentList;
    private ArrayList<Course> courseList;
    private ArrayList<Professor> professorList;
    private ArrayList<Semester> semesterList;
    
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
                
        semesterList = new ArrayList<>(Arrays.asList(
                new Semester(Season.SPRING, Year.of(2019)),
                new Semester(Season.SUMMER, Year.of(2019)),
                new Semester(Season.FALL, Year.of(2019)),
                new Semester(Season.SPRING, Year.of(2020)),
                new Semester(Season.SUMMER, Year.of(2020)),
                new Semester(Season.FALL, Year.of(2020))));
    }

    public List<Department> getDepartment() {
        return departmentList;
    }

    public List<Course> getCourse() {
        return courseList;
    }

    public List<Professor> getProfessor() {
        return professorList;
    }

    public List<Semester> getSemester() {
        return semesterList;
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
    
    public void addSemester(Semester sem)
    {
        semesterList.add(sem);
    }
    
    // Returns default values
    public static List<Department> getDepartments() {
        return new ArrayList<>(Arrays.asList(
                new Department("MATH", "Mathematics"),
                new Department("BIO", "Biology"),
                new Department("CHEM", "Chemistry"),
                new Department("CIS", "Computer & Information Sciences"),
                new Department("MATH", "Mathematics"),
                new Department("PHY", "Physics"),
                new Department("EES", "Earth & Environmental Science")
        ));
    }

    public static List<Course> getCourses() {
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

    public static List<Professor> getProfessors() {
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
    
    public static List<Semester> getSemesters()
    {
        return new ArrayList<>(Arrays.asList(
                new Semester(Season.SPRING, Year.of(2019)),
                new Semester(Season.SUMMER, Year.of(2019)),
                new Semester(Season.FALL, Year.of(2019)),
                new Semester(Season.SPRING, Year.of(2020)),
                new Semester(Season.SUMMER, Year.of(2020)),
                new Semester(Season.FALL, Year.of(2020))));
    }
    
    
}
