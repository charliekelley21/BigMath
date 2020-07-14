
/**
 * Infinite precision integer, stored within a linked list
 * 
 * @author Charlie Kelley (charlk21)
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.13
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
            if (c != '0') { // if digit append was non-zero,
                            // change value of position marker
                nonZeroPos = i;
            }
        }
        moveToPos(nonZeroPos + 1);
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


    /**
     * This method recursively creates a String representation of PreciseInt
     * 
     * @param start
     *            boolean representing the whether to go to start
     * @return String of PreciseInt
     */
    public String getIntValue(boolean start) {
        if (start) {
            moveToStart();
        }
        if (isAtEnd()) {
            return "";
        }
        String d = Integer.toString(getValue());
        next();
        return getIntValue(false) + d;
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
            if (carry != 0) {
                append(carry);
            }
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
    public PreciseInt multiply(PreciseInt multiplicand, int shift) {
        moveToPos(shift);
        multiplicand.moveToStart(); // set second multiplicand to start before
                                    // every iteration
        PreciseInt temp = new PreciseInt();
        if (isAtEnd()) { // base case: if there are no more digits to multiply,
                         // terminate the recursion
            return temp;
        }

        for (int i = 0; i < shift; i++) { // shift final product based on place
            // of the current digit to reserve
            // precision
            temp.append(0);
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
        if (carry != 0) { temp.append(carry); }
        next(); // shift current digit being multiplied
        // sum together the product of every digit by the multiplicand
        return temp.addition(multiply(multiplicand, shift + 1), true, 0);
    }


    /**
     * This is an exponentiation method for the PreciseInt class.
     * 
     * @param exponent
     *            This PreciseInt ^ exponent.
     */
    public PreciseInt exponent(PreciseInt exponent) {
        // if exponent 0 or 1 return 1 or this respectively
        String exponentInt = exponent.getIntValue(true);
        if (exponentInt.equals("0"))
            return new PreciseInt("1");
        if (exponentInt.equals("1"))
            return this;

        // guaranteed to be > 1
        // gets the last num to check if even or odd
        exponent.moveToPos(exponent.length() - 1);
        int lastNum = exponent.getValue();
        exponent.moveToStart();

        if (lastNum % 2 == 0) {
            // if last number in PreciseInt even
            exponent.divideBy2();

            PreciseInt valueToBeSquared = this.exponent(exponent);

            // squared
            return valueToBeSquared.multiply(valueToBeSquared, 0);
        }
        else {
            // if last number in PreciseInt odd
            exponent.decrement();

            // multiply by itself once
            return this.multiply(this.exponent(exponent), 0);
        }
    }

    /**
     * Helper method for the exponent method, but may also be useful elsewhere.
     */
    public void decrement() {

    }


    /**
     * Helper method for the exponent method
     */
    private void divideBy2() {

    }

}
