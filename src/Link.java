
public class Link {
    private int digit;  //value for this node
    private Link ptr;   // point to the next node in list
    
    // Constructors
    Link(int newDigit, Link newPtr) { digit = newDigit; ptr = newPtr; }
    Link(Link newPtr) { ptr = newPtr; }
    
    // Getters and setters for digit and Link pointer stored
    int element() { return digit; }
    int setElement(int newDigit) { return digit = newDigit; }
    Link next() { return ptr; }
    Link setNext(Link newPtr) { return ptr = newPtr; }
    
}
