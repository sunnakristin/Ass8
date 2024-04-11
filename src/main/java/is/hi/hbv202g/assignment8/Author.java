package is.hi.hbv202g.assignment8;

public class Author {

    // fields
    private String name;

    /**
     * Constructor
     * 
     * @param name name of the author
     */
    public Author(String name) {
        this.name = name;
    }

    /**
     * Retrieves the name of the object.
     *
     * @return the name of the object
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the object.
     *
     * @param name the new name of the object
     */
    public void setName(String name) {
        this.name = name;
    }

}
