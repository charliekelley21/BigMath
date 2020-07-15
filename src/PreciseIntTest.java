
/**
 * The test case for the PreciseInt Class.
 * 
 * @author Charlie Kelley (charlk21)
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.13
 */

import student.TestCase;

public class PreciseIntTest extends TestCase {
    // set up variables
    private PreciseInt test1;

    /**
     * The setUp for the PreciseInt testing
     */
    public void setUp() {
        test1 = new PreciseInt();
    }


    /**
     * Tests the getIntValue method of PreciseInt
     */
    public void testGetIntValue() {
        test1.append(4); // Test1 will hold
        test1.append(3); // a value of "1234"
        test1.append(2);
        test1.append(1);
        assertEquals(4, test1.length());
        assertEquals("1234", test1.getIntValue(true));
    }


    /**
     * Tests the constructor of PreciseInt
     */
    public void testConstructor() {
        test1 = new PreciseInt("52");
        assertEquals(2, test1.length());
        assertEquals("52", test1.getIntValue(true));

        test1 = new PreciseInt("0000000000000004395");
        assertEquals(4, test1.length());
        assertEquals("4395", test1.getIntValue(true));

        test1 = new PreciseInt("000");
        assertEquals(1, test1.length());
        assertEquals("0", test1.getIntValue(true));

        test1 = new PreciseInt("01");
        assertEquals(1, test1.length());
        assertEquals("1", test1.getIntValue(true));
    }


    /**
     * Tests the copy constructor of PreciseInt
     */
    public void testCopyConstructor() {
        PreciseInt test2 = new PreciseInt("52");
        test1 = new PreciseInt(test2);
        assertEquals(2, test1.length());
        assertEquals("52", test1.getIntValue(true));
    }


    public void testMultipleOperations() {
        // "99999999 990001 * 1119111 55565 33333 + * + 88888888 + =
        // 99099674628565"
        test1 = new PreciseInt("99999999");
        PreciseInt test2 = new PreciseInt("990001");
        PreciseInt test3 = test1.multiply(test2, 0);
        assertEquals("99000099009999", test3.getIntValue(true));

        PreciseInt test4 = new PreciseInt("1119111");
        PreciseInt test5 = new PreciseInt("55565");
        PreciseInt test6 = new PreciseInt("33333");

        PreciseInt test7 = test5.addition(test6, true, 0);
        PreciseInt test8 = test7.multiply(test4, 0);
        assertEquals(test8.getIntValue(true), "99486729678");

        PreciseInt test9 = test8.addition(test3, true, 0);
        assertEquals(test9.getIntValue(true), "99099585739677");

        PreciseInt test10 = new PreciseInt("88888888");
        PreciseInt solution = test10.addition(test9, true, 0);
        assertEquals(solution.getIntValue(true), "99099674628565");
    }


    /**
     * Tests the addition method of PreciseInt
     */
    public void testAddition() {
        PreciseInt test2 = new PreciseInt("52");
        test1 = new PreciseInt("49");
        PreciseInt test3 = test1.addition(test2, true, 0);
        assertEquals("101", test3.getIntValue(true));

        test2 = new PreciseInt("521");
        test1 = new PreciseInt("49");
        test3 = test1.addition(test2, true, 0);
        assertEquals("570", test3.getIntValue(true));

        test2 = new PreciseInt("999");
        test1 = new PreciseInt("2111111111");
        test3 = test1.addition(test2, true, 0);
        assertEquals("2111112110", test3.getIntValue(true));

        test2 = new PreciseInt("999");
        test1 = new PreciseInt("2111111111");
        test3 = test2.addition(test1, true, 0);
        assertEquals("2111112110", test3.getIntValue(true));
    }


    /**
     * Tests the multiply method of PreciseInt
     */
    public void testMultiply() {
        PreciseInt test2 = new PreciseInt("52");
        test1 = new PreciseInt("49");
        PreciseInt test3 = test1.multiply(test2, 0);
        assertEquals("2548", test3.getIntValue(true));

        test2 = new PreciseInt("521");
        test1 = new PreciseInt("49");
        test3 = test1.multiply(test2, 0);
        assertEquals("25529", test3.getIntValue(true));
    }


    /**
     * Tests the exponent method of PreciseInt
     */
    public void testExponent() {
        test1 = new PreciseInt("12");
        PreciseInt test2 = new PreciseInt("00");
        test1 = test1.exponent(test2);
        assertEquals("1", test1.getIntValue(true));
        test1 = new PreciseInt("12");
        test2 = new PreciseInt("1");
        test1 = test1.exponent(test2);
        assertEquals("12", test1.getIntValue(true));
        test1 = new PreciseInt("12");
        test2 = new PreciseInt("2");
        test1 = test1.exponent(test2);
        assertEquals("144", test1.getIntValue(true));
        test1 = new PreciseInt("5");
        test2 = new PreciseInt("3");
        test1 = test1.exponent(test2);
        assertEquals("125", test1.getIntValue(true));
    }


    /**
     * Tests the decrement method of PreciseInt
     */
    public void testDecrement() {
        test1 = new PreciseInt("1299934");
        test1.decrement(test1.head);
        assertEquals("1299933", test1.getIntValue(true));

        test1 = new PreciseInt("100");
        test1.decrement(test1.head);
        assertEquals("99", test1.getIntValue(true));
    }


    /**
     * Tests the divide method of PreciseInt
     */
    public void testDivide() {
        test1 = new PreciseInt("217");
        PreciseInt test2 = test1.divide(7);
        assertEquals("31", test2.getIntValue(true));

        test1 = new PreciseInt("313");
        test2 = test1.divide(3);
        assertEquals("104", test2.getIntValue(true));
    }
}
