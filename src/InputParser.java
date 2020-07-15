
/**
 * 
 * This class is used to take an input file name, validate it and call the
 * RPNSolver class to solve the problems one at a time. It is also responsible
 * for printing the solutions.
 * 
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.10
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputParser {

    // Initialize private vars
    private RPNSolver solver;
    private File file;
    private String[] ans;
    private int numProblems;

    /**
     * This constructor creates a new InputParser object. It requires a String
     * of the text file's name or the path, and will throw a
     * FileNotFoundException
     * if it is not found.
     * 
     * @param textfile
     *            file's name
     * @throws FileNotFoundException
     *             The inputed file name is incorrect.
     */
    public InputParser(String textfile) throws FileNotFoundException {
        file = new File(textfile);
        if (!file.exists() || !file.isFile()) {
            throw new FileNotFoundException();
        }
        assignFileLength();
        ans = new String[numProblems];
        solver = new RPNSolver();
    }


    /**
     * This method will count how many valid problems so that ans knows how big
     * of a String array it needs to be
     * 
     * @return int of number of non-empty lines in file
     * @throws FileNotFoundException
     *             should be impossible
     */
    private void assignFileLength() throws FileNotFoundException {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(file);
        int count = 0;
        while (sc.hasNextLine()) {
            // counting valid file lines
            String line = sc.nextLine();
            line = properSpacing(line);
            if (line.split(" ").length > 2) {
                count++;
            }
        }
        numProblems = count;
    }


    /**
     * This will use the internal solver to get all the answers in the input
     * text file
     * 
     * @throws FileNotFoundException
     */
    public void evaluateTextFile() throws FileNotFoundException {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(file);
        int problemNumber = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            line = properSpacing(line);

            // gets the problem array
            String[] problem = line.split(" ");

            if (problem.length > 2) {
                // evaluate returns the answer in string array
                String[] answerToProblem = solver.evaluate(problem);

                String concatinationOfProblem = "";
                // rebuilds the answer to string
                for (int i = 0; i < answerToProblem.length; i++) {
                    concatinationOfProblem += answerToProblem[i];
                    if (i < answerToProblem.length - 1) {
                        concatinationOfProblem += " ";
                    }
                }
                
                // store in the ans array
                ans[problemNumber] = concatinationOfProblem;
                problemNumber++;
            }
        }
    }


    /**
     * This will get rid of the weird spacing in the input file.
     * 
     * @param unformatted
     *            The preprocessed String
     * @return The processed String
     */
    private String properSpacing(String unformatted) {
        char[] tocopy = unformatted.toCharArray();
        char[] answer = new char[tocopy.length];
        boolean addspace = false;
        int location = 0;
        for (int i = 0; i < tocopy.length; i++) {
            // copies chars to new array
            if (tocopy[i] != ' ') {
                addspace = true;
                answer[location] = tocopy[i];
                location++;
            }
            else {
                if (addspace) {
                    // adds one space after a segment of chars
                    answer[location] = ' ';
                    location++;
                    addspace = false;
                }
            }
        }
        // converts to string and gets rid of leading and following spaces
        return new String(answer).trim();
    }


    /**
     * Prints out all the answer Strings in the ans String array
     */
    public void printAnswers() {
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

}
