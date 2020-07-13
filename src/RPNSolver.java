/**
 * This class is responsible for doing the Reverse Polish Notation logic.
 * 
 * @author Charlie Kelley (charlk21)
 * @version 2020.07.13
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
     * @param problem
     *            String[] parsed from the InputParser
     * @return String of the problem and answer
     */
    public String[] evaluate(String[] problem) {
        bin.clear(); // clear stack for each problem
        String[] solution = new String[problem.length + 2]; // copy problem to
                                                            // solution
        for (int i = 0; i < problem.length; i++) { // copy each element of
                                                   // problem
            solution[i] = problem[i];
        }
        solution[solution.length - 2] = "="; // append "=" for solution
        for (String token : problem) { // process each token
            if (isNum(token)) {
                bin.push(new PreciseInt(token)); // push PreciseInt objects onto
                                                 // stack
            }
            else {
                if (bin.length() < 2) { // error check: each operation has two
                                        // PreciseInt objects to evaluate
                    return solution;
                }
                evaluateOperator(token); // evaluate each operation token
            }
            if (bin.length() > 1) { // error check: problem has balanced
                                    // equation, one solution
                return solution;
            }
            // append solution to the array to print
            solution[solution.length - 1] = bin.topValue().getIntValue(true);
        }
        return solution;
    }


    /**
     * Evaluates a given operator for a addition, multiplication, or
     * exponentiation on two PreciseInt objects
     * 
     * @param op
     *            string of operation to be performed
     */
    public void evaluateOperator(String op) {
        PreciseInt a = bin.pop();
        PreciseInt b = bin.pop();
        switch (op) {
            case "+":
                bin.push(a.addition(b, true, 0));
            case "*":
                bin.push(a.multiply(b, true, 0));
            case "^":
                bin.push(a.exponent(b));
        }
    }


    /**
     * Checks if a given string contains a numeric value
     * 
     * @param str
     *            string to check for number
     * @return true if str holds a valid integer
     */
    public boolean isNum(String str) {
        try {
            Integer.parseInt(str);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
