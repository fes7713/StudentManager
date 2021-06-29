package studentmanager.JavaClasses;

import java.util.List;
import studentmanager.Repository.MySQL;

/*
        TU id						Int		Primary key
		Name
			First Name				String
			Last Name				String
		Major						String
		Department id 						Foreign Key
 */

public class Student {
    private int TU_id;
    private String firstName;
    private String lastName;
    private String major;
    private Department department;
    List<Course> courseTaking;

    public Student()
    {
        
    }
    
    public Student (int TU_id)
    {
        this.TU_id = TU_id;
    }
    
    public Student(int TU_id, String firstName, String lastName, String major, Department department, List<Course> courses) {
        this.TU_id = TU_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.department = department;
        courseTaking = courses;
    }

    public int getTU_id() {
        return TU_id;
    }

    public void setTU_id(int TU_id) {
        this.TU_id = TU_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Course> getCourseTaking() {
        return courseTaking;
    }

    public void setCourseTaking(List<Course> courseTaking) {
        this.courseTaking = courseTaking;
    }

    @Override
    public String toString() {
        return "Student{" + "TU_id=" + TU_id + ", firstName=" + firstName + ", lastName=" + lastName + ", major=" + major + ", department=" + department + ", courseTaking=" + courseTaking + '}';
    }
    
    public void set(MySQL attr, Object value)
    {
        switch(attr)
        {
            case TU_ID : setTU_id((int)value); return;
            case STUDENT_FIRST_NAME : setFirstName((String) value); return;
            case STUDENT_LAST_NAME : setLastName((String) value); return;
            case MAJOR : setMajor((String) value); return;
            case COURSELIST : setCourseTaking((List<Course>)value); return;
        }
    }
}
