/**
 * Stack exception
 * @author Genjie Liu
 * @version 1.0
 * Lab section:Fri 10:25-11:20 Tuan Tran
 */
public class StackException extends RuntimeException {
    /**
     *Throws exceptions caused by the stack
     * @param message stack expression.
     */
    public StackException(String message)
    {
        super(message);
    }
}
