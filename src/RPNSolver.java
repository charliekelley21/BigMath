/**
 * 
 * @author Charlie Kelley (charlk21)
 * @version 2020.07.10
 */
public class RPNSolver {
    AStack<PreciseInt> bin;
    
    RPNSolver() {
        bin.clear();
    }
    
    /**
     * This will take in a String array with the operations and the PreciseInts
     * and return a string of the final ans
     * 
     * @param problem String[] parsed from the InputParser
     * @return String of the ans
     */
    public String[] evaluate(String[] problem) {
        bin.clear();
        String[] solution = new String[problem.length+2];
        for( String token: problem) {
            // if (num)
                // store PreciseInt on stack
            // if (+*^)
                // check stack has 2 PreciseInt objects available
                // add..
            // else
                // throw error
        }
        return solution;
    }

}