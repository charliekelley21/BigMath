import java.io.FileNotFoundException;
import student.TestCase;

/**
 * This class tests the InputParser class
 * 
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.10
 */
public class InputParserTest extends TestCase {
    private InputParser test;

    /**
     * This method sets up the testing
     */
    public void setUp() {
        try {
            test = new InputParser("src/test/BignumInput.txt");
        }
        catch (Exception e) {
            // This shouldn't happen
        }
    }


    /**
     * Tests that the output for the project is in the correct format.
     * 
     * @throws FileNotFoundException
     */
    public void testPrintAns() throws FileNotFoundException {
        test.evaluateTextFile();
        test.printAnswers();
        assertEquals(multiline(
            "56669777 99999911111 + 352324012 + 3 ^ 555557778 * = "
            + "562400792227677956625810678708149922000000",
            "99999999 990001 * 1119111 55565 33333 + * + 88888888 + "
            + "= 99099674628565",
            "123456789 1111111111 * 111119 2111111 9111111 * + * 1 ^ "
            + "= 2638486500477638652325851269760",
            "9 1 + 5 * 0 + = 50", "999999999 0 * = 0", "9 0 ^ = 1",
            "5555555 333333 5454353 999999 666666 1 ^ * * + = ",
            "3432 3333 9999 + * ^ * * 6666 + = "), systemOut().getHistory());
    }


    /**
     * 
     */
    public void testException() {
        try {
            test = new InputParser("notafile.txt");
        }
        catch (Exception e) {
            assertTrue(e instanceof FileNotFoundException);
        }
    }

}
