import java.util.NoSuchElementException;

// Linked List implementation
public class LList implements List {
    protected Link head; // Pointer to List header
    protected Link tail; // Pointer to List tail
    protected Link curr; // Pointer to current Link
    protected int listSize; // Size of List

    // Constructors
    LList() {
        clear();
    }


    // remove all elements
    public void clear() {
        curr = tail = new Link(null); // create tail
        head = new Link(tail); // create header
        listSize = 0;
    }


    // Insert "newDigit" at current position
    public boolean insert(int newDigit) {
        curr.setNext(new Link(curr.element(), curr.next()));
        curr.setElement(newDigit);
        if (tail == curr)
            tail = curr.next(); // new tail
        listSize++;
        return true;
    }


    // Append "newDigit" to List
    public boolean append(int newDigit) {
        tail.setNext(new Link(null));
        tail.setElement(newDigit);
        tail = tail.next();
        listSize++;
        return true;
    }


    // Remove and return current element
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


    public void moveToStart() {
        curr = head.next();
    }


    public void moveToEnd() {
        curr = tail;
    }


    public void next() {
        if (curr != tail)
            curr = curr.next();
    }


    public int length() {
        return listSize;
    }


    // Move curr one step to the left; no change if now at front
    public void prev() {
        if (head.next() == curr)
            return;
        Link temp = head;
        while (temp.next() != curr)
            temp = temp.next();
        curr = temp;
    }


    // Return the position of the current element
    public int currPos() {
        Link temp = head.next();
        int i;
        for (i = 0; curr != temp; i++)
            temp = temp.next();
        return i;
    }


    // Move down List to "pos" position
    public boolean moveToPos(int pos) {
        if ((pos < 0) || (pos > listSize))
            return false;
        curr = head.next();
        for (int i = 0; i < pos; i++)
            curr = curr.next();
        return true;
    }


    // return true if current position is at end of list
    public boolean isAtEnd() {
        return curr == tail;
    }


    // return true if List is empty
    public boolean isEmpty() {
        return listSize == 0;
    }


    // return current element value
    public int getValue() throws NoSuchElementException {
        if (curr == tail)
            throw new NoSuchElementException(
                "getValue() in LList has current of " + curr + " and size of "
                    + listSize + " that is not a valid element");
        return curr.element();
    }
}
