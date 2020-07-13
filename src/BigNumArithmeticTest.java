
/**
 * This class tests the BigNumArithmetic class
 * 
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.12
 */

import student.TestCase;

public class BigNumArithmeticTest extends TestCase {

    /**
     * Tests the main method of BigNumArithmetic
     */
    public void testMainNoArg() {
        try {
            BigNumArithmetic.main(new String[0]);
        }
        catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }


    /**
     * Tests the main method of BigNumArithmetic
     */
    public void testMain() {
        String[] arg = new String[] { "src/test/BignumInput.txt" };
        try {
            BigNumArithmetic.main(arg);
        }
        catch (Exception e) {
        }
    }

}
