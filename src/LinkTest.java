import student.TestCase;

/**
 * This class tests the Link class
 * 
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.11
 */
public class LinkTest extends TestCase {

    // set up variables
    private Link test1;
    private Link test2;
    private Link test3;

    /**
     * The setUp for the LList testing
     */
    public void setUp() {
        test1 = new Link(5, null);
        test2 = new Link(test1);
        test3 = new Link(6, test2);
    }


    /**
     * This tests the element function in Link
     */
    public void testElement() {
        assertEquals(6, test3.element());
        assertEquals(0, test2.element());
    }


    /**
     * This tests the setElement function in Link
     */
    public void testSetElement() {
        assertEquals(5, test3.setElement(5));
        assertEquals(5, test3.element());
    }


    /**
     * This tests the next function in Link
     */
    public void testNext() {
        assertEquals(test2, test3.next());
        assertEquals(test1, test2.next());
        assertNull(test1.next());
    }


    /**
     * This tests the setNext function in Link
     */
    public void testSetNext() {
        assertEquals(test2, test3.next());
        assertEquals(test1, test3.setNext(test1));
        assertEquals(test1, test3.next());
    }
}
