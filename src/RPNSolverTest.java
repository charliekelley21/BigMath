
/**
 * The test case for the RPNSolver Class.
 * 
 * @author Charlie Kelley (charlk21)
 * @version 2020.07.14
 */

import student.TestCase;

public class RPNSolverTest extends TestCase {
    // set up variables
    private RPNSolver testRPN;

    /**
     * The setUp for the PreciseInt testing
     */
    public void setUp() {
        testRPN = new RPNSolver();
    }


    /**
     * Tests the evaluate method of RPNSolver with a valid problem
     */
    public void testEvaluateGood() {
        assertEquals(0, testRPN.binSize());
        String[] problem = { "12", "23", "+", "2", "*" }; // = 70
        String[] solution = testRPN.evaluate(problem);
        assertEquals(solution[solution.length - 2], "=");
        assertEquals(solution[solution.length - 1], "70");

        String[] problem2 = {"22", "24", "+", "2", "^"};   // testing repeated solutions on same RPNSolver object
        solution = testRPN.evaluate(problem2);
        assertEquals(solution[solution.length-2], "="); // "=" still appended despite bad input
        assertEquals(solution[solution.length-1], "2116"); // no solution append because of incorrect equation

        // [000000056669777, 99999911111, +, 352324012, +, 03, ^, 555557778, *]
        // This is the first problem
        String[] problem4 = { "000000056669777", "99999911111", "+",
            "352324012", "+", "03", "^", "555557778", "*" };
        solution = testRPN.evaluate(problem4);
        assertEquals(solution[solution.length - 2], "=");
        assertEquals(solution[solution.length - 1],
            "562400792227677956625810678708149922000000");

        String[] problem3 = {"99999999", "990001", "*", "1119111", "55565", "33333", 
                                "+", "*", "+", "88888888", "+"}; // = 99099674628565
        solution = testRPN.evaluate(problem3);
        assertEquals(solution[solution.length-2], "=");
        assertEquals(solution[solution.length-1], "99099674628565");
    }


    public void testEvaluateBad() {
        assertEquals(0, testRPN.binSize());
        String[] problem = { "+", "23", "+", "2", "*" };
        String[] solution = testRPN.evaluate(problem);
        assertEquals(solution[solution.length - 2], "="); // "=" still appended
                                                          // despite bad input
        assertEquals(solution[solution.length - 1], ""); // no solution append
                                                           // because of
                                                           // incorrect equation

        String[] problem2 = { "22", "24", "34", "2", "*" };
        solution = testRPN.evaluate(problem2);
        assertEquals(solution[solution.length - 2], "="); // "=" still appended
                                                          // despite bad input
        assertEquals(solution[solution.length - 1], ""); // no solution append
                                                           // because of
                                                           // incorrect equation
    }
}
