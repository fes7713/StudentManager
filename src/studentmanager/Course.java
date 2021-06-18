package studentmanager;

/*
Department id (CIS) 				String		Primary key
        Course id (2109)			 	Int		Primary key

        Year, Semester (Spring 2021)			Semester Class
        Time (12- 13:00 MWF)			Date Class
        Title (Database) 				String
        Professor id 					Int		Foreign Key
*/

public class Course {
    private int courseNumber;
    private Department department;
    private String title;
    private Professor professor;
    private Semester semester;
    private Date timeAndDate;

    public Course(int courseNumber, Department department, String title) {
        this.courseNumber = courseNumber;
        this.department = department;
        this.title = title;
    }

    public Course(int courseNumber, Department department, String title, Professor professor, Semester semester, Date timeAndDate) {
        this.courseNumber = courseNumber;
        this.department = department;
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

    public Date getTimeAndDate() {
        return timeAndDate;
    }

    public void setTimeAndDate(Date timeAndDate) {
        this.timeAndDate = timeAndDate;
    }

    @Override
    public String toString() {
        return department.getDepartmentID() + " "+ courseNumber;
    }
}
