
/**
 * BigNumArithmetic Project Runner class
 * 
 * "I have not given nor received unauthorized assistance on this assignment" -
 * BF, CK
 * 
 * @author Charlie Kelley (charlk21)
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.10
 */

import java.io.FileNotFoundException;
import java.lang.IllegalArgumentException;

public class BigNumArithmetic {

    /**
     * This is the main method for the entire project.
     * 
     * @param args
     *            The command line args that are passed into the project
     * @throws FileNotFoundException
     *             error on incorrect filename
     */
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            throw new IllegalArgumentException();
        }
        InputParser parse = null;
        // attempt to initialize parse
        parse = new InputParser(args[0]);
        parse.evaluateTextFile();
        parse.printAnswers();
    }

}
