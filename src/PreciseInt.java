
/**
 * Infinite precision integer, stored within a linked list
 * 
 * @author Charlie Kelley (charlk21)
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.15
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
     * @param num
     *            String
     *            holding the value of a large integer with infinite precision
     */
    PreciseInt(String num) {
        clear();
        for (int i = 1; i <= num.length(); i++) {
            char c = num.charAt(num.length() - i);
            int digit = Character.getNumericValue(c);
            append(digit); // append digit to PreciseInt
        }
        cleanZeros();
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
     * @return sum of two PreciseInt objects
     */
    public PreciseInt addition(PreciseInt addend, boolean start, int carry) {
        if (start) { // Initialize first call so that
            moveToStart(); // addition starts at the beginning
            addend.moveToStart(); // of both PreciseInt objects
        }
        if (isAtEnd()) { // extend first addend if the end is reached
            if (addend.isAtEnd()) {
                if (carry != 0) {
                    append(carry);
                }
                return this;
            }
            append(0);
        }
        int addendValue = addend.isAtEnd() ? 0 : addend.getValue();
        int sum = getValue() + addendValue + carry; // get the sum of
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
     * @return product of two PreciseInt objects
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
        if (carry != 0) {
            temp.append(carry);
        }
        next(); // shift current digit being multiplied
        // sum together the product of every digit by the multiplicand
        return temp.addition(multiply(multiplicand, shift + 1), true, 0);
    }


    /**
     * This is an exponentiation method for the PreciseInt class.
     * 
     * @return PreciseInt the result of the operation
     * @param exponent
     *            This PreciseInt ^ exponent.
     * @return exponentiation of two PreciseInt objects
     */
    public PreciseInt exponent(PreciseInt exponent) {
        // if exponent 0 or 1 return 1 or this respectively
        String exponentInt = exponent.getIntValue(true);
        if (exponentInt.equals("0")) {
            PreciseInt temp = new PreciseInt("1");
            return temp;
        }
        if (exponentInt.equals("1")) {
            // anything > 1 should converge to 1. Base Case.
            return this;
        }

        // guaranteed to be > 1
        // gets the last num to check if even or odd
        int curr = exponent.currPos();
        exponent.moveToStart();
        int lastNum = exponent.getValue();
        exponent.moveToPos(curr);

        if (lastNum % 2 == 0) {
            // if last number in PreciseInt even
            PreciseInt newExponent = exponent.divide(2);

            PreciseInt valueToBeSquared = this.exponent(newExponent);
            PreciseInt temp = new PreciseInt(valueToBeSquared);
            // squared
            return valueToBeSquared.multiply(temp, 0);
        }
        else {
            // if last number in PreciseInt odd
            exponent.decrement(exponent.head);
            // multiply by itself once
            return this.multiply(this.exponent(exponent), 0);
        }
    }


    /**
     * Helper method for the exponent method, but may also be useful elsewhere.
     * assumes that the value is always greater than or equal to 1.
     * 
     * @param node
     *            link in list to decrement
     */
    public void decrement(Link node) {
        int v = node.element(); // get value of current node
        if (v == 0) { // borrow if needed using recursive call on next node
            node.setElement(9);
            decrement(node.next());
        }
        else { // base case: decrease value without borrowing
            node.setElement(v - 1);
        }
        moveToPos(length() - 1); // check if borrowing left a stray 0
        if (getValue() == 0) {
            remove();
        }
    }


    /**
     * Helper method for the exponent method
     * Guaranteed to be even to return a whole number.
     * 
     * @param divisor
     *            single digit value to divide by
     * @return PrecseInt object divided by divisor
     */
    public PreciseInt divide(int divisor) {
        PreciseInt quotient = new PreciseInt();
        moveToPos(length() - 1);
        int dividend;
        int remainder = 0;
        while (head.next() != curr) {
            dividend = (remainder * 10) + getValue();
            quotient.moveToStart();
            quotient.insert(dividend / divisor);
            remainder = dividend - ((dividend / divisor) * divisor);
            prev();
        }
        quotient.insert((remainder * 10 + getValue()) / divisor);
        quotient.moveToPos(quotient.length() - 1);
        if (quotient.getValue() == 0) {
            quotient.remove();
        } // check for leading 0's
        return quotient;
    }


    /**
     * Method cleans any leading zeros while allowing for a PreciseInt
     * to hold a value of zero
     */
    public void cleanZeros() {
        if (length() == 0) {
            return;
        }
        moveToPos(length() - 1);
        if ((getValue() == 0) && (length() > 1)) {
            remove();
            cleanZeros();
        }
        else {
            return;
        }
    }

}
