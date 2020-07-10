import java.io.FileNotFoundException;

/**
 * 
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.10
 */
public class InputParserTest {
    static InputParser test;
    
    public static void main(String[] args) {
        try {
            test = new InputParser("src/BignumInput.txt");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        test.evaluateTextFile();
        test.printAnswers();
    }
}
