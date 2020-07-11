
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
        assertEquals(test1.length(), 6);
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
        assertEquals(test, 9);
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
        assertEquals(test1.length(), 6);
    }

    
    
    /**
     * Tests the moveToStart method of LList
     */
    public void testMoveToStart() {
        for (int i = 0; i < 10; i++) {
            test1.insert(i);
        }
        test1.moveToStart();
        assertEquals(test1.currPos(), 0);
    }
    
    
    /**
     * Tests the moveToEnd method of LList
     */
    public void testMoveToEnd() {
        for (int i = 0; i < 10; i++) {
            test1.insert(i);
            System.out.println(""+ i);
        }
        test1.moveToStart();
        assertEquals(0, test1.currPos());
        assertEquals(10, test1.length());
        test1.moveToEnd();
        assertEquals(9, test1.currPos());        
    }
}
