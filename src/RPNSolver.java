/**
 * This class is responsible for doing the Reverse Polish Notation logic.
 * 
 * @author Charlie Kelley (charlk21)
 * @version 2020.07.13
 */
public class RPNSolver {
    protected AStack<PreciseInt> bin;

    RPNSolver() {
        bin = new AStack<PreciseInt>();
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
        String[] solution = tokenize(problem);
        for (int i = 0; i < problem.length; i++) {
            String token = solution[i];
            if (isNum(token)) {
                bin.push(new PreciseInt(token)); // push PreciseInt objects onto
                                                 // stack
            }
            else {
                if (binSize() < 2) { // error check: each operation has two
                                     // PreciseInt objects to evaluate
                    return solution;
                }
                evaluateOperator(token); // evaluate each operation token
            }
        }
        if (binSize() > 1) { // error check: problem has balanced
            // equation, one solution
            return solution;
        }
        // append solution to the array to print
        solution[solution.length - 1] = bin.topValue().getIntValue(true);
        return solution;
    }
    
    /**
     * Cleans up the provided problem
     * @return cleaned array of problem Strings
     */
    public String[] tokenize(String[] tokens) {
        String[] prob = new String[tokens.length+2];
        for(int i = 0; i < tokens.length; i++) {
            switch(tokens[i]) {
                case "+":
                case "*":
                case "^":
                    prob[i] = tokens[i];
                    break;
                default:
                    PreciseInt temp = new PreciseInt(tokens[i]);
                    prob[i] = temp.getIntValue(true);
                    break;
            }
        }
        prob[prob.length-2] = "=";
        prob[prob.length-1] = "";
        return prob;
    }

    /**
     * Evaluates a given operator for a addition, multiplication, or
     * exponentiation on two PreciseInt objects
     * 
     * @param op
     *            string of operation to be performed
     */
    public void evaluateOperator(String op) {
        PreciseInt b = bin.pop();
        PreciseInt a = bin.pop();
        PreciseInt solution = new PreciseInt();
        switch (op) {
            case "+":
                solution = a.addition(b, true, 0);
                break;
            case "*":
                solution = a.multiply(b, 0);
                break;
            case "^":
                solution = a.exponent(b);
                break;
        }
        solution.cleanZeros();
        bin.push(solution);
    }


    /**
     * Checks if a given string contains a numeric value
     * 
     * @param str
     *            string to check for number
     * @return true if str holds a valid integer
     */
    public boolean isNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    /**
     * Method that returns the size of the internal stack
     * 
     * @return size of internal stack
     */
    public int binSize() {
        return bin.length();
    }

}
