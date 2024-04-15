package is.hi.hbv202g.assignment8;

public class FacultyMember extends User {

    // instance variables
    private String department;

    /**
     * Constructor
     * 
     * @param name       name of the faculty member
     * @param department department of the faculty member
     */
    public FacultyMember(String name, String department) {
        super(name);
        this.department = department;
    }

    /**
     * Get department
     * 
     * @return department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Set department
     * 
     * @param department department
     */
    public void setDepartment(String department) {
        this.department = department;
    }
}
