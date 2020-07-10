
// Infinite precision integer, stored within a linked list
public class PreciseInt extends LList {

    // Constructors
    PreciseInt() {
        clear();
    }
    
    PreciseInt(String num) {
        clear();
        // store string value into Linked List Integer
        // include error checking for string
        // include logic to remove non-significant figures
    }
    
    // Copy Constructor
    PreciseInt(PreciseInt c) {
        c.moveToStart();
        while (!c.isAtEnd()) {
            append(c.getValue());
            c.next();
        }
    }
    
    // Simplifies Integer value by shifting down any overflow or carry-overs leftover from arithmetic 
    public void simplify() {
        moveToStart();
        int simple;
        while (!isAtEnd()) {
            simple = getValue();
            if (simple > 9) {
                // set value = simple%10
                // add one to next element
            }
            next();
        }
    }

    // Arithmetic methods for a PreciseInt

    // Addition of two PreciseInts
    public PreciseInt addition(PreciseInt addend) {
        moveToStart();                                      // reset number so curr = head
        addend.moveToStart();
        r_addition(addend, 0);
        return this;
    }
    
    // Recursive addition
    public void r_addition(PreciseInt addend, int carry) {
        if (addend.isAtEnd()) { return; }                   // base case: second addend is out of things to add
        if (isAtEnd()) { append(0); }                       // extend first addend if the end is reached
        int sum = getValue() + addend.getValue() + carry;   // get the sum of current place
        curr.setElement(sum%10);                            // set element of current position to sum (excluding carry)
        next();                                             // move to next position
        addend.next();
        r_addition(addend, sum / 10);                       // Recursively call add function, including remainder value
    }


    // Multiplication of two PreciseInts
    public void multiply(PreciseInt multiplicand) {
        moveToStart();                                      // reset number so curr = head
        multiplicand.moveToStart();
        r_multiply(multiplicand, 0);
    }
    
    // recursive multiplication
    public void r_multiply(PreciseInt multiplicand, int shift) {
        // will probably call addition() inside of return statement
        // will probably have to return PreciseInt instead of modifying first multiplicand
    }

    // Power of one PreciseInt to another
    public void exponent(PreciseInt exponent) {
        // exponentiation of "exponent" to this
    }

}
