
/**
 * This class tests the BigNumArithmetic class
 * 
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.12
 */

import student.TestCase;

public class BigNumArithmeticTest extends TestCase {

    private static BigNumArithmetic test = new BigNumArithmetic();

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
    @SuppressWarnings("static-access")
    public void testMain() {
        String[] arg = new String[] { "src/test/BignumInput.txt" };
        try {
            test.main(arg);
        }
        catch (Exception e) {
        }
    }

}
