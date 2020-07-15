
/**
 * Class for a Link that provides the nodes that a Linked List is built upon
 * 
 * @author Charlie Kelley (charlk21)
 * @source Copyright 2016 by OpenDSA Project Contributors and distributed under
 *         an MIT license
 * @version 2020.07.14
 *
 */
public class Link {
    /**
     * Value for this node
     */
    private int digit;

    /**
     * Pointer to the next node in the List
     */
    private Link ptr;

    /**
     * Creates a node with a given value that also points to another node
     * 
     * @param newDigit
     *            value of node
     * @param newPtr
     *            pointer to next node
     */
    Link(int newDigit, Link newPtr) {
        digit = newDigit;
        ptr = newPtr;
    }


    /**
     * Creates a node that points to another node
     * 
     * @param newPtr
     *            pointer to the next node
     */
    Link(Link newPtr) {
        ptr = newPtr;
    }


    /**
     * Gets the value of the node
     * 
     * @return value stored in the node
     */
    int element() {
        return digit;
    }


    /**
     * Modifies the value of the node
     * 
     * @param newDigit
     *            new value of the node
     * @return modified value
     */
    int setElement(int newDigit) {
        return digit = newDigit;
    }


    /**
     * Provides a pointer the the next node
     * 
     * @return pointer to the next node
     */
    Link next() {
        return ptr;
    }


    /**
     * Modifies the next node that is pointed to
     * 
     * @param newPtr
     *            new pointer
     * @return pointer to modified next node
     */
    Link setNext(Link newPtr) {
        return ptr = newPtr;
    }

}
