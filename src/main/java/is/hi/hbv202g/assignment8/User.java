package is.hi.hbv202g.assignment8;

public abstract class User {

    // fields
    private String name;

    /**
     * Constructor
     * 
     * @param name name of the user
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * Get name
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name
     * 
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

}
