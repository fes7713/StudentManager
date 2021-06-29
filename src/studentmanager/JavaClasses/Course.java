package studentmanager.JavaClasses;

import java.sql.Time;
import java.time.LocalTime;
import java.time.Year;
import java.util.List;
import studentmanager.Repository.MySQL;

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
        department = new Department();
        professor = new Professor();
        semester = new Semester();
        timeAndDate = new Schedule();
    }

    
    public Course(Department department, int courseNumber, String title) {
        this.department = department;
        this.courseNumber = courseNumber;
        this.title = title;
        professor = new Professor();
        semester = new Semester();
        timeAndDate = new Schedule();
    }

    public Course(Department department, int courseNumber, String title, Professor professor, Schedule timeAndDate) {
        this.department = department;
        this.courseNumber = courseNumber;
        this.title = title;
        this.professor = professor;
        this.timeAndDate = timeAndDate;
        semester = new Semester();
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
    
    public void setDepartment(String departmentID) {
        department = new Department(departmentID);
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
    
    public void setProfessor(int professorId) {
        professor.setProfessorId(professorId);
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }
    
    public void setYear(int year)
    {
        semester.setYear(year);
    }
    
    public void setSeason(String season)
    {
        semester.setSeason(season);
    }

    public Schedule getTimeAndDate() {
        return timeAndDate;
    }

    public void setTimeAndDate(Schedule timeAndDate) {
        this.timeAndDate = timeAndDate;
    }
    
    public void setStartTime(LocalTime startTime)
    {
        timeAndDate.setStartTime(startTime);
    }
    
    public void setEndTime(LocalTime endTime)
    {
        timeAndDate.setEndTime(endTime);
    }
    
    public void setDays(String days)
    {
        if(days.contains("Sa"))
        {
            if(days.length() - days.replace("S", "").length() == 2)
            {
                
            }
        }
        
    }

    @Override
    public String toString() {
        return department.getDepartmentID() + " " + courseNumber;
        
        
    }
    
    public String toFullString()
    {
        return "Course{" + "department=" + department + ", courseNumber=" + courseNumber + ", title=" + title + ", professor=" + professor + ", semester=" + semester + ", timeAndDate=" + timeAndDate + '}';
    }

    public void set(MySQL attr, Object value)
    {
        switch(attr)
        {
            case DEPARTMENT_ID: setDepartment((String)value); return;
            case COURSE_ID : setCourseNumber((int) value); return;
            case COURSE_TITLE : setTitle((String) value); return;
            case PROFESSOR : setProfessor((Professor) value); return;
            case SEMESTER_TAKEN : setSemester((Semester)value); return;
            case SCHEDULE: setTimeAndDate((Schedule)value); return;
            case START_TIME: setStartTime(((Time)value).toLocalTime()); return;
            case END_TIME: setEndTime(((Time)value).toLocalTime()); return;
            case SEASON: setSeason((String)value); return;
            case YEAR: setYear((int)value); return;
            case DAYS: setDays((String)value); return;
            case PROFESSOR_ID: setProfessor((int)value); return;
        }
    }
}
