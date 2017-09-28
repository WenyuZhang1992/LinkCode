import java.util.*;

class EvaluateReversePolishNotation {

	/**
 	 * Evaluate Reverse Polish Notation
  	 *
 	 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
	 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 	 *
 	 * Example: ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 	 *          ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 	 *
 	 *  Time: O(n)
     * Space: O(1)
     *
 	 */
	public static int evalRPN(String[] tokens) {
		if (tokens == null) {
            return Integer.MIN_VALUE;
        }
        
        Stack<Integer> si = new Stack<Integer>();
        
        for (int i=0; i<tokens.length; i++) {
            if (tokens[i].charAt(0) > '9' || tokens[i].charAt(0) < '0') {
                int operand2 = si.pop();
                int operand1 = si.pop();
                switch (tokens[i]) {
                    case "+":
                        si.push(operand1 + operand2);
                        break;
                    case "-":
                        si.push(operand1 - operand2);
                        break;
                    case "*":
                        si.push(operand1 * operand2);
                        break;
                    case "/":
                        si.push(operand1 / operand2);
                        break;
                }
            } else {
                si.push(Integer.parseInt(tokens[i]));
            }
        }

        return si.pop();
	}
}