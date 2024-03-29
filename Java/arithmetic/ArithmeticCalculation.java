package arithmetic;

import java.util.Stack;

public class ArithmeticCalculation {
	Stack<Integer> operand;
	Stack<Character> operator;
	
	public ArithmeticCalculation() {
		this.operand = new Stack<>();
		this.operator = new Stack<>();
	}
	
	public int calculate(String eq) {
		for (int i = 0; i < eq.length(); i++) {
			char ch = eq.charAt(i);
			if (ch == '(') continue;
			else if (ch == '+' || ch == '*') this.operator.push(ch);
			else if (ch == ')') {
				int n2 = this.operand.pop();
				int n1 = this.operand.pop();
				Character op = this.operator.pop();
				if (op == '*') this.operand.push(n1 * n2);
				else if (op == '+') this.operand.push(n1 + n2);
			}
			else this.operand.push(Character.getNumericValue(ch));
		}
		return this.operand.pop(); 
	}
	
	public static void main(String[] args) {
		ArithmeticCalculation o = new ArithmeticCalculation();
		String eq = "(1+((2+3)*(4*5)))";
		System.out.println(o.calculate(eq));
	}
}
