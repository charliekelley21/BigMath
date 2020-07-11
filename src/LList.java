import java.util.NoSuchElementException;

/**
 * Linked List implementation
 * 
 * @author Charlie Kelley and Barak Finnegan
 *
 */
public class LList implements List {
    /**
     * Pointer to the head of the Linked List
     */
    protected Link head;

    /**
     * Pointer to the tail of the Linked List
     */
    protected Link tail;

    /**
     * Pointer to the current position of the Linked List
     */
    protected Link curr;

    /**
     * Current size of the LinkedList
     */
    protected int listSize;

    /**
     * Creates an empty Linked List
     */
    LList() {
        clear();
    }


    /**
     * Removes all elements from a Linked List
     */
    public void clear() {
        curr = tail = new Link(null); // create tail
        head = new Link(tail); // create header
        listSize = 0;
    }


    /**
     * Insert "newDigit" at current position
     * 
     * @param newDigit
     *            int to be inserted to Linked List
     * @return Boolean for successful appending
     */
    public boolean insert(int newDigit) {
        curr.setNext(new Link(curr.element(), curr.next()));
        curr.setElement(newDigit);
        if (tail == curr)
            tail = curr.next(); // new tail
        listSize++;
        return true;
    }


    /**
     * append "newDigit" at end of Linked List
     * 
     * @param newDigit
     *            int to be inserted to Linked List
     * @return Boolean for successful appending
     */
    public boolean append(int newDigit) {
        tail.setNext(new Link(null));
        tail.setElement(newDigit);
        tail = tail.next();
        listSize++;
        return true;
    }


    /**
     * Removes and returns current element
     * 
     * @return value that was removed from the Linked List
     */
    public int remove() throws NoSuchElementException {
        if (curr == tail) // nothing to remove
            throw new NoSuchElementException("remove() in LList has current of "
                + curr + " and size of " + listSize
                + " that is not a valid element");
        int removeDigit = curr.element(); // remember digit
        curr.setElement(curr.next().element()); // pull forward the next element
        if (curr.next() == tail)
            tail = curr; // removed last, move tail
        curr.setNext(curr.next().next()); // point around unneeded digit
        listSize--; // decrease List size by one
        return removeDigit; // return value

    }


    /**
     * Moves the current position to the start of the Linked List
     */
    public void moveToStart() {
        curr = head.next();
    }


    /**
     * Moves the current position to the end of the Linked List
     */
    public void moveToEnd() {
        curr = tail;
    }


    /**
     * Moves the current position to the next position of the Linked List that
     * is not the tail
     */
    public void next() {
        if (curr != tail)
            curr = curr.next();
    }


    /**
     * Number of Links currently within the Linked List
     * 
     * @return length number of Links within the Linked List
     */
    public int length() {
        return listSize;
    }


    /**
     * Moves the current position one step to the left; no change if now at
     * front
     */
    public void prev() {
        if (head.next() == curr)
            return;
        Link temp = head;
        while (temp.next() != curr)
            temp = temp.next();
        curr = temp;
    }


    /**
     * Return the position of the current element
     * 
     * @return current position
     */
    public int currPos() {
        Link temp = head.next();
        int i;
        for (i = 0; curr != temp; i++)
            temp = temp.next();
        return i;
    }


    /**
     * Move down Linked List to a specific position
     * 
     * @param pos
     *            position to move curr pointer to
     */
    public boolean moveToPos(int pos) {
        if ((pos < 0) || (pos > listSize))
            return false;
        curr = head.next();
        for (int i = 0; i < pos; i++)
            curr = curr.next();
        return true;
    }


    /**
     * Determines if the current position is at the end of the Linked List
     * 
     * @return Boolean if curr pointer is at the end of the list
     */
    public boolean isAtEnd() {
        return curr == tail;
    }


    /**
     * Determines if the Linked List contains no Links
     * 
     * @return Boolean if Linked List is empty
     */
    public boolean isEmpty() {
        return listSize == 0;
    }


    /**
     * Get the value assigned to the Link the is currently being pointed to
     * 
     * @return value of Link that curr points to
     */
    public int getValue() throws NoSuchElementException {
        if (curr == tail)
            throw new NoSuchElementException(
                "getValue() in LList has current of " + curr + " and size of "
                    + listSize + " that is not a valid element");
        return curr.element();
    }
}
