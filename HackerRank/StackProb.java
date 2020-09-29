import java.util.Scanner;
import java.util.Stack;

class StackProb {

	public static boolean check(String input) {
		String open = "({[";
		String close = ")}]";
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			if (open.contains(input.substring(i, i + 1))) {
				stack.push(input.charAt(i));
			} else if (close.contains(input.substring(i, i + 1))) {
				if (stack.empty())
					stack.push(input.charAt(i));
				else {
					char ch = stack.peek();
					if (input.charAt(i) == ')' && ch == '(') {
						stack.pop();
					} else if (input.charAt(i) == ']' && ch == '[') {
						stack.pop();
					} else if (input.charAt(i) == '}' && ch == '{') {
						stack.pop();
					} else {
						return false;
					}
				}
			}
		}
		return stack.empty();
	}

	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String input = sc.next();
			System.out.println(check(input));
		}

	}
}
