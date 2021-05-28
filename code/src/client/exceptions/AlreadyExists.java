package client.exceptions;

/**
 * Exception when object that is being put to database already exists there
 * @author Adam
 */
public class AlreadyExists extends Exception {
    public AlreadyExists(String errorMessage) {
        super(errorMessage);
    }
}
