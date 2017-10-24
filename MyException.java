
/**
 *This class defines a custom exception class
 * @author Gurjeet Sandhu
 * @since June 15, 2017
 * @version 1.0
 */
public class MyException extends Exception {
    /**
     * This constructor create objects of MyException
     * @param message this is message to be printed to user when there is an error
     */
    public MyException(String message )
    {
        super(message);
    }
    
}
