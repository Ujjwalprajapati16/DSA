
import java.util.Stack;

public class Duplicate_parentheses {
    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // closing
            if (ch == ')') {
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if (count < 1) {
                    return true;
                } else {
                    s.pop();
                }
            } else {
                // opening
                s.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "((a+b))";
        String s1 = "(a+b)";

        System.out.println(isDuplicate(s)); // Expected: true
        System.out.println(isDuplicate(s1)); // Expected: false
    }
}
