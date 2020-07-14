
/**
 * The test case for the RPNSolver Class.
 * 
 * @author Charlie Kelley (charlk21)
 * @version 2020.07.13
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
        String[] problem = {"12", "23", "+", "2", "*"}; // = 70
        String[] solution = testRPN.evaluate(problem);
        assertEquals(solution[solution.length-2], "=");        
        assertEquals(solution[solution.length-1], "70");
    }
    
    public void testEvaluateBad() {
        assertEquals(0, testRPN.binSize());
        String[] problem = {"+", "23", "+", "2", "*"};
        String[] solution = testRPN.evaluate(problem);
        assertEquals(solution[solution.length-2], "="); // "=" still appended despite bad input
        assertEquals(solution[solution.length-1], null); // no solution append because of incorrect equation
    }
}