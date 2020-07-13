
/**
 * The test case for the PreciseInt Class.
 * 
 * @author Charlie Kelley (charlk21)
 * @version 2020.07.11
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

        test1 = new PreciseInt("0004395");
        assertEquals(4, test1.length());
        assertEquals("4395", test1.getIntValue(true));
    }


    /**
     * Tests the copy constructor of PreciseInt
     */
    public void testCopyConstructor() {
        PreciseInt test2 = new PreciseInt("52");
        PreciseInt test1 = new PreciseInt(test2);
        assertEquals(2, test1.length());
        assertEquals("52", test1.getIntValue(true));
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
}
