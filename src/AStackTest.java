import student.TestCase;

/**
 * This class is responsible for testing the AStack class
 * 
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.15
 */
public class AStackTest extends TestCase {

    // The test stack
    private AStack<PreciseInt> test1;
    private AStack<PreciseInt> test2;

    /**
     * This sets up the AStack testing
     */
    public void setUp() {
        test1 = new AStack<PreciseInt>();
        test2 = new AStack<PreciseInt>(30);
    }


    /**
     * Tests the push method of AStack.
     */
    public void testPush() {
        test1.push(new PreciseInt("0"));
        assertEquals(test1.length(), 1);
        test1.clear();
        assertEquals(test1.length(), 0);
        test1.push(new PreciseInt("0"));
        PreciseInt test = test1.pop();
        assertNotNull(test);
        for (int i = 0; i < 50; i++) {
            test2.push(new PreciseInt("" + i));
        }
    }


    /**
     * Tests the pop method of AStack
     */
    public void testPop() {
        PreciseInt test = test1.pop();
        assertNull(test);
        test2.push(new PreciseInt("20"));
        test = test2.pop();
        assertNotNull(test);
    }


    /**
     * Tests the topValue method of AStack
     */
    public void testTopValue() {
        assertNull(test2.topValue());
        test1.push(new PreciseInt("0"));
        test2.push(new PreciseInt("0"));
        assertNotNull(test1.topValue());
        assertNotNull(test2.topValue());
    }


    /**
     * Tests the length() method of the AStack
     */
    public void testLength() {
        test1.push(new PreciseInt("0"));
        assertEquals(test1.length(), 1);
        for (int i = 0; i < 100; i++) {
            test1.push(new PreciseInt("" + i));
        }
        assertEquals(100, test1.length());
        test1.pop();
        assertEquals(99, test1.length());
    }


    /**
     * Tests the isEmpty method of the AStack
     */
    public void testIsEmpty() {
        assertTrue(test1.isEmpty());
        assertTrue(test2.isEmpty());
        test1.push(new PreciseInt("0"));
        test2.push(new PreciseInt("0"));
        assertFalse(test1.isEmpty());
        assertFalse(test2.isEmpty());
        test1.pop();
        test2.clear();
        assertTrue(test1.isEmpty());
        assertTrue(test2.isEmpty());
    }

}
