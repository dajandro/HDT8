/**
* Universidad del Valle de Guatemala
* Pablo Diaz 13203
* Daniel Orozco 13312
*/

/**
 *
 * @author Daniel Orozco <daniel.orozco>
 */
public class DuplicateItemException extends RuntimeException {
    
    /**
     * Construct this exception object.
     */
    public DuplicateItemException( )
    {
        super( );
    }
    /**
     * Construct this exception object.
     * @param message the error message.
     */
    public DuplicateItemException( String message )
    {
        super( message );
    }
    
}
