package studentmanager;

public class Department {
    private String departmentID;
    private String title;

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
        return departmentID + " " + title;
    }
}
