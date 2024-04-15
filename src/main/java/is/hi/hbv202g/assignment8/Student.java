package is.hi.hbv202g.assignment8;

public class Student extends User {

    // instance variables
    private boolean feePaid;

    /**
     * Constructor
     * 
     * @param name    name of the student
     * @param feePaid fee payment status of the student
     */
    public Student(String name, boolean feePaid) {
        super(name);
        this.feePaid = feePaid;
    }

    /**
     * Get fee payment status
     * 
     * @return fee payment status
     */
    public boolean isFeePaid() {
        return feePaid;
    }

    /**
     * Set fee payment status
     * 
     * @param feePaid fee payment status
     */
    public void setFeePaid(boolean feePaid) {
        this.feePaid = feePaid;
    }

}
