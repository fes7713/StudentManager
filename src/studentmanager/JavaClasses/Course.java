package studentmanager.JavaClasses;

/*
Department id (CIS) 				String		Primary key
        Course id (2109)			 	Int		Primary key

        Year, Semester (Spring 2021)			Semester Class
        Time (12- 13:00 MWF)			Date Class
        Title (Database) 				String
        Professor id 					Int		Foreign Key
*/

public class Course {
    private Department department;
    private int courseNumber;
    private String title;
    private Professor professor;
    private Semester semester;
    private Schedule timeAndDate;

    public Course() {
    }

    
    public Course(Department department, int courseNumber, String title) {
        this.department = department;
        this.courseNumber = courseNumber;
        this.title = title;
    }

    public Course(Department department, int courseNumber, String title, Professor professor, Schedule timeAndDate) {
        this.department = department;
        this.courseNumber = courseNumber;
        this.title = title;
        this.professor = professor;
        this.timeAndDate = timeAndDate;
    }

    public Course(Department department, int courseNumber, String title, Professor professor, Semester semester, Schedule timeAndDate) {
        this.department = department;
        this.courseNumber = courseNumber;
        this.title = title;
        this.professor = professor;
        this.semester = semester;
        this.timeAndDate = timeAndDate;
    }
 

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Schedule getTimeAndDate() {
        return timeAndDate;
    }

    public void setTimeAndDate(Schedule timeAndDate) {
        this.timeAndDate = timeAndDate;
    }

    @Override
    public String toString() {
        return department.getDepartmentID() + " " + courseNumber;
        
        
    }
    
    public String toFullString()
    {
        return "Course{" + "department=" + department + ", courseNumber=" + courseNumber + ", title=" + title + ", professor=" + professor + ", semester=" + semester + ", timeAndDate=" + timeAndDate + '}';
    }

}
