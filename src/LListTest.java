
/**
 * The test case for the LList Class.
 * 
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.11
 */

import java.util.NoSuchElementException;
import student.TestCase;

public class LListTest extends TestCase {
    // set up variables
    private LList test1;

    /**
     * The setUp for the LList testing
     */
    public void setUp() {
        test1 = new LList();
    }


    /**
     * Tests the insert method of LList
     */
    public void testInsert() {
        test1.insert(6);
        test1.insert(6);
        test1.insert(6);
        test1.insert(6);
        test1.insert(6);
        test1.insert(6);
        assertEquals(6, test1.length());
    }


    /**
     * Tests the remove method of LList
     */
    public void testRemove() {
        try {
            test1.remove();
        }
        catch (Exception e) {
            assertTrue(e instanceof NoSuchElementException);
        }
        for (int i = 0; i < 10; i++) {
            test1.insert(i);
        }
        int test = test1.remove();
        assertEquals(9, test);
        for (int i = 0; i < 9; i++) {
            test1.remove();
        }
        assertTrue(test1.isEmpty());
    }


    /**
     * Tests the append method of LList
     */
    public void testAppend() {
        test1.append(6);
        test1.append(6);
        test1.append(6);
        test1.append(6);
        test1.append(6);
        test1.append(6);
        assertEquals(6, test1.length());
    }


    /**
     * Tests the moveToStart method of LList
     */
    public void testMoveToStart() {
        for (int i = 0; i < 10; i++) {
            test1.append(i);
        }
        test1.moveToStart();
        assertEquals(0, test1.getValue());
    }


    /**
     * Tests the moveToEnd method of LList
     */
    public void testMoveToEnd() {
        for (int i = 0; i < 10; i++) {
            test1.append(i);
        }
        test1.moveToEnd();
        test1.prev();
        assertEquals(9, test1.getValue());
    }


    /**
     * Tests the next method of LList
     */
    public void testNext() {
        for (int i = 0; i < 10; i++) {
            test1.append(i);
        }
        assertEquals(0, test1.getValue());
        test1.next();
        assertEquals(1, test1.getValue());
        test1.next();
        assertEquals(2, test1.getValue());
        for (int i = 0; i < 10; i++) {
            test1.next();
        }
        assertEquals(10, test1.currPos());
    }


    /**
     * Tests the length method of LList
     */
    public void testLength() {
        test1.append(6);
        test1.append(6);
        test1.append(6);
        test1.append(6);
        test1.append(6);
        test1.append(6);
        assertEquals(6, test1.length());
    }


    /**
     * Tests the prev method of LList
     */
    public void testPrev() {
        test1.prev();
        for (int i = 0; i < 10; i++) {
            test1.append(i);
        }
        test1.prev();
        test1.moveToPos(8);
        assertEquals(8, test1.getValue());
    }


    /**
     * Tests the curPos method of LList
     */
    public void testCurrPos() {
        for (int i = 0; i < 10; i++) {
            test1.append(i);
        }
        for (int i = 0; i < 10; i++) {
            test1.next();
        }
        assertEquals(10, test1.currPos());
    }


    /**
     * Tests the movToPos method of LList
     */
    public void testMovToPos() {
        for (int i = 0; i < 10; i++) {
            test1.append(i);
        }
        assertTrue(test1.moveToPos(5));
        assertEquals(5, test1.getValue());
        assertFalse(test1.moveToPos(-5));
        assertEquals(5, test1.getValue());
        assertFalse(test1.moveToPos(50));
        assertEquals(5, test1.getValue());
    }


    /**
     * Tests the isAtEnd method of LList
     */
    public void testIsAtEnd() {
        assertTrue(test1.isAtEnd());
        for (int i = 0; i < 10; i++) {
            test1.append(i);
        }
        assertFalse(test1.isAtEnd());
        for (int i = 0; i < 10; i++) {
            test1.next();
        }
        assertTrue(test1.isAtEnd());
    }


    /**
     * Tests the isEmpty method of LList
     */
    public void testIsEmpty() {
        assertTrue(test1.isEmpty());
        test1.append(3);
        assertFalse(test1.isEmpty());
    }


    /**
     * Tests the getValue() method of LList
     */
    public void testGetValue() {
        for (int i = 0; i < 10; i++) {
            test1.append(i);
        }
        test1.prev();
        test1.moveToPos(8);
        assertEquals(8, test1.getValue());
        for (int i = 0; i < 10; i++) {
            test1.next();
        }
        try {
            test1.getValue();
        }
        catch (Exception e) {
            assertTrue(e instanceof NoSuchElementException);
        }
    }
}
