
/**
 * Template Stack class ADT
 * 
 * @author Charlie Kelley (charlk21)
 * @source Copyright 2016 by OpenDSA Project Contributors and distributed under
 *         an MIT license
 * @version 2020.07.14
 *
 * @param <E>
 *            Object type stored in the Stack ADT
 */
public interface Stack<E> {
    /**
     * Reinitialize the stack
     */
    public void clear();


    /**
     * Push "it" onto the top of the stack
     * 
     * @param it
     *            value pushed onto the stack
     * @return successful push
     */
    public boolean push(E it);


    /**
     * Remove and return the element at the top of the stack
     * 
     * @return object popped from the stack
     */
    public E pop();


    /**
     * Return a copy of the top element
     * 
     * @return top object of the stack
     */
    public E topValue();


    /**
     * Return the number of elements in the stack
     * 
     * @return current length of the stack
     */
    public int length();


    /**
     * Tell if the stack is empty or not
     * 
     * @return true if the stack is empty
     */
    public boolean isEmpty();
}
