package studentmanager;

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

    public Student(int TU_id, String firstName, String lastName, String major, Department department) {
        this.TU_id = TU_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.department = department;
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

    public static void exec()
    {

    }
}
