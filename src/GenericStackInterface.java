/**
 * Interface of GenericStack.
 * @author Genjie Liu
 * @version 1.0
 * Lab section:Fri 10:25-11:20 Tuan Tran
 */

public interface GenericStackInterface<E>{
    int getSize();
    E peek();
    void push(E o);
    E pop();
    boolean isEmpty();

}

