package studentmanager.JavaClasses;

import studentmanager.Repository.MySQL;

public class Professor {
    private int professorId;
    private String firstName;
    private String lastName;
    private Department department;

    public Professor()
    {
        department = new Department();
    }
    
    public Professor(int professorId, String firstName, String lastName, Department department) {
        this.professorId = professorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
    public void setDepartment(String departmentID) {
        department.setDepartmentID(departmentID);
    }

    @Override
    public String toString() {
        return firstName + " "  + lastName + " (" + department.getDepartmentID() + ")";
    }
    
    public void set(MySQL attr, Object value)
    {
        switch(attr)
        {
            case PROFESSOR_ID: setProfessorId((int)value); return;
            case PROFESSOR_FIRST_NAME : setFirstName((String) value); return;
            case PROFESSOR_LAST_NAME : setLastName((String) value); return;
            case DEPARTMENT_ID : setDepartment((String)value); return;
        }
    }
}
