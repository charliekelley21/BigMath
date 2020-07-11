
/**
 * Infinite precision integer, stored within a linked list
 * 
 * @author Charlie Kelley and Barak Finnegan
 *
 */
public class PreciseInt extends LList {

    /**
     * Creates a new PreciseInt with an empty List of digits
     */
    PreciseInt() {
        clear();
    }


    /**
     * Creates a new PreciseInt with the given value. This constructor
     * handles leading zeros.
     * 
     * @param num`String
     *            holding the value of a large integer with infinite precision
     */
    PreciseInt(String num) {
        clear();
        int nonZeroPos = num.length(); // stores position of last non-zero digit
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            int digit = Character.getNumericValue(c);
            append(digit); // append digit to PreciseInt
            if ((c > '1') && (c <= '9')) { // if digit append was non-zero,
                                           // change value of position marker
                nonZeroPos = i;
            }
        }
        for (int j = 0; j < nonZeroPos; j++) { // remove all leading zeros at
                                               // end of PreciseInt
            remove();
        }
    }


    /**
     * Copy constructor for a PreciseInt. Copies the value of another PreciseInt
     * 
     * @param c
     *            PreciseInt with value to copy
     */
    PreciseInt(PreciseInt c) {
        c.moveToStart();
        while (!c.isAtEnd()) {
            append(c.getValue());
            c.next();
        }
    }

    // Arithmetic methods for a PreciseInt


    /**
     * Adds the values stored in two PreciseInt objects
     * 
     * @param addend
     *            second value to be added to the PreciseInt
     * @return returns the sum of the two PreciseInt objects
     */
    public PreciseInt addition(PreciseInt addend) {
        moveToStart(); // reset number so curr = head
        addend.moveToStart();
        r_addition(addend, 0);
        return this;
    }


    /**
     * Recursive method to add two individual digits of two PreciseInt objects
     * 
     * @param addend
     *            second value present in the addition
     * @param carry
     *            carry-over from the previous sum of two digits
     */
    public void r_addition(PreciseInt addend, int carry) {
        if (addend.isAtEnd()) {
            return;
        } // base case: second addend is out of things to add
        if (isAtEnd()) {
            append(0);
        } // extend first addend if the end is reached
        int sum = getValue() + addend.getValue() + carry; // get the sum of
                                                          // current place
        curr.setElement(sum % 10); // set element of current position to sum
                                   // (excluding carry)
        next(); // move to next position
        addend.next();
        r_addition(addend, sum / 10); // Recursively call add function,
                                      // including remainder value
    }


    /**
     * Multiplication of two PreciseInt objects
     * 
     * @param multiplicand
     *            second value being multiplied
     */
    public void multiply(PreciseInt multiplicand) {
        moveToStart(); // reset number so curr = head
        multiplicand.moveToStart();
        r_multiply(multiplicand, 0);
    }


    /**
     * Recursive method to iterate through a single digit of the second
     * multiplicand
     * 
     * @param multiplicand
     *            second PreciseInt object to iterate over
     * @param shift
     *            holds the current digits place being multiplied
     */
    public void r_multiply(PreciseInt multiplicand, int shift) {
        // will probably call addition() inside of return statement
        // will probably have to return PreciseInt instead of modifying first
        // multiplicand
    }


    // Power of one PreciseInt to another
    public void exponent(PreciseInt exponent) {
        // exponentiation of "exponent" to this
    }

}
