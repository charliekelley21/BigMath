import java.io.FileNotFoundException;
import student.TestCase;

/**
 * 
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.10
 */
public class InputParserTest extends TestCase {
    private InputParser test;

    /**
     * 
     * @throws FileNotFoundException 
     */
    public void setUp() {
        try {
            test = new InputParser("src/test/BignumInput.txt");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @throws FileNotFoundException 
     */
    public void testPrintAns() throws FileNotFoundException {
        test.evaluateTextFile();
        test.printAnswers();
        assertEquals(multiline(
            "000000056669777 99999911111 + 352324012 + 03 ^ 555557778 *",
            "99999999 990001 * 01119111 55565 33333 + * + 88888888 +",
            "123456789 1111111111 * 111119 2111111 9111111 * + * 1 ^",
            "9 1 + 5 * 00000000 +", "999999999 0 *", "9 0 ^",
            "5555555 333333 5454353 999999 666666 01 ^ * * +",
            "3432 3333 9999 + * ^ * * 6666 +"), systemOut().getHistory());
    }
    
    /**
     * 
     */
    public void testException() {
        try {
            test = new InputParser("notafile.txt");
        }
        catch (FileNotFoundException e) {
            assertNotNull(e);
        }
    }

}
