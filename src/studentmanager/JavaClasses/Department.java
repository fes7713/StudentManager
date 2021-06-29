package studentmanager.JavaClasses;

import studentmanager.Repository.MySQL;

public class Department {
    private String departmentID;
    private String title;

    public Department()
    {
        
    }
    
    public Department(String departmentID)
    {
        this.departmentID = departmentID;
    }
    
    public Department(String departmentID, String title) {
        this.departmentID = departmentID;
        this.title = title;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        if(title == null)
            return departmentID;
        else
            return departmentID + " " + title;
    }
    
    public void set(MySQL attr, Object value)
    {
        switch(attr)
        {
            case DEPARTMENT_ID: setDepartmentID((String)value); return;
            case DEPARTMENT_NAME : setTitle((String) value); return;
        }
    }
}
