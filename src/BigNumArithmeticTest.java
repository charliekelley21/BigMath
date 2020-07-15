
/**
 * This class tests the BigNumArithmetic class
 * 
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.12
 */

import student.TestCase;

/**
 * Tests the BigNumArithmetic class
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.15
 *
 */
public class BigNumArithmeticTest extends TestCase {

    private static BigNumArithmetic test = new BigNumArithmetic();

    /**
     * Tests the main method of BigNumArithmetic
     */
    public void testMainNoArg() {
        try {
            BigNumArithmetic.main(new String[0]);
            assertEquals(multiline(
                "56669777 99999911111 + 352324012 + 3 ^ 555557778 * = 562400792227677956625810678708149922000000",
                "99999999 990001 * 1119111 55565 33333 + * + 88888888 + = 99099674628565",
                "123456789 1111111111 * 111119 2111111 9111111 * + * 1 ^ = 2638486500477638652325851269760",
                "9 1 + 5 * 0 + = 50", "999999999 0 * = 0", "9 0 ^ = 1",
                "5555555 333333 5454353 999999 666666 1 ^ * * + = ",
                "3432 3333 9999 + * ^ * * 6666 + = "), systemOut().getHistory());
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
            // empty in order to test main
        }
    }

}
