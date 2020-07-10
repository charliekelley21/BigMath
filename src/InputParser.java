
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
     */
    private void assignFileLength() {
        Scanner sc = null;
        int count = 0;
        try {
            sc = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.split(" ").length > 2) {
                count++;
            }
        }
        numProblems = count;
    }


    /**
     * This will use the internal solver to get all the answers in the input
     * text file
     */
    public void evaluateTextFile() {
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int problemNumber = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            line = properSpacing(line);
            String[] problem = line.split(" ");
            if (problem.length > 2) {
                String answerToProblem = solver.evaluate(problem);
                String finalLine = "";
                for (int i = 0; i < problem.length; i++) {
                    finalLine += problem[i];
                    System.out.println("T: " + problem[i]);
                }
                finalLine += " = " + answerToProblem;
                ans[problemNumber] = finalLine;
                problemNumber++;
            }
        }
    }


    /**
     * This will get rid of the weird spacing in the input file. Condenses any
     * number of spaces to 1.
     * 
     * @param unformatted
     *            The preprocessed String
     * @return The processed String
     */
    private String properSpacing(String unformatted) {
        //TO-DO
        return null;
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
