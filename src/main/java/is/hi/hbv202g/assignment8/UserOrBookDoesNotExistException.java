package is.hi.hbv202g.assignment8;

public class UserOrBookDoesNotExistException extends Exception {

    /**
     * Constructor
     * 
     * @param message message
     */
    public UserOrBookDoesNotExistException(String message) {
        super(message);
    }
}
