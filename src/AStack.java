
/**
 * Stack implemented using an Array
 * Copyright 2016 by OpenDSA Project Contributors and distributed under
 *     an MIT license
 * 
 * @author Charlie Kelley (charlk21)
 * 
 * @version 2020.07.14
 *
 * @param <E>
 *            type of value that is stored within the stack
 */
class AStack<E> implements Stack<E> {
    /**
     * array of type <E> that will maintain the values of the stack
     */
    private E stackArray[]; // Array holding stack

    /**
     * default size of the stack if the size was not specified
     */
    private static final int DEFAULT_SIZE = 100;

    /**
     * Maximum size that the stack can reach
     */
    private int maxSize; // Maximum size of stack

    /**
     * Contains the first free position on top of the stack
     */
    private int top; // First free position at top

    /**
     * Creates an empty stack of a given size
     * 
     * @param size
     *            size of the array to hold the stack
     */
    @SuppressWarnings("unchecked") // Generic array allocation
    AStack(int size) {
        maxSize = size;
        top = 0;
        stackArray = (E[])new Object[size]; // Create stackArray
    }


    /**
     * Creates an empty stack of the default size
     */
    AStack() {
        this(DEFAULT_SIZE);
    }


    /**
     * Removes all elements from the stack
     */
    public void clear() {
        top = 0;
    } // Reinitialize stack


    /**
     * Push "it" onto stack
     * @param it object to be pushed onto the stack
     * @return Boolean if push was successful
     */
    public boolean push(E it) {
        if (top >= maxSize)
            return false;
        stackArray[top++] = it;
        return true;
    }


    /**
     * Remove and return top element
     * 
     * @return top element of the stack that is popped
     */
    public E pop() {
        if (top == 0)
            return null;
        return stackArray[--top];
    }


    /**
     * Determines the top value on the stack without removing that object
     * 
     * @return top value of the stack
     */
    public E topValue() { // Return top element
        if (top == 0)
            return null;
        return stackArray[top - 1];
    }


    /**
     * Return the length of the stack
     * 
     * @return number of elements in the stack
     */
    public int length() {
        return top;
    } // Return stack size


    /**
     * Determines if the stack is empty
     * 
     * @return Boolean value if stack size equals zero
     */
    public boolean isEmpty() {
        return top == 0;
    } // Tell if the stack is empty
}
