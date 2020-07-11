
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
     * Recursive method to add two individual digits of two PreciseInt objects
     * 
     * @param addend
     *            second value present in the addition
     * @param start
     *            signifies if a given call to the recursive addition
     *            function is the first in the loop
     * @param carry
     *            carry-over from the previous sum of two digits
     */
    public PreciseInt addition(PreciseInt addend, boolean start, int carry) {
        if (start) { // Initialize first call so that
            moveToStart(); // addition starts at the beginning
            addend.moveToStart(); // of both PreciseInt objects
        }
        if (addend.isAtEnd()) { // base case: second addend is out of things to
                                // add
            return this;
        }
        if (isAtEnd()) { // extend first addend if the end is reached
            append(0);
        }
        int sum = getValue() + addend.getValue() + carry; // get the sum of
                                                          // current place
        curr.setElement(sum % 10); // set element of current position to sum
                                   // (excluding carry)
        next(); // move to next position
        addend.next();
        return addition(addend, false, sum / 10); // Recursively call add
                                                  // function, including
                                                  // remainder value
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
    public PreciseInt multiply(
        PreciseInt multiplicand,
        boolean start,
        int shift) {
        if (start) { // start multiplication at the beginning of first
                     // multiplicand
            moveToStart();
        }
        multiplicand.moveToStart(); // set second multiplicand to start before
                                    // every iteration
        PreciseInt temp = new PreciseInt();
        if (isAtEnd()) { // base case: if there are no more digits to multiply,
                         // terminate the recursion
            return temp;
        }

        int carry = 0;
        while (!multiplicand.isAtEnd()) { // loop through and multiply the
                                          // current digit by the second
                                          // multiplicand
            int product = (getValue() * multiplicand.getValue()) + carry;
            temp.append(product % 10); // store least significant digit of the
                                       // product
            carry = product / 10; // carry over the most significant digit
            multiplicand.next();
        }
        for (int i = 0; i < shift; i++) { // shift final product based on place
                                          // of the current digit to reserve
                                          // precision
            temp.append(0);
        }
        next(); // shift current digit being multiplied
        // sum together the product of every digit by the multiplicand
        return temp.addition(multiply(multiplicand, true, shift + 1), true, 0);
    }


    // Power of one PreciseInt to another
    public void exponent(PreciseInt exponent) {
        // exponentiation of "exponent" to this
    }

}
