package client.exceptions;

/**
 * Exception to be thrown when database query returns no data
 * @author Adam
 */
public class DoesNotExist extends Exception{
    public DoesNotExist (String error){
        super(error);
    }
}
