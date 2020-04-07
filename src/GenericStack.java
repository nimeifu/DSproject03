import java.util.ArrayList;

/**
 *The implemented GenericStack class, contains methods like push,peek, pop and etc.
 *@author Genjie Liu
 *@version 1.0
 *Lab section:Fri 10:25-11:20 Tuan Tran
 */

public class GenericStack<E> implements GenericStackInterface<E>{
    /**
     * The list of objects of this stack
     */
    private ArrayList<E> list;


    public GenericStack() {
        list=new ArrayList<E>();
    }

    /**
     * Get the number of objects in the stack.
     * @return an int represents the size of the stack.
     */
    @Override
    public int getSize() {
        return list.size();
    }

    /**
     *Get the reference of the top element of the stack.
     * @return a reference of the top element of this stack.
     */
    @Override
    public E peek() throws StackException{
        if(isEmpty()) {
            throw new StackException("This stack is empty");
        }
        else {
            return list.get(getSize() - 1);
        }
    }

    /**
     *Add an object to the top of the stack.
     * @param o the object being added.
     */
    @Override
    public void push(E o) {
        list.add(o);
    }

    /**
     * Remove from the top of the stack
     * @return a generic from the top of the stack.
     */
    @Override
    public E pop() {
        E temp=list.get(getSize()-1);
        list.remove(getSize()-1);
        return temp;
    }

    /**
     * Indicate if this stack is empty.
     * @return true if the stack is empty, otherwise false.
     */
    @Override
    public boolean isEmpty() {
        return (list.isEmpty());
    }
}
